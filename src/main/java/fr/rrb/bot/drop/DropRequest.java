package fr.rrb.bot.drop;

public final class DropRequest {

  public static final String INSERT =
      "INSERT INTO drops (user_id, game_mode, role) VALUES (?, ?, ?)";

  public static final String SELF_DROPS =
      "SELECT COUNT(*) FROM drops WHERE user_id = ? AND game_mode = ? AND role = ?";

  public static final String TOTAL_DROPS =
      "SELECT COUNT(*) FROM drops WHERE game_mode = ? AND role = ?";

  public static final String RANK =
      """
                  SELECT COUNT(*) + 1
                  FROM (
                      SELECT role
                      FROM drops
                      WHERE user_id = ? AND game_mode = ?
                      GROUP BY role
                      HAVING COUNT(*) > (
                          SELECT COUNT(*)
                          FROM drops
                          WHERE user_id = ?
                            AND game_mode = ?
                            AND role = ?
                      )
                  )
                  """;

  public static final String RANKING =
      """
                  SELECT COUNT(*) + 1
                  FROM (
                      SELECT user_id
                      FROM drops
                      GROUP BY user_id
                      HAVING COUNT(*) > (
                          SELECT COUNT(*) FROM drops WHERE user_id = ?
                      )
                  )
                  """;

  public static final String TOP_ROLE =
      """
                  SELECT game_mode, role, COUNT(*) AS amount
                  FROM drops
                  WHERE user_id = ?
                  GROUP BY game_mode, role
                  ORDER BY amount DESC
                  LIMIT 1
                  """;
}
