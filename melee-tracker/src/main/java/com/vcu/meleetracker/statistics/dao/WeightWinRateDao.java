package com.vcu.meleetracker.statistics.dao;

import com.vcu.meleetracker.statistics.dto.WeightWinRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class WeightWinRateDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<WeightWinRate> findAll() {
        return this.jdbcTemplate.query( "select throw_name, sum(cnt) as count\n" +
                "from\n" +
                "(\n" +
                "  (select player1_throw as throw_name, count(*) as cnt\n" +
                "  from rock_paper_scissors\n" +
                "  group by player1_throw) \n" +
                "UNION ALL\n" +
                "  (select player2_throw as throw_name, count(*) as cnt\n" +
                "  from rock_paper_scissors\n" +
                "  group by player2_throw)\n" +
                ") all_throws\n" +
                "group by throw_name;", new WeightWinRateDao.WeightWinRateMapper());
    }

    private static final class WeightWinRateMapper implements RowMapper<WeightWinRate> {

        public WeightWinRate mapRow(ResultSet rs, int rowNum) throws SQLException {
            WeightWinRate weightWinRate = new WeightWinRate();
            weightWinRate.setWeight(rs.getInt("throw_name"));
            weightWinRate.setWinPercentage(rs.getDouble("win_percentage"));
            return weightWinRate;
        }
    }
}
