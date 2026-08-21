package fr.rbb.bot;

/**
 * @author @Fayzeen on Github or thefayz on discord
 */
public final class Main {

  public static void main(final String[] args) throws InterruptedException {
    final var token = System.getenv("ENV");
    if (token == null || token.isEmpty()) {
      throw new IllegalStateException("ENV environment variable is not set.");
    }

    new Bot(token);
  }
}
