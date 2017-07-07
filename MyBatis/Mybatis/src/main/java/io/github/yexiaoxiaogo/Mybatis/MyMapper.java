package io.github.yexiaoxiaogo.Mybatis;

import org.apache.ibatis.annotations.Select;

public interface MyMapper {
	@Select("select count(*) from websites")
	public int getAllwebsites();

	@Select("select url,country from websites where id = #{id}")
	public Websites geturlcountry(int id);
}
