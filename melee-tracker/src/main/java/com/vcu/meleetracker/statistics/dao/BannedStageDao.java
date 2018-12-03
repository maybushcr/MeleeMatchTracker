package com.vcu.meleetracker.statistics.dao;

import com.vcu.meleetracker.statistics.dto.StageFrequency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BannedStageDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<StageFrequency> findAll() {
        return this.jdbcTemplate.query( "select stage_id, count(*) as count\n" +
                "from strikes\n" +
                "group by stage_id;", new BannedStageDao.StageFrequencyMapper());
    }

    private static final class StageFrequencyMapper implements RowMapper<StageFrequency> {

        public StageFrequency mapRow(ResultSet rs, int rowNum) throws SQLException {
            StageFrequency stageFrequency = new StageFrequency();
            stageFrequency.setStageId(rs.getInt("stage_id"));
            stageFrequency.setFrequency(rs.getInt("count"));
            return stageFrequency;
        }
    }
}
