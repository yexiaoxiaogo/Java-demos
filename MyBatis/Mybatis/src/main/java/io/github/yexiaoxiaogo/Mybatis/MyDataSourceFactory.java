package io.github.yexiaoxiaogo.Mybatis;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.DataSourceFactory;
import org.apache.ibatis.datasource.pooled.PooledDataSource;

public class MyDataSourceFactory implements DataSourceFactory {
	private Properties properties;

	public MyDataSourceFactory() {
		properties = new Properties();
		properties.setProperty("driver", "com.mysql.jdbc.Driver");
		properties.setProperty("url", "jdbc:mysql://localhost:3306/yexx");
		properties.setProperty("user", "root");
		properties.setProperty("password", "");
		// TODO Auto-generated constructor stub
	}
	
	

	public DataSource getDataSource() {
		// TODO Auto-generated method stub
		PooledDataSource ds = new PooledDataSource();
		ds.setDriver(properties.getProperty("driver"));
		ds.setUrl(properties.getProperty("url"));
		ds.setUsername(properties.getProperty("user"));
		ds.setPassword(properties.getProperty("password"));

		return ds;

	}

	public void setProperties(Properties arg0) {
		// TODO Auto-generated method stub
		properties = arg0;
	}
	
	public static void showMsg() {
		
	}

}
