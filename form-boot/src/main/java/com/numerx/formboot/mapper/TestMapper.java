package com.numerx.formboot.mapper;

import com.numerx.formboot.entity.Test;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author matrixorz
 * @data 2019-08-12 21:22
 */

@Mapper
public interface TestMapper {
    /**根据英雄id查询英雄属性
     * @param 传入的id
     * @return 查询的结果集
     */
    @Select("select * from test where id = #{id}")
    Test returnById(@Param("id") int id);

    /**
     * 返回test表中的所有数据
     * @return 所有结果集
     */
    @Select("select * from test")
    List<Test> returnResult();
    /**
     * 实现数据插入功能
     * @param name 英雄名
     * @param hp 英雄血量值
     * @param damage 英雄伤害值
     * @return 插入是否成功
     */
    @Insert("insert into test(name, hp, damage) VALUES(#{name}, #{hp}, #{damage})")
    int insert(@Param("name") String name,@Param("hp") double hp,@Param("damage") double damage);

    /**
     *根据英雄id更新英雄属性
     * @param name 英雄名
     * @param hp 英雄血量
     * @param damage 英雄伤害
     * @param id 英雄id
     * @return 更新是否成功
     */
    @Update("update test set name = #{name},hp = #{hp},damage = #{damage} where id = #{id}")
    int update(@Param("name") String name,@Param("hp") double hp,@Param("damage") double damage,@Param("id") int id);

    /**
     * 根据英雄id删除该英雄
     * @param id 英雄id
     * @return 删除是否成功
     */
    @Delete("delete from test where id = #{id}")
    int delete(@Param("id") int id);
}
