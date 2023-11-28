package com.xyj.controller;
import com.xyj.pojo.*;
import com.xyj.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
public class MessageController {

    //private static Logger log = LoggerFactory.getLogger(DeptController.class);
    @Autowired
    private MessageService messageService;


    @PostMapping ("/record")
    public Result Comment(@RequestBody Recorder recorder){
        log.info("记录检测数据:{}",recorder);
        messageService.saveRecords(recorder);
        return Result.success("成功");
    }

    @GetMapping ("/record")
    public Result test(@RequestParam(name="air_temper") Double airTemper,
                       @RequestParam(name="air_hum") Double airHum,
                       @RequestParam(name="air_qur") Double airQur,
                       @RequestParam(name="light_int") Double lightInt,
                       @RequestParam(name="soil_moi") Double soilMoi,
                       @RequestParam(name="soil_ph") Double soilPh,
                       @RequestParam(name="record_time") String recordTime){
        log.info("Air Temperature: {}", airTemper);
        log.info("Air Humidity: {}", airHum);
        log.info("Air Quality: {}", airQur);
        log.info("Light Intensity: {}", lightInt);
        log.info("Soil Moisture: {}", soilMoi);
        log.info("Soil pH: {}", soilPh);
        log.info("Record Time: {}", recordTime);
        Recorder recorder = new Recorder();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
        LocalDateTime dateTime = LocalDateTime.parse(recordTime, formatter);


        recorder.setRecordTime(dateTime);
        recorder.setAirTemper(airTemper);
        recorder.setAirHum(airHum);
        recorder.setAirQur(airQur);
        recorder.setLightInt(lightInt);
        recorder.setSoilMoi(soilMoi);
        recorder.setSoilPh(soilPh);


        messageService.saveRecords(recorder);

        return Result.success("成功");
    }

    @GetMapping ("/getRecords")
    public Result Comment(){
        log.info("显示所有检测数据");
        return Result.success( messageService.getRecords());
    }


}
