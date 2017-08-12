package com.cy.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.cy.example.dao.provider.BaseProvider;
import com.cy.example.domain.User;

@Mapper
public interface UserMapper {

	@Insert("insert into users(c_username, c_pwd,c_phone,n_age,n_sex) values(#{user.c_username},"
			+ " #{user.c_pwd},#{user.c_phone},#{user.n_age},#{user.n_sex})")
    int add(@Param("user") User user);
 
    @Update("update users set c_username = #{user.c_username}, c_pwd = #{user.c_pwd}"
    		+ ", c_phone = #{user.c_phone}, n_age = #{user.n_age}, n_sex = #{user.n_sex} where id = #{user.id}")
    int update(@Param("user") User user);
 
    @Delete("delete from users where id = #{id}")
    int delete(Long id);
    
    @Select("select id,c_username,c_pwd,c_phone,n_age,n_sex from users where c_username = #{user.c_username} and c_pwd = #{user.c_pwd}")
    User validate(@Param("user") User user);
 
    @Select("select id,c_username,c_pwd,c_phone,n_age,n_sex from users where id = #{id}")
    User findUserById(@Param("id") Long id);
 
    @Select("select id,c_username,c_phone,n_age,case when n_sex=1 then '男' "
    		+ "when n_sex=0 then '女' end as n_sex from users")
    List<User> findUsers();
    
    @SelectProvider(type = BaseProvider.class, method = "searchData")
    List<User> searchData(User user);
}
