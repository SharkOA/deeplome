package com.deeplome.repository;

import com.deeplome.entity.Test;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends CrudRepository<Test, Long> {

    JdbcTemplate jdbcTemplate = new JdbcTemplate(new DriverManagerDataSource("jdbc:postgresql://localhost:5432/discrete_math",
            "postgres", "postgres"));

    default List<Test> getTests() {
        return jdbcTemplate.query("SELECT id, image, text, answers_count FROM tests ORDER BY random() LIMIT 20",
                (rs, rowNum) -> new Test(rs.getInt("id"), rs.getBytes("image"),
                        rs.getString("text"), rs.getInt("answers_count")));
    }

}
