package com.vcu.meleetracker.statistics.dao;

import com.vcu.meleetracker.statistics.dto.CharacterWinRateByCharacter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CharacterWinRateByCharacterDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<CharacterWinRateByCharacter> findAll() {
        return this.jdbcTemplate.query( "select participant as character_id, grouped_games.opponent as opponent_character_id, IFNULL(wins/games_played,0) as win_percentage\n" +
                "from\n" +
                "(\n" +
                "  select participant, opponent, sum(games) as games_played\n" +
                "  from\n" +
                "  (\n" +
                "    (select player1_character_id as participant, player2_character_id as opponent, count(*) as games\n" +
                "    from matches\n" +
                "    group by player1_character_id, player2_character_id) \n" +
                "  UNION ALL\n" +
                "    (select player2_character_id as participant, player1_character_id as opponent, count(*) as games\n" +
                "    from matches\n" +
                "    group by player2_character_id, player1_character_id) \n" +
                "  ) all_games\n" +
                "  group by participant, opponent\n" +
                ") grouped_games\n" +
                "LEFT OUTER JOIN\n" +
                "(\n" +
                "  select winner, opponent, sum(wins) as wins\n" +
                "  from\n" +
                "  (\n" +
                "    (select player1_character_id as winner, player2_character_id as opponent, count(*) as wins\n" +
                "    from matches\n" +
                "    where player1_stocks > player2_stocks\n" +
                "    group by player1_character_id, player2_character_id) \n" +
                "  UNION ALL\n" +
                "    (select player2_character_id as winner, player1_character_id as opponent, count(*) as wins\n" +
                "    from matches\n" +
                "    where player2_stocks > player1_stocks\n" +
                "    group by player2_character_id, player1_character_id)\n" +
                "  ) all_games\n" +
                "  group by winner, opponent\n" +
                ") grouped_wins\n" +
                "ON participant = winner AND grouped_games.opponent = grouped_wins.opponent\n" +
                "group by participant, grouped_games.opponent;", new CharacterWinRateByCharacterDao.CharacterWinRateByCharacterMapper());
    }

    private static final class CharacterWinRateByCharacterMapper implements RowMapper<CharacterWinRateByCharacter> {

        public CharacterWinRateByCharacter mapRow(ResultSet rs, int rowNum) throws SQLException {
            CharacterWinRateByCharacter characterWinRateByCharacter = new CharacterWinRateByCharacter();
            characterWinRateByCharacter.setCharacterId(rs.getInt("character_id"));
            characterWinRateByCharacter.setOpponentCharacterId(rs.getInt("opponent_character_id"));
            characterWinRateByCharacter.setWinPercentage(rs.getDouble("win_percentage"));
            return characterWinRateByCharacter;
        }
    }
}
