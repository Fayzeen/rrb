package fr.rrb.bot;

import fr.rrb.bot.command.CommandBuilder;
import fr.rrb.bot.command.defaults.prediction.PredictionCommand;
import fr.rrb.bot.command.defaults.profile.ProfileCommand;
import fr.rrb.bot.database.Database;
import fr.rrb.bot.drop.DropRepository;
import java.sql.SQLException;
import java.util.List;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import org.incendo.cloud.discord.jda6.JDA6CommandManager;
import org.incendo.cloud.discord.jda6.JDAInteraction;
import org.incendo.cloud.execution.ExecutionCoordinator;

import static fr.rrb.bot.util.Constant.*;

public final class Bot {

  private final JDA jda;
  private final JDA6CommandManager<JDAInteraction> commandManager;
  private final Database database;
  private final DropRepository dropRepository;

  public Bot(final String token) throws InterruptedException {
    try {
      this.database = new Database("bot.db");
    } catch (final SQLException exception) {
      throw new IllegalStateException("Unable to open the database.", exception);
    }
    this.dropRepository = new DropRepository(this.database.connection());

    this.jda =
        JDABuilder.createDefault(token)
            .setStatus(OnlineStatus.DO_NOT_DISTURB)
            .setActivity(Activity.customStatus("RandomRoleBot"))
            .build();

    this.jda.awaitReady();

    this.commandManager =
        new JDA6CommandManager<>(
            ExecutionCoordinator.simpleCoordinator(), JDAInteraction.InteractionMapper.identity());

    this.jda.addEventListener(this.commandManager.createListener());

    this.registerCommands();

    this.registerGuildCommands(SERVER_GUILD_ID);
    this.registerGuildCommands(DEBUG_GUILD_ID);
  }

  private void registerCommands() {
    final List<CommandBuilder> commands =
        List.of(
            new PredictionCommand(this.dropRepository), new ProfileCommand(this.dropRepository));

    for (final CommandBuilder command : commands) {
      command.register(this.commandManager);
    }
  }

  private void registerGuildCommands(final long guildId) {
    final Guild guild = this.jda.getGuildById(guildId);
    if (guild == null) {
      throw new IllegalStateException("Guild with ID " + guildId + " not found.");
    }

    this.commandManager.registerGuildCommands(guild);
  }

  public JDA jda() {
    return this.jda;
  }

  public JDA6CommandManager<JDAInteraction> commandManager() {
    return this.commandManager;
  }

  public Database database() {
    return this.database;
  }
}
