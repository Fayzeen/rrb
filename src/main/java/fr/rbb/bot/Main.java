package fr.rbb.bot;

/**
 * @author @Fayzeen on Github or thefayz on discord
 */
public final class Main {

  public static void main(final String[] args) throws InterruptedException {
    final var token = System.getenv("DISCORD_TOKEN");
    if (token == null || token.isEmpty()) {
      throw new IllegalStateException("DISCORD_TOKEN environment variable is not set.");
    }

    new Bot(token);
  }
}
