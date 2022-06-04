package com.cracker.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
	public static Properties properties = new Properties();
	static {
		try {
			//获取jdbc.properties 需要在类路径下找
			ClassLoader classLoader = JDBCUtils.class.getClassLoader();
			InputStream stream = classLoader.getResourceAsStream("jdbc.properties");
			properties.load(stream);
			Class.forName(properties.getProperty("jdbcDriver"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(properties.getProperty("url"),properties);
		return connection;
	}
}
