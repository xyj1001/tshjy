package com.xyj.pojo;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * DM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Recorder {
   private  int id;
    private double airTemper; //空气温度
    private double airHum;   //空气湿度
    private double airQur;  // 空气质量
    private double lightInt; // 光照强度
    private double soilMoi;  // 土壤湿度
    private double soilPh;  // 土壤ph
    private LocalDateTime recordTime; // 记录时间
}
