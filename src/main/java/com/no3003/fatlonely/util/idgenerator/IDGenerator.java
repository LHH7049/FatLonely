package com.no3003.fatlonely.util.idgenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: lz
 * @Date: 2021/5/14 14:54
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class IDGenerator {
    private AtomicInteger cur;
    private AtomicInteger limit;
    private String groupCode;

    public static final int OVER_LIMIT_CODE = -1;

    synchronized int getAndIncr(){
        if (enough()){
            return cur.getAndIncrement();
        }
        // 废弃标识
        return OVER_LIMIT_CODE;
    }

    synchronized boolean enough(){
        return cur.get() <= limit.get();
    }
}
