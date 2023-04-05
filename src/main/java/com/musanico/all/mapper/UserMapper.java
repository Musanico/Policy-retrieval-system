package com.musanico.all.mapper;

import com.musanico.all.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * from sys_user")
    List<User> findAll();

    @Insert("INSERT into sys_user(POLICY_TITLE, POLICY_GRADE, PUB_TYPE,PUB_AGENCY_ID,PUB_AGENCY,PUB_TIME,PROVINCE) VALUES (#{POLICY_TITLE},#{POLICY_GRADE},#{PUB_TYPE},#{PUB_AGENCY_ID},#{PUB_AGENCY},#{PUB_TIME},#{PROVINCE})")
    int insert(User user);

    int update(User user);

    @Delete("DELETE from sys_user where POLICY_ID = #{POLICY_ID}")
    Integer deleteById(@Param("id") Integer id);

    @Select("SELECT * from sys_user limit #{pageNum}, #{pageSize}")
    List<User> selectPage(Integer pageNum, Integer pageSize);

    @Select("SELECT count(*) from sys_user")
    Integer selectTotal();
}
