package com.wzjwhut.examples.mybatis

import org.apache.ibatis.annotations.*
import org.springframework.transaction.annotation.Transactional

@Mapper
interface CityMapper2 {

    @Select("SELECT * FROM CITY WHERE name = #{name}")
    fun findByName(name: String): City

    @Select("SELECT * FROM CITY WHERE state = #{state}")
    fun findByState(@Param("state") state: String): City

    @Transactional
    @Update("UPDATE CITY set state = #{state} WHERE name = #{name}")
    fun updateState(@Param("name") name: String, @Param("state") state: String): Int


    @Update("""
        <script>
            update CITY
            <set>
                <choose>
                    <when test='country == null'>country='unknown'</when>
                    <when test='country != null'>country=#{country}</when>
                </choose>
            </set>
            where name=#{name}
        </script>
    """)
    fun updateStateWithDynamicSQL(@Param("name") name: String, @Param("country") country: String): Int

    @SelectProvider(type = CityMapper2::class, method = "updateStateMethod")
    fun updateStateWithSelectProvider(@Param("name") name: String, @Param("country") country: String): Int

    fun updateStateMethod(): String {
        return """
            update CITY
                        <set>
                        <if test=\"country == null\">country='unknown'</if>
                        <if test=\"country != null\">country=#{country}</if>
                        </set>
                        where name=#{name}
    """;
    }
    companion object {
        fun updateStateMethod2(): String {
            return """
            update CITY
                        <set>
                        <if test=\"country == null\">country='unknown'</if>
                        <if test=\"country != null\">country=#{country}</if>
                        </set>
                        where name=#{name}
    """;
        }
    }


}