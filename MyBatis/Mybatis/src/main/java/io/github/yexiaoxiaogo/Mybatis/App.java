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

        DataSource dSource = mDataSourceFactory.getDataSource();

        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(MyMapper.class);
        
        sessionFactory = new SqlSessionFactoryBuilder().build(configuration);
      
        getAllwebsites();
//        geturlcountry();
//        insertWebsites();
//        deleteWebsites();
//        updataWebsites();
    }
  //查询全部数据有几条
    public static void getAllwebsites() {       
    	try {
    		SqlSession session = sessionFactory.openSession();
    		
    		int numb = session.selectOne("getAllwebsites");
    		System.out.println(numb);
   		
    	} catch (Exception e) {
    		// TODO: handle exception
    		System.out.println(e);
    	}
	}
  //通过id查询信息
    public static void geturlcountry() {         
    	try {
    		SqlSession session = sessionFactory.openSession();
  		
    		Websites sWebsites = session.selectOne("geturlcountry", 2);
    		System.out.println(sWebsites);
    		
    	} catch (Exception e) {
    		// TODO: handle exception
    		System.out.println(e);
    	}
	}
	//增加一条信息
    public static void insertWebsites() {
    	try {
    		SqlSession session = sessionFactory.openSession();

    		Websites aWebsites =  new Websites();
    		aWebsites.setId(9);
    		aWebsites.setName("777");
    		aWebsites.setUrl("777url");
    		aWebsites.setAlexa(7);
    		aWebsites.setCountry("cn");
    		session.insert("insertWebsites",aWebsites );
    		session.commit();
    		Websites iWebsites = session.selectOne("geturlcountry", aWebsites.getId());
    		System.out.println("增加的信息：" + iWebsites);

    	} catch (Exception e) {
    		// TODO: handle exception
    		System.out.println(e);
    	}
	}
	//删除一条信息
    public static void deleteWebsites() {
    	try {
    		SqlSession session = sessionFactory.openSession();
   	
    		session.delete("deleteWebsites", 8);
    		session.commit();
    		int dWebsitesnumb = session.selectOne("getAllwebsites");
    		System.out.println(dWebsitesnumb);

    	} catch (Exception e) {
    		// TODO: handle exception
    		System.out.println(e);
    	}
	}
	//修改一条信息
    public static void updataWebsites() {
    	try {
    		SqlSession session = sessionFactory.openSession();

    		Websites aWebsites =  new Websites();
    		aWebsites.setId(1);
    		aWebsites.setAlexa(2);
    		int aaa=session.update("updataWebsites", aWebsites);
    		session.commit();
    		System.out.println("修改受影响的行数："+aaa);
    	} catch (Exception e) {
    		// TODO: handle exception
    		System.out.println(e);
    	}
	}
}
