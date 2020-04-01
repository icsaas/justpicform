package com.numerx.formboot.trial.mapper;

import com.numerx.formboot.trial.entity.Trial;
import org.apache.ibatis.annotations.*;
import org.springframework.context.annotation.Primary;

import java.util.List;

/**
 * 通过注解方式完成接口的实现
 */
@Mapper
@Primary
public interface TrialMapper {
    /**根据英雄id查询英雄属性
     * @param 传入的id
     * @return 查询的结果集
     */
    @Select("select * from trial where id = #{id}")
    Trial returnById(@Param("id") int id);

    /**
     * 返回trial表中的所有数据
     * @return 所有结果集
     */
    @Select("select * from trial")
    List<Trial> returnResult();
    /**
     * 实现数据插入功能
     * @param name 英雄名
     * @param hp 英雄血量值
     * @param damage 英雄伤害值
     * @return 插入是否成功
     */
    @Insert("insert into trial(name, hp, damage) VALUES(#{name}, #{hp}, #{damage})")
    int insert(@Param("name") String name,@Param("hp") double hp,@Param("damage") double damage);

    /**
     *根据英雄id更新英雄属性
     * @param name 英雄名
     * @param hp 英雄血量
     * @param damage 英雄伤害
     * @param id 英雄id
     * @return 更新是否成功
     */
    @Update("update trial set name = #{name},hp = #{hp},damage = #{damage} where id = #{id}")
    int update(@Param("name") String name,@Param("hp") double hp,@Param("damage") double damage,@Param("id") int id);

    /**
     * 根据英雄id删除该英雄
     * @param id 英雄id
     * @return 删除是否成功
     */
    @Delete("delete from trial where id = #{id}")
    int delete(@Param("id") int id);
}
