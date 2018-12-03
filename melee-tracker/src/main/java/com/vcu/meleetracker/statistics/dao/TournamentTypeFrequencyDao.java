package com.vcu.meleetracker.statistics.dao;

import com.vcu.meleetracker.statistics.dto.TournamentTypeFrequency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TournamentTypeFrequencyDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<TournamentTypeFrequency> findAll() {
        return this.jdbcTemplate.query( "select tournament_type_id, count(*) as count\n" +
                "from tournaments\n" +
                "group by tournament_type_id;", new TournamentTypeFrequencyDao.TournamentTypeFrequencyMapper());
    }

    private static final class TournamentTypeFrequencyMapper implements RowMapper<TournamentTypeFrequency> {

        public TournamentTypeFrequency mapRow(ResultSet rs, int rowNum) throws SQLException {
            TournamentTypeFrequency tournamentTypeFrequency = new TournamentTypeFrequency();
            tournamentTypeFrequency.setTournamentTypeId(rs.getInt("tournament_type_id"));
            tournamentTypeFrequency.setCount(rs.getInt("count"));
            return tournamentTypeFrequency;
        }
    }
}
