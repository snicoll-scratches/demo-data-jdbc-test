package com.example;

import java.util.List;
import java.util.Map;

import com.example.test.autoconfigure.jdbc.DataJdbcTest;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

/**
 * Demo tests for {@link DataJdbcTest}.
 *
 * @author Stephane Nicoll
 */
@RunWith(SpringRunner.class)
@DataJdbcTest
public class DataJdbcSampleTests {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	public void testStuff() {
		jdbcTemplate.execute("create table employee (id int, name varchar)");
		jdbcTemplate.execute("insert into employee (id, name) values (1, 'John')");
		List<Map<String, Object>> employees = jdbcTemplate
				.queryForList("select id, name from employee");
		assertThat(employees).hasSize(1);
		// Some smart assertions
	}
}
