package com.yg.edu.disruptor.event;

import com.lmax.disruptor.EventFactory;

/**
 * @author ：杨过
 * @date ：Created in 2020/8/29
 * @version: V1.0
 * @slogan: 天下风云出我辈，一入代码岁月催
 * @description:
 **/
public class LongEventFactory implements EventFactory<LongEvent> {

    public LongEvent newInstance() {
        return new LongEvent();
    }

}
