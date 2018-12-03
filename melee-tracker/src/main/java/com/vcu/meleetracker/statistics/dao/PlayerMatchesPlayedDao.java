package com.vcu.meleetracker.statistics.dao;

import com.vcu.meleetracker.statistics.dto.PlayerMatchesPlayed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PlayerMatchesPlayedDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<PlayerMatchesPlayed> findAll() {
        return this.jdbcTemplate.query( "select player as player_id, sum(games) as games_played\n" +
                "from\n" +
                "(\n" +
                "  (select player1_id as player, count(*) as games\n" +
                "  from matches\n" +
                "  group by player1_id) \n" +
                "UNION ALL\n" +
                "  (select player2_id as player, count(*) as games\n" +
                "  from matches\n" +
                "  group by player2_id) \n" +
                ") all_games\n" +
                "group by player;", new PlayerMatchesPlayedDao.PlayerMatchesPlayedMapper());
    }

    private static final class PlayerMatchesPlayedMapper implements RowMapper<PlayerMatchesPlayed> {

        public PlayerMatchesPlayed mapRow(ResultSet rs, int rowNum) throws SQLException {
            PlayerMatchesPlayed playerMatchesPlayed = new PlayerMatchesPlayed();
            playerMatchesPlayed.setPlayerId(rs.getInt("player_id"));
            playerMatchesPlayed.setGamesPlayed(rs.getInt("games_played"));
            return playerMatchesPlayed;
        }
    }
}
