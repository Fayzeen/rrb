package fr.rbb.bot.command.defaults.prediction;

import fr.rbb.bot.command.defaults.prediction.role.*;

import java.util.List;
import java.util.function.Supplier;

public enum GameMode {
  ALL_STARS_UHC("All Stars UHC", "<:allstars:1537489898813136968>", 0xF43B78, AllStarsRole::values),
  BLACK_CLOVER_UHC(
      "Black Clover UHC", "<:blackclover:1536825243375505598>", 0x00871b, BlackCloverRole::values),
  MANHWA_UHC("Manhwa UHC", "<:cherry_blossom:0>", 0xE2B4CC, ManhwaRole::values),
  ONE_PIECE_UHC(
      "One Piece UHC", "<:onepieceuhc:1538686710433456219>", 0x5555FF, OnePieceRole::values),
  NARUTO_UHC("Naruto UHC", "<:narutouhc:1538944315391479989>", 0xFFAA00, NarutoRole::values);

  private final String displayName;
  private final String emoji;
  private final int accentColor;
  private final Supplier<Role[]> roles;

  GameMode(
      final String displayName,
      final String emoji,
      final int accentColor,
      final Supplier<Role[]> roles) {
    this.displayName = displayName;
    this.emoji = emoji;
    this.accentColor = accentColor;
    this.roles = roles;
  }

  public String displayName() {
    return this.displayName;
  }

  public String emoji() {
    return this.emoji;
  }

  public int accentColor() {
    return this.accentColor;
  }

  public List<Role> roles() {
    return List.of(this.roles.get());
  }

  public static GameMode byName(final String name) {
    for (final GameMode mode : values()) {
      if (mode.name().equals(name)) {
        return mode;
      }
    }
    return null;
  }

  public Role roleById(final String id) {
    for (final Role role : this.roles()) {
      if (role.id().equals(id)) {
        return role;
      }
    }
    return null;
  }
}
