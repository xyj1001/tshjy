package com.xyj.mapper;

import com.xyj.pojo.Recorder;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 部门管理
 */
@Mapper
public interface MessageMapper {
    /**
     * 记录数据
     */
    @Insert("insert into records(air_temper, air_hum, air_qur, light_int, soil_moi, soil_ph, record_time) values(#{airTemper},#{airHum},#{airQur},#{lightInt},#{soilMoi},#{soilPh},#{recordTime})")
    void insertRecords(Recorder recorder);


    /**
     * 查询数据
     */
    @Select("select * from records")
    List<Recorder> selectRecords();
}
