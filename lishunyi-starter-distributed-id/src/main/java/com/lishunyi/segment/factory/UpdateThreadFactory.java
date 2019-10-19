package com.lishunyi.segment.factory;

import java.util.concurrent.ThreadFactory;

/**
 * @ClassName UpdateThreadFactory
 * @Description java类作用描述
 * @Author 李顺仪
 * @CreateDate 2019/10/19 11:00
 * @UpdateUser 李顺仪
 * @UpdateDate 2019/10/19 11:00
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
public class UpdateThreadFactory implements ThreadFactory {

    private Integer threadInitNumber = 0;

    private synchronized int nextThreadNum() {
        return threadInitNumber++;
    }

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, "Thread-Segment-Update-" + nextThreadNum());
    }
}
