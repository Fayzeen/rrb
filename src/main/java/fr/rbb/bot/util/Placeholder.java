package fr.rbb.bot.util;

import org.jetbrains.annotations.NotNull;

public record Placeholder(@NotNull String key, @NotNull String value) {

  public Placeholder(final @NotNull String key, final @NotNull Object value) {
    this(key, String.valueOf(value));
  }
}
