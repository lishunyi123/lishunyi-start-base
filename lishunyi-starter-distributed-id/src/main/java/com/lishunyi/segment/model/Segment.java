package com.lishunyi.segment.model;

import lombok.Data;

import java.util.concurrent.atomic.AtomicLong;

@Data
public class Segment {
    private AtomicLong value = new AtomicLong(0);
    private volatile long max;
    private volatile int step;
    private SegmentBuffer buffer;

    public long getIdle() {
        return this.getMax() - getValue().get();
    }
    public Segment(SegmentBuffer buffer) {
        this.buffer = buffer;
    }
}
