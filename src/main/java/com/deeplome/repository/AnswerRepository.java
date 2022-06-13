package com.deeplome.repository;

import com.deeplome.entity.Answer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {

    JdbcTemplate jdbcTemplate = new JdbcTemplate(new DriverManagerDataSource("jdbc:postgresql://localhost:5432/discrete_math",
            "postgres", "postgres"));

    default List<Answer> getAnswers(List<Integer> tests) {
        String inSql = String.join(",", Collections.nCopies(tests.size(), "?"));

        return jdbcTemplate.query(
                String.format("SELECT id, image, is_correct, text, test_id FROM answers where test_id in (%s)", inSql),
                tests.toArray(),
                ((rs, rowNum) -> new Answer(rs.getInt("id"), rs.getBoolean("is_correct"),
                        rs.getBytes("image"), rs.getString("text"), rs.getInt("test_id"))));
    }
}