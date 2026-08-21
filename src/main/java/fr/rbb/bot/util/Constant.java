package fr.rbb.bot.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Constant {

  public static final Logger LOGGER = LoggerFactory.getLogger("Bot");

  public static final long SERVER_GUILD_ID = Long.parseLong(System.getenv("SERVER_GUILD_ID"));
  public static final long DEBUG_GUILD_ID = Long.parseLong(System.getenv("DEBUG_GUILD_ID"));
}
