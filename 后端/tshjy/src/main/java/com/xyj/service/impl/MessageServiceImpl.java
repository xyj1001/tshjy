package com.xyj.service.impl;

import com.xyj.mapper.MessageMapper;
import com.xyj.pojo.Recorder;
import com.xyj.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;



/*
*
*  Record
* */
    @Override
    public void saveRecords(Recorder recorder) {
        messageMapper.insertRecords(recorder);
    }

    @Override
    public List<Recorder> getRecords() {
        return  messageMapper.selectRecords();
    }


}
