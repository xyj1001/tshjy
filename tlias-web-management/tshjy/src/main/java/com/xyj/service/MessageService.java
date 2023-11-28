package com.xyj.service;
import com.xyj.pojo.Recorder;

import java.util.List;

/**
 * 部门管理
 */
public interface MessageService {

    /**
     * Recoder
     * @return
     */


    void saveRecords(Recorder recorder);


    List<Recorder> getRecords();
}
