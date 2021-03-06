package com.vcu.meleetracker.statistics.dao;

import com.vcu.meleetracker.statistics.dto.CharacterWinRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CharacterWinRateDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<CharacterWinRate> findAll() {
        return this.jdbcTemplate.query( "select participant as character_id, IFNULL(wins/games_played,0) as win_percentage\n" +
                "from\n" +
                "(\n" +
                "  select participant, sum(games) as games_played\n" +
                "  from\n" +
                "  (\n" +
                "    (select player1_character_id as participant, count(*) as games\n" +
                "    from matches\n" +
                "    group by player1_character_id) \n" +
                "  UNION ALL\n" +
                "    (select player2_character_id as participant, count(*) as games\n" +
                "    from matches\n" +
                "    group by player2_character_id) \n" +
                "  ) all_games\n" +
                "  group by participant\n" +
                ") grouped_games\n" +
                "LEFT OUTER JOIN\n" +
                "(\n" +
                "  select winner, sum(wins) as wins\n" +
                "  from\n" +
                "  (\n" +
                "    (select player1_character_id as winner, count(*) as wins\n" +
                "    from matches\n" +
                "    where player1_stocks > player2_stocks\n" +
                "    group by player1_character_id) \n" +
                "  UNION ALL\n" +
                "    (select player2_character_id as winner, count(*) as wins\n" +
                "    from matches\n" +
                "    where player2_stocks > player1_stocks\n" +
                "    group by player2_character_id) \n" +
                "  ) all_wins\n" +
                "  group by winner\n" +
                ") grouped_wins\n" +
                "ON participant = winner\n" +
                "group by participant;", new CharacterWinRateDao.CharacterWinRateMapper());
    }

    private static final class CharacterWinRateMapper implements RowMapper<CharacterWinRate> {

        public CharacterWinRate mapRow(ResultSet rs, int rowNum) throws SQLException {
            CharacterWinRate characterWinRate = new CharacterWinRate();
            characterWinRate.setCharacterId(rs.getInt("character_id"));
            characterWinRate.setWinPercentage(rs.getDouble("win_percentage"));
            return characterWinRate;
        }
    }
}
