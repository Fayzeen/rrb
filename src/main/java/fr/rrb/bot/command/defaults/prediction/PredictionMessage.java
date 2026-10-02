package fr.rrb.bot.command.defaults.prediction;

import fr.rrb.bot.util.Placeholder;
import org.jetbrains.annotations.NotNull;

public enum PredictionMessage {
  TITLE("### {game} {emoji}"),
  BODY(
      "-# **» INFORMATION**\n"
          + "▪ Role: **{role}**.\n"
          + "▪ Victory Condition: **{win}**.\n"
          + "-# **» STATISTICS**\n"
          + "▪ Drops: **{self_drops}**x for you. (Global: **{total_drops}**)\n"
          + "▪ Character: #**{rate}** of your character drops."),
  FOOTER("-# Collectif UHC I {date}");

  private final String content;

  PredictionMessage(final String content) {
    this.content = content;
  }

  public @NotNull String formatMessage(final @NotNull Placeholder... placeholders) {
    var formattedContent = this.content;
    for (final var placeholder : placeholders) {
      formattedContent =
          formattedContent.replace('{' + placeholder.key() + '}', placeholder.value());
    }
    return formattedContent;
  }
}
