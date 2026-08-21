package fr.rbb.bot.command.defaults.prediction.child;

import fr.rbb.bot.command.defaults.prediction.GameMode;
import fr.rbb.bot.command.defaults.prediction.PredictionMessage;
import fr.rbb.bot.command.defaults.prediction.role.Role;
import fr.rbb.bot.drop.DropRepository;
import fr.rbb.bot.drop.DropStats;
import fr.rbb.bot.util.Placeholder;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import net.dv8tion.jda.api.components.container.Container;
import net.dv8tion.jda.api.components.mediagallery.MediaGallery;
import net.dv8tion.jda.api.components.mediagallery.MediaGalleryItem;
import net.dv8tion.jda.api.components.textdisplay.TextDisplay;
import net.dv8tion.jda.api.interactions.callbacks.IReplyCallback;
import org.incendo.cloud.context.CommandContext;
import org.incendo.cloud.discord.jda6.JDAInteraction;

import static fr.rbb.bot.util.Constant.LOGGER;

public final class PredictionGameModeCommand {

  private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  private static final String FALLBACK_IMAGE_URL =
      "https://wd40.theking90000.be/files/37562e41-79b1-4f1a-b527-5370e2dda366";

  private final DropRepository dropRepository;

  public PredictionGameModeCommand(final DropRepository dropRepository) {
    this.dropRepository = dropRepository;
  }

  public void execute(final CommandContext<JDAInteraction> context) {
    final IReplyCallback callback = context.sender().replyCallback();
    if (callback == null) {
      return;
    }

    final GameMode gameMode = context.get("game");
    final List<Role> roles = gameMode.roles();
    if (roles.isEmpty()) {
      callback.reply("No roles available.").setEphemeral(true).queue();
      return;
    }

    final Role role = roles.get(ThreadLocalRandom.current().nextInt(roles.size()));
    final long userId = context.sender().user().getIdLong();

    final DropStats stats;
    try {
      this.dropRepository.insert(userId, gameMode.name(), role.id());
      stats = this.dropRepository.stats(userId, gameMode.name(), role.id());
    } catch (final SQLException exception) {
      LOGGER.error("Error while saving the drop", exception);
      callback.reply("An error occurred.").setEphemeral(true).queue();
      return;
    }

    String image = role.imageUrl();
    final String imageUrl = image == null || image.isBlank() ? FALLBACK_IMAGE_URL : image;

    final Container container =
        Container.of(
                TextDisplay.of(
                    PredictionMessage.TITLE.formatMessage(
                        new Placeholder("game", gameMode.displayName()),
                        new Placeholder("emoji", gameMode.emoji()))),
                TextDisplay.of(
                    PredictionMessage.BODY.formatMessage(
                        new Placeholder("role", role.displayName()),
                        new Placeholder("win", role.winCondition()),
                        new Placeholder("self_drops", stats.selfDrops()),
                        new Placeholder("total_drops", stats.totalDrops()),
                        new Placeholder("rate", stats.rank()))),
                MediaGallery.of(MediaGalleryItem.fromUrl(imageUrl)),
                TextDisplay.of(
                    PredictionMessage.FOOTER.formatMessage(
                        new Placeholder("date", LocalDate.now().format(DATE_FORMAT)))))
            .withAccentColor(gameMode.accentColor());

    callback.replyComponents(container).useComponentsV2().queue();
  }
}
