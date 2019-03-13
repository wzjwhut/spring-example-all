package com.wzjwhut.examples.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

@Mapper
public interface CityMapper {

    @Select("SELECT * FROM CITY WHERE name = #{name}")
    City findByName(String name);

    @Select("SELECT * FROM CITY WHERE state = #{state}")
    City findByState(@Param("state") String state);

    @Transactional
    @Update("UPDATE CITY set state = #{state} WHERE name = #{name}")
    int updateState(@Param("name") String name, @Param("state") String state);


    @Update({"<script> ",
            "            update CITY ",
            "            <set> ",
            "<choose>",
            "            <when  test='country == null'>country='unknown'</when> ",
            "            <when  test='country != null'>country=#{country}</when> ",
            "</choose>",
            "            </set> ",
            "            where name=#{name} ",
            "            </script>"})
    int updateStateWithDynamicSQL(@Param("name") String name, @Param("country") String country);

    @SelectProvider(type = CityMapper.class, method = "updateStateMethod")
    int updateStateWithSelectProvider(@Param("name") String name, @Param("country") String country);

    public static String updateStateMethod() {
        return
                "update CITY\n" +
                        "<set>\n" +
                        "<if test=\"country == null\">country='unknown'</if>\n" +
                        "<if test=\"country != null\">country=#{country}</if> " +
                        "</set>\n" +
                        "where name=#{name}\n";
    }
}
