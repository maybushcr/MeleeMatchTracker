package com.vcu.meleetracker.statistics.dao;

import com.vcu.meleetracker.statistics.dto.CharacterPickRateByPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CharacterPickRateByPlayerDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<CharacterPickRateByPlayer> findAll() {
        return this.jdbcTemplate.query( "select player_id, character_id, sum(games) as games_played\n" +
                "from\n" +
                "(\n" +
                "  (select player1_id as player_id, player1_character_id as character_id, count(*) as games\n" +
                "  from matches\n" +
                "  group by player1_id, player1_character_id) \n" +
                "UNION ALL\n" +
                "  (select player2_id as player_id, player2_character_id as character_id, count(*) as games\n" +
                "  from matches\n" +
                "  group by player2_id, player2_character_id) \n" +
                ") all_games\n" +
                "group by player_id, character_id;", new CharacterPickRateByPlayerDao.CharacterPickRateByPlayerMapper());
    }

    private static final class CharacterPickRateByPlayerMapper implements RowMapper<CharacterPickRateByPlayer> {

        public CharacterPickRateByPlayer mapRow(ResultSet rs, int rowNum) throws SQLException {
            CharacterPickRateByPlayer characterPickRates = new CharacterPickRateByPlayer();
            characterPickRates.setPlayerId(rs.getInt("player_Id"));
            characterPickRates.setCharacterId(rs.getInt("character_Id"));
            characterPickRates.setGamesPlayed(rs.getInt("games_played"));
            return characterPickRates;
        }
    }
}
