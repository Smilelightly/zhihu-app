package com.scs.soft.zhihu.api.mapper;
import com.scs.soft.zhihu.api.entity.Special;
import org.apache.ibatis.annotations.*;
import javax.xml.crypto.Data;
import java.util.List;
import java.util.Map;

/**
 * @author ABC
 * @date 2020/1/16 12:34
 */
public interface SpecialMapper {
    /**
     * 批量增加
     * @description 批量增加
     */
    @Insert("<script>"+
            "INSERT INTO t_special (special_id ,introduction,banner,view_count,followers_count,updated,sections) VALUES"+
            "<foreach collection=\"list\" item=\"special\" index=\"index\" separator=\",\">" +
            "(#{special.specialId},#{special.title},#{special.introduction},#{special.banner},#{special.viewCount},#{special.followersCount},#{special.updated},#{special.sections}) " +
            "</foreach>"+
            "</script>")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void batchInsert(@Param("list") List<Special> specials);

    /**
     * 查询最新专题
     * @return
     */

    @Select("SELECT * FROM t_special ORDER BY updated DESC DESC LIMIT 0,4")
    List<Special> selectRecent();


    /**
     * 查询所有专题
     */
    @Select("SELECT * FROM t_special")
    @Results({
            @Result(id = true,property = "specialId",column = "special_id",javaType = String.class),
            @Result(property = "title",column = "title",javaType =String.class),
            @Result(property = "introduction",column = "introduction",javaType =String.class ),
            @Result(property = "banner",column = "banner",javaType =String.class ),
            @Result(property = "viewCount",column = "view_count",javaType =Integer.class ),
            @Result(property = "followersCount",column = "followers_count",javaType =Integer.class ),
            @Result(property = "updated",column = "updated",javaType = Data.class),
            @Result(property = "sections",column = "special_id",
                    many = @Many(select = "com.scs.zhihu.api.mapper.SectionMapper.getSectionsBySpecialId")),
    })
    List<Map> selectAll();
}
