package com.vcu.meleetracker.statistics.dao;

import com.vcu.meleetracker.statistics.dto.PlayerWinRateByCharacter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PlayerWinRateByCharacterDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<PlayerWinRateByCharacter> findAll() {
        return this.jdbcTemplate.query( "select participant as player_id, grouped_games.character_id as character_id, IFNULL(wins/games_played,0) as win_percentage\n" +
                "from\n" +
                "(\n" +
                "  select participant, character_id, sum(games) as games_played\n" +
                "  from\n" +
                "  (\n" +
                "    (select player1_id as participant, player1_character_id as character_id, count(*) as games\n" +
                "    from matches\n" +
                "    group by player1_id, player1_character_id) \n" +
                "  UNION ALL\n" +
                "    (select player2_id as participant, player2_character_id as character_id, count(*) as games\n" +
                "    from matches\n" +
                "    group by player2_id, player2_character_id) \n" +
                "  ) all_games\n" +
                "  group by participant, character_id\n" +
                ") grouped_games\n" +
                "LEFT OUTER JOIN\n" +
                "(\n" +
                "  select winner, character_id, sum(wins) as wins\n" +
                "  from\n" +
                "  (\n" +
                "    (select player1_id as winner, player1_character_id as character_id, count(*) as wins\n" +
                "    from matches\n" +
                "    where player1_stocks > player2_stocks\n" +
                "    group by player1_id, character_id) \n" +
                "  UNION ALL\n" +
                "    (select player2_id as winner, player2_character_id as character_id, count(*) as wins\n" +
                "    from matches\n" +
                "    where player2_stocks > player1_stocks\n" +
                "    group by player2_id, character_id)\n" +
                "  ) all_games\n" +
                "  group by winner, character_id\n" +
                ") grouped_wins\n" +
                "ON participant = winner AND grouped_games.character_id = grouped_wins.character_id\n" +
                "group by participant, grouped_games.character_id;", new PlayerWinRateByCharacterDao.PlayerWinRateByCharacterMapper());
    }

    private static final class PlayerWinRateByCharacterMapper implements RowMapper<PlayerWinRateByCharacter> {

        public PlayerWinRateByCharacter mapRow(ResultSet rs, int rowNum) throws SQLException {
            PlayerWinRateByCharacter playerWinRateByCharacter = new PlayerWinRateByCharacter();
            playerWinRateByCharacter.setPlayerId(rs.getInt("player_id"));
            playerWinRateByCharacter.setCharacterId(rs.getInt("character_id"));
            playerWinRateByCharacter.setWinPercentage(rs.getInt("win_percentage"));
            return playerWinRateByCharacter;
        }
    }
}
