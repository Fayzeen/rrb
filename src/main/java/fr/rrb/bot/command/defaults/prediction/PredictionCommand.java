package fr.rrb.bot.command.defaults.prediction;

import fr.rrb.bot.command.CommandBuilder;
import fr.rrb.bot.command.defaults.prediction.child.PredictionGameModeCommand;
import fr.rrb.bot.drop.DropRepository;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.incendo.cloud.description.Description;
import org.incendo.cloud.discord.jda6.JDA6CommandManager;
import org.incendo.cloud.discord.jda6.JDAInteraction;
import org.incendo.cloud.discord.slash.CommandScope;
import org.incendo.cloud.discord.slash.DiscordChoices;
import org.incendo.cloud.discord.slash.DiscordOptionChoice;
import org.incendo.cloud.parser.standard.EnumParser;

import static fr.rrb.bot.util.Constant.*;

public final class PredictionCommand implements CommandBuilder {

  private final PredictionGameModeCommand gameModeCommand;

  public PredictionCommand(final DropRepository dropRepository) {
    this.gameModeCommand = new PredictionGameModeCommand(dropRepository);
  }

  @Override
  public void register(final JDA6CommandManager<JDAInteraction> commandManager) {
    LOGGER.info("Loading PredictionCommand");

    final var choices =
        DiscordChoices.<JDAInteraction, String>choices(
            Arrays.stream(GameMode.values())
                .map(mode -> DiscordOptionChoice.of(mode.displayName(), mode.name()))
                .collect(Collectors.toList()));

    commandManager.command(
        commandManager
            .commandBuilder("prediction", Description.of("Allows you to launch a prediction."))
            .required(
                "game",
                EnumParser.enumParser(GameMode.class),
                Description.of("Choose the game mode."),
                choices)
            .apply(CommandScope.guilds(DEBUG_GUILD_ID, SERVER_GUILD_ID))
            .handler(gameModeCommand::execute));
  }
}
