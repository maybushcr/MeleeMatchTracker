package com.vcu.meleetracker.statistics.dao;

import com.vcu.meleetracker.statistics.dto.PlayerWinRateByStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PlayerWinRateByStageDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<PlayerWinRateByStage> findAll() {
        return this.jdbcTemplate.query( "select participant as player_id, grouped_games.stage_id as stage_id, IFNULL(wins/games_played,0) as win_percentage\n" +
                "from\n" +
                "(\n" +
                "  select participant, stage_id, sum(games) as games_played\n" +
                "  from\n" +
                "  (\n" +
                "    (select player1_id as participant, stage_id as stage_id, count(*) as games\n" +
                "    from matches\n" +
                "    group by player1_id, stage_id) \n" +
                "  UNION ALL\n" +
                "    (select player2_id as participant, stage_id as stage_id, count(*) as games\n" +
                "    from matches\n" +
                "    group by player2_id, stage_id) \n" +
                "  ) all_games\n" +
                "  group by participant, stage_id\n" +
                ") grouped_games\n" +
                "LEFT OUTER JOIN\n" +
                "(\n" +
                "  select winner, stage_id, sum(wins) as wins\n" +
                "  from\n" +
                "  (\n" +
                "    (select player1_id as winner, stage_id as stage_id, count(*) as wins\n" +
                "    from matches\n" +
                "    where player1_stocks > player2_stocks\n" +
                "    group by player1_id, stage_id) \n" +
                "  UNION ALL\n" +
                "    (select player2_id as winner, stage_id as stage_id, count(*) as wins\n" +
                "    from matches\n" +
                "    where player2_stocks > player1_stocks\n" +
                "    group by player2_id, stage_id)\n" +
                "  ) all_games\n" +
                "  group by winner, stage_id\n" +
                ") grouped_wins\n" +
                "ON participant = winner AND grouped_games.stage_id = grouped_wins.stage_id\n" +
                "group by participant, grouped_games.stage_id;", new PlayerWinRateByStageDao.PlayerWinRateByStageMapper());
    }

    private static final class PlayerWinRateByStageMapper implements RowMapper<PlayerWinRateByStage> {

        public PlayerWinRateByStage mapRow(ResultSet rs, int rowNum) throws SQLException {
            PlayerWinRateByStage playerWinRateByStage = new PlayerWinRateByStage();
            playerWinRateByStage.setPlayerId(rs.getInt("player_id"));
            playerWinRateByStage.setStageId(rs.getInt("stage_id"));
            playerWinRateByStage.setWinPercentage(rs.getDouble("win_percentage"));
            return playerWinRateByStage;
        }
    }
}
