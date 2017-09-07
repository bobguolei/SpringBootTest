package com.huawei.oss.dao;

import com.huawei.oss.model.User;
import java.util.List;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Mapper
//解决mapper注入时显示can not autowires
@Component(value = "UserMapper")
public interface UserMapper {

  @Select("SELECT * FROM user WHERE id = #{id}")
  User queryById(@Param("id") int id);

  @Select("SELECT * FROM user")
  List<User> queryAll();

  @Insert({"INSERT INTO user(name,age,hobby) VALUES(#{name},#{age},#{hobby})"})
  int add(User user);

  @Delete("DELETE FROM user WHERE id = #{id}")
  int delById(int id);

  @Update("UPDATE user SET name=#{name},age=#{age},hobby=#{hobby} WHERE id = #{id}")
  int updateById(User user);
}