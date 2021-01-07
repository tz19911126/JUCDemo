package com.yg.edu.disruptor;

import com.lmax.disruptor.EventHandler;
import com.yg.edu.disruptor.event.LongEvent;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ：杨过
 * @date ：Created in 2020/8/29
 * @version: V1.0
 * @slogan: 天下风云出我辈，一入代码岁月催
 * @description: 事件消费者
 **/
@Slf4j
public class LongEventHandler implements EventHandler<LongEvent> {

    public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
        log.info("消费者:{}",event.getValue());
    }

}
