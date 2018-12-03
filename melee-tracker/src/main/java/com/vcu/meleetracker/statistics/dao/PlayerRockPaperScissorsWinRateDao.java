package com.vcu.meleetracker.statistics.dao;

import com.vcu.meleetracker.statistics.dto.PlayerRockPaperScissorsWinRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PlayerRockPaperScissorsWinRateDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<PlayerRockPaperScissorsWinRate> findAll() {
        return this.jdbcTemplate.query( "select participant as player_id, IFNULL(wins/throws,0) as win_percentage\n" +
                "from\n" +
                "(\n" +
                "  select participant, sum(throws) as throws\n" +
                "  from\n" +
                "  (\n" +
                "    (select player1_id as participant, count(*) as throws\n" +
                "    from rock_paper_scissors\n" +
                "    JOIN matches\n" +
                "    on rock_paper_scissors.set_id = matches.set_id\n" +
                "    WHERE UPPER(player1_throw) <> UPPER(player2_throw)\n" +
                "\tgroup by player1_id) \n" +
                "  UNION ALL\n" +
                "    (select player2_id as participant, count(*) as throws\n" +
                "    from rock_paper_scissors\n" +
                "    JOIN matches\n" +
                "    on rock_paper_scissors.set_id = matches.set_id\n" +
                "    WHERE UPPER(player1_throw) <> UPPER(player2_throw)\n" +
                "\tgroup by player2_id) \n" +
                "  ) all_throws\n" +
                "  group by participant\n" +
                ") grouped_throws\n" +
                "LEFT OUTER JOIN\n" +
                "(\n" +
                "  select winner, sum(wins) as wins\n" +
                "  from\n" +
                "  (\n" +
                "    (select player1_id as winner, count(*) as wins\n" +
                "    from rock_paper_scissors\n" +
                "    JOIN matches\n" +
                "    on rock_paper_scissors.set_id = matches.set_id\n" +
                "    WHERE UPPER(player1_throw) = 'ROCK' AND UPPER(player2_throw) = 'SCISSORS'\n" +
                "    OR UPPER(player1_throw) = 'SCISSORS' AND UPPER(player2_throw) = 'PAPER'\n" +
                "    OR UPPER(player1_throw) = 'PAPER' AND UPPER(player2_throw) = 'ROCK'\n" +
                "\tGROUP BY player1_id) \n" +
                "  UNION ALL\n" +
                "    (select player2_id as winner, count(*) as wins\n" +
                "    from rock_paper_scissors\n" +
                "    JOIN matches\n" +
                "    on rock_paper_scissors.set_id = matches.set_id\n" +
                "    WHERE UPPER(player2_throw) = 'ROCK' AND UPPER(player1_throw) = 'SCISSORS'\n" +
                "    OR UPPER(player2_throw) = 'SCISSORS' AND UPPER(player1_throw) = 'PAPER'\n" +
                "    OR UPPER(player2_throw) = 'PAPER' AND UPPER(player1_throw) = 'ROCK'\n" +
                "\tGROUP BY player2_id)\n" +
                "  ) all_throws\n" +
                "  group by winner\n" +
                ") grouped_wins\n" +
                "ON participant = winner\n" +
                "group by participant;", new PlayerRockPaperScissorsWinRateDao.PlayerRockPaperScissorsWinRateMapper());
    }

    private static final class PlayerRockPaperScissorsWinRateMapper implements RowMapper<PlayerRockPaperScissorsWinRate> {

        public PlayerRockPaperScissorsWinRate mapRow(ResultSet rs, int rowNum) throws SQLException {
            PlayerRockPaperScissorsWinRate stageFrequency = new PlayerRockPaperScissorsWinRate();
            stageFrequency.setPlayerId(rs.getInt("player_id"));
            stageFrequency.setWinPercentage(rs.getDouble("win_percentage"));
            return stageFrequency;
        }
    }
}
