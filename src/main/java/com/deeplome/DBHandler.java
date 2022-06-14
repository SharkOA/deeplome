package com.deeplome;

import com.deeplome.entity.Answer;
import com.deeplome.entity.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.Collections;
import java.util.List;

public class DBHandler {

    JdbcTemplate jdbcTemplate = new JdbcTemplate(new DriverManagerDataSource("jdbc:postgresql://localhost:5432/discrete_math",
            "postgres", "postgres"));

    public List<Test> getTests() {
        return jdbcTemplate.query("SELECT id, image, text, answers_count FROM tests ORDER BY random() LIMIT 20",
                (rs, rowNum) -> new Test(rs.getInt("id"), rs.getBytes("image"),
                        rs.getString("text"), rs.getInt("answers_count")));
    }

    public List<Answer> getAnswers(List<Test> tests) {

        List<Integer> ids = tests.stream().map(Test::getId).toList();
        String inSql = String.join(",", Collections.nCopies(ids.size(), "?"));

        return jdbcTemplate.query(
                String.format("SELECT id, image, is_correct, text, test_id FROM answers where test_id in (%s)", inSql),
                ids.toArray(),
                ((rs, rowNum) -> new Answer(rs.getInt("id"), rs.getBoolean("is_correct"),
                        rs.getBytes("image"), rs.getString("text"), rs.getInt("test_id"))));
    }
}
