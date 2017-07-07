package io.github.yexiaoxiaogo.Mybatis;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

/**
 * Hello world!
 *
 */
public class App 
{
	private static SqlSessionFactory sessionFactory = null;
    public static void main( String[] args )
    {        
        MyDataSourceFactory mDataSourceFactory = new MyDataSourceFactory();
//        mDataSourceFactory.setProperties(prop);
        DataSource dSource = mDataSourceFactory.getDataSource();
//        mDataSourceFactory.showMsg();
//        
//        MyDataSourceFactory.showMsg();
//        mDataSourceFactory.getDataSource();
        
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(MyMapper.class);
        
        sessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        try {
        	SqlSession session = sessionFactory.openSession();
			int numb = session.selectOne("getAllwebsites");
			System.out.println(numb);
			
			Websites sWebsites = session.selectOne("geturlcountry", 2);
			System.out.println(sWebsites);
		} catch (Exception e) {
			// TODO: handle exception
		}
   
       
    }
}
