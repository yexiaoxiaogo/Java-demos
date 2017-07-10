package io.github.yexiaoxiaogo.Mybatis;

import java.util.jar.Attributes.Name;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.SqlSession;

public interface MyMapper {
	@Select("select count(*) from websites")
	public int getAllwebsites();

	@Select("select url,country from websites where id = #{id}")
	public Websites geturlcountry(int id);
	
	@Insert("insert into websites(id,name,url,alexa,country)values(#{id},#{name},#{url},#{alexa},#{country})")
	public Websites  insertWebsites(Websites websites);
	
	@Delete("delete from websites where id=#{id}")
	public Websites deleteWebsites(int id);
	
	@Update("update websites set alexa=#{alexa} where id=#{id}")
	public Websites updataWebsites(Websites websites);
	
}

