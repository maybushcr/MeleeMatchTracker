package com.vcu.meleetracker.statistics.dao;

import com.vcu.meleetracker.statistics.dto.PopularThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PopularThrowsDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<PopularThrows> findAll() {
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
                "group by throw_name;", new PopularThrowsMapper());
    }

    private static final class PopularThrowsMapper implements RowMapper<PopularThrows> {

        public PopularThrows mapRow(ResultSet rs, int rowNum) throws SQLException {
            PopularThrows popularThrows = new PopularThrows();
            popularThrows.setThrowName(rs.getString("throw_name"));
            popularThrows.setCount(rs.getInt("count"));
            return popularThrows;
        }
    }
}
