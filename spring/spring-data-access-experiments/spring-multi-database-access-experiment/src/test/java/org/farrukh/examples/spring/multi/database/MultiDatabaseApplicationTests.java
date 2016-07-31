/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.examples.spring.multi.database;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiDatabaseApplicationTests {

	@Autowired
	private JdbcTemplate mysqlJdbcTemplate;

	@Autowired
	private JdbcTemplate postgresJdbcTemplate;

	@Test
	public void contextLoads() throws SQLException {
		String version = "VERSION";
		String expectedMySQLVersion = "5.7.12";
		String expectedPostgresVersion = "PostgreSQL 9.5.2 on x86_64-pc-linux-gnu, compiled by gcc (Debian 4.9.2-10) 4.9.2, 64-bit";

		String versionQuery = "SELECT VERSION() as VERSION";
		Map<String, Object> mysql = mysqlJdbcTemplate.queryForMap(versionQuery);
		Map<String, Object> postgres = postgresJdbcTemplate.queryForMap(versionQuery);
		assertThat(mysql.get(version), is(expectedMySQLVersion));
		assertThat(postgres.get(version), is(expectedPostgresVersion));
	}

}
