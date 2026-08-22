package fr.rrb.bot.command.defaults.profile;

import fr.rrb.bot.command.CommandBuilder;
import fr.rrb.bot.command.defaults.prediction.GameMode;
import fr.rrb.bot.command.defaults.prediction.role.Role;
import fr.rrb.bot.drop.DropRepository;
import fr.rrb.bot.profile.ProfileStats;
import fr.rrb.bot.util.Placeholder;
import java.sql.SQLException;
import java.util.List;
import net.dv8tion.jda.api.components.MessageTopLevelComponent;
import net.dv8tion.jda.api.components.container.Container;
import net.dv8tion.jda.api.components.textdisplay.TextDisplay;
import net.dv8tion.jda.api.interactions.callbacks.IReplyCallback;
import org.incendo.cloud.context.CommandContext;
import org.incendo.cloud.description.Description;
import org.incendo.cloud.discord.jda6.JDA6CommandManager;
import org.incendo.cloud.discord.jda6.JDAInteraction;
import org.incendo.cloud.discord.slash.CommandScope;

import static fr.rrb.bot.util.Constant.*;

public final class ProfileCommand implements CommandBuilder {

  private final DropRepository dropRepository;

  public ProfileCommand(final DropRepository dropRepository) {
    this.dropRepository = dropRepository;
  }

  @Override
  public void register(final JDA6CommandManager<JDAInteraction> commandManager) {
    LOGGER.info("Loading ProfileCommand");

    commandManager.command(
        commandManager
            .commandBuilder("profil", Description.of("Allows you to access your profile."))
            .apply(CommandScope.guilds(DEBUG_GUILD_ID, SERVER_GUILD_ID))
            .handler(this::execute));
  }

  private void execute(final CommandContext<JDAInteraction> context) {
    final IReplyCallback callback = context.sender().replyCallback();
    if (callback == null) {
      return;
    }

    final ProfileStats stats;
    try {
      stats = this.dropRepository.profile(context.sender().user().getIdLong());
    } catch (final SQLException exception) {
      LOGGER.error("Error retrieving profile.", exception);
      callback.reply("An error occurred.").setEphemeral(true).queue();
      return;
    }

    final String roleName;
    if (stats.role() == null) {
      roleName = "None";
    } else {
      final GameMode gameMode = GameMode.byName(stats.gameMode());
      final Role role = gameMode == null ? null : gameMode.roleById(stats.role());
      roleName = role == null ? stats.role() : role.displayName();
    }

    final List<MessageTopLevelComponent> components =
        List.of(
            Container.of(
                TextDisplay.of("###  <:recapitulatif:1539076029669183560> I VOTRE PROFIL"),
                TextDisplay.of(
                    ProfileMessage.BODY.formatMessage(
                        new Placeholder("ranking", stats.ranking()),
                        new Placeholder("role", roleName),
                        new Placeholder("dropped", stats.dropped())))));

    callback.replyComponents(components).useComponentsV2().setEphemeral(true).queue();
  }
}
