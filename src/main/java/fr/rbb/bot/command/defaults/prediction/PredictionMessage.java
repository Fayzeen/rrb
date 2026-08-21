package fr.rbb.bot.command.defaults.prediction;

import fr.rbb.bot.util.Placeholder;
import org.jetbrains.annotations.NotNull;

public enum PredictionMessage {
  TITLE("### {game} {emoji}"),
  BODY(
      "-# **» INFORMATIONS**\n"
          + "▪ Rôle: **{role}**.\n"
          + "▪ Condition de Victoire: **{win}**.\n"
          + "-# **» STATISTIQUES**\n"
          + "▪ Drop: **{self_drops}**x par vous. (Global: **{total_drops}**)\n"
          + "▪ Perso: #**{rate}** de vos personnages drops."),
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
