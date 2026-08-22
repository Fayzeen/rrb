package fr.rrb.bot.drop;

import fr.rrb.bot.profile.ProfileStats;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class DropRepository {

  private final Connection connection;

  public DropRepository(final Connection connection) {
    this.connection = connection;
  }

  public void insert(final long userId, final String gameMode, final String role)
      throws SQLException {
    try (final PreparedStatement statement = this.connection.prepareStatement(DropRequest.INSERT)) {
      statement.setLong(1, userId);
      statement.setString(2, gameMode);
      statement.setString(3, role);
      statement.executeUpdate();
    }
  }

  public DropStats stats(final long userId, final String gameMode, final String role)
      throws SQLException {
    return new DropStats(
        this.selfDrops(userId, gameMode, role),
        this.totalDrops(gameMode, role),
        this.rank(userId, gameMode, role));
  }

  private int selfDrops(final long userId, final String gameMode, final String role)
      throws SQLException {
    try (final PreparedStatement statement =
        this.connection.prepareStatement(DropRequest.SELF_DROPS)) {
      statement.setLong(1, userId);
      statement.setString(2, gameMode);
      statement.setString(3, role);
      return count(statement);
    }
  }

  private int totalDrops(final String gameMode, final String role) throws SQLException {
    try (final PreparedStatement statement =
        this.connection.prepareStatement(DropRequest.TOTAL_DROPS)) {
      statement.setString(1, gameMode);
      statement.setString(2, role);
      return count(statement);
    }
  }

  private int rank(final long userId, final String gameMode, final String role)
      throws SQLException {
    try (final PreparedStatement statement = this.connection.prepareStatement(DropRequest.RANK)) {
      statement.setLong(1, userId);
      statement.setString(2, gameMode);
      statement.setLong(3, userId);
      statement.setString(4, gameMode);
      statement.setString(5, role);
      return count(statement);
    }
  }

  private static int count(final PreparedStatement statement) throws SQLException {
    try (final ResultSet result = statement.executeQuery()) {
      return result.next() ? result.getInt(1) : 0;
    }
  }

  public ProfileStats profile(final long userId) throws SQLException {
    final int ranking;
    try (final PreparedStatement statement =
        this.connection.prepareStatement(DropRequest.RANKING)) {
      statement.setLong(1, userId);
      ranking = count(statement);
    }

    try (final PreparedStatement statement =
        this.connection.prepareStatement(DropRequest.TOP_ROLE)) {
      statement.setLong(1, userId);
      try (final ResultSet result = statement.executeQuery()) {
        if (!result.next()) {
          return new ProfileStats(ranking, null, null, 0);
        }
        return new ProfileStats(
            ranking, result.getString(1), result.getString(2), result.getInt(3));
      }
    }
  }
}
