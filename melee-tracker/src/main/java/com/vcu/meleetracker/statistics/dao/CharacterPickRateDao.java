package com.vcu.meleetracker.statistics.dao;

import com.vcu.meleetracker.statistics.dto.CharacterPickRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CharacterPickRateDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<CharacterPickRate> findAll() {
        return this.jdbcTemplate.query( "select character_id, sum(games) as games_played\n" +
                "from\n" +
                "(\n" +
                "  (select player1_character_id as character_id, count(*) as games\n" +
                "  from matches\n" +
                "  group by player1_character_id) \n" +
                "UNION ALL\n" +
                "  (select player2_character_id as character_id, count(*) as games\n" +
                "  from matches\n" +
                "  group by player2_character_id) \n" +
                ") all_games\n" +
                "group by character_id;", new CharacterPickRateDao.CharacterPickRateMapper());
    }

    private static final class CharacterPickRateMapper implements RowMapper<CharacterPickRate> {

        public CharacterPickRate mapRow(ResultSet rs, int rowNum) throws SQLException {
            CharacterPickRate characterPickRate = new CharacterPickRate();
            characterPickRate.setCharacterId(rs.getInt("character_Id"));
            characterPickRate.setGamesPlayed(rs.getInt("games_played"));
            return characterPickRate;
        }
    }
}
