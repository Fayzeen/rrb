package fr.rrb.bot.command.defaults.profile;

import fr.rrb.bot.util.Placeholder;

public enum ProfileMessage {
  BODY(
      "> <:profil:1539076077656481812> » **Ranking**: #**{ranking}** of the bot's rolls.\n"
          + "> <:drop:1539075983783628840> » **Most dropped**: **{role}** (**{dropped} times**).");

  private final String content;

  ProfileMessage(final String content) {
    this.content = content;
  }

  public String formatMessage(final Placeholder... placeholders) {
    var formatted = this.content;
    for (final var placeholder : placeholders) {
      formatted = formatted.replace('{' + placeholder.key() + '}', placeholder.value());
    }
    return formatted;
  }
}
