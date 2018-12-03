package com.vcu.meleetracker.statistics.dao;

import com.vcu.meleetracker.statistics.dto.AverageStockDifference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AverageStockDifferenceDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<AverageStockDifference> findAll() {
        return this.jdbcTemplate.query( "select AVG(ABS(player1_stocks - player2_stocks)) as average_stock_difference\n" +
                "from matches;", new AverageStockDifferenceDao.AverageStockDifferenceMapper());
    }

    private static final class AverageStockDifferenceMapper implements RowMapper<AverageStockDifference> {

        public AverageStockDifference mapRow(ResultSet rs, int rowNum) throws SQLException {
            AverageStockDifference averageStockDifference = new AverageStockDifference();
            averageStockDifference.setAverageStockDifference(rs.getDouble("average_stock_difference"));
            return averageStockDifference;
        }
    }
}
