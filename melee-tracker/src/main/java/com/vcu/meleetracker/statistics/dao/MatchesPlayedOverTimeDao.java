package com.vcu.meleetracker.statistics.dao;

import com.vcu.meleetracker.statistics.dto.MatchesPlayedOverTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MatchesPlayedOverTimeDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<MatchesPlayedOverTime> findAll() {
        return this.jdbcTemplate.query( "select DATE_FORMAT(match_start, '%Y-%m-%d') as day, count(*) as count\n" +
                "from matches\n" +
                "group by day;", new MatchesPlayedOverTimeDao.MatchesPlayedOverTimeMapper());
    }

    private static final class MatchesPlayedOverTimeMapper implements RowMapper<MatchesPlayedOverTime> {

        public MatchesPlayedOverTime mapRow(ResultSet rs, int rowNum) throws SQLException {
            MatchesPlayedOverTime matchesPlayedOverTime = new MatchesPlayedOverTime();
            matchesPlayedOverTime.setDay(rs.getDate("day"));
            matchesPlayedOverTime.setCount(rs.getInt("count"));
            return matchesPlayedOverTime;
        }
    }
}
