package fr.rrb.bot.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public final class Database {

  private final Connection connection;

  public Database(final String path) throws SQLException {
    this.connection = DriverManager.getConnection("jdbc:sqlite:" + path);
    this.createTables();
  }

  private void createTables() throws SQLException {
    try (final Statement statement = this.connection.createStatement()) {
      statement.execute(
          """
                    CREATE TABLE IF NOT EXISTS drops (
                      user_id INTEGER NOT NULL,
                      game_mode TEXT NOT NULL,
                      role TEXT NOT NULL
                    )
                    """);
    }
  }

  public Connection connection() {
    return this.connection;
  }

  public void close() throws SQLException {
    this.connection.close();
  }
}
