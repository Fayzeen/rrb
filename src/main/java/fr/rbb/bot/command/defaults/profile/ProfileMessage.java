package fr.rbb.bot.command.defaults.profile;

import fr.rbb.bot.util.Placeholder;

public enum ProfileMessage {
  BODY(
      "> <:profil:1539076077656481812> » **Classement**: #**{ranking}** des rolls du bot.\n"
          + "> <:drop:1539075983783628840> » **Le plus drop**: **{role}** (**{dropped} fois**).");

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
