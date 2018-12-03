package com.vcu.meleetracker.statistics.dao;

import com.vcu.meleetracker.statistics.dto.PlayerWinRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PlayerWinRateDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<PlayerWinRate> findAll() {
        return this.jdbcTemplate.query( "select participant, IFNULL(wins/games_played,0) as win_percentage\n" +
                "from\n" +
                "(\n" +
                "  select participant, sum(games) as games_played\n" +
                "  from\n" +
                "  (\n" +
                "    (select player1_id as participant, count(*) as games\n" +
                "    from matches\n" +
                "    group by player1_id) \n" +
                "  UNION ALL\n" +
                "    (select player2_id as participant, count(*) as games\n" +
                "    from matches\n" +
                "    group by player2_id) \n" +
                "  ) all_games\n" +
                "  group by participant\n" +
                ") grouped_games\n" +
                "LEFT OUTER JOIN\n" +
                "(\n" +
                "  select winner, sum(wins) as wins\n" +
                "  from\n" +
                "  (\n" +
                "    (select player1_id as winner, count(*) as wins\n" +
                "    from matches\n" +
                "    where player1_stocks > player2_stocks\n" +
                "    group by player1_id) \n" +
                "  UNION ALL\n" +
                "    (select player2_id as winner, count(*) as wins\n" +
                "    from matches\n" +
                "    where player2_stocks > player1_stocks\n" +
                "    group by player2_id)\n" +
                "  ) all_games\n" +
                "  group by winner\t\n" +
                ") grouped_wins\n" +
                "ON participant = winner\n" +
                "group by participant;", new PlayerWinRateDao.PlayerWinRateMapper());
    }

    private static final class PlayerWinRateMapper implements RowMapper<PlayerWinRate> {

        public PlayerWinRate mapRow(ResultSet rs, int rowNum) throws SQLException {
            PlayerWinRate playerWinRate = new PlayerWinRate();
            playerWinRate.setPlayerId(rs.getInt("player_id"));
            playerWinRate.setWinPercentage(rs.getDouble("win_percentage"));
            return playerWinRate;
        }
    }
}
