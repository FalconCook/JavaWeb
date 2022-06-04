package com.cracker.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

public class TestConnection {
	@Test
	public void test() throws Exception {
		Connection connection = JDBCUtils.getConnection();
		System.out.println(connection);
	}
}
