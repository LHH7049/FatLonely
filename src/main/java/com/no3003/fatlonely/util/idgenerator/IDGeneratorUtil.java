package com.no3003.fatlonely.util.idgenerator;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: lz
 * @Date: 2021/5/14 14:36
 */
public class IDGeneratorUtil {

    public static Map<String, IDGenerator> idMap = new ConcurrentHashMap<>();

    public static int getIdFromGroup(String groupCode){
        // 从本地缓存中取出 id
        int id = idMap.get(groupCode).getAndIncr();
        if (id != IDGenerator.OVER_LIMIT_CODE){
            return id;
        } else {
            // 生成新的ID生成器
            synchronized (idMap.get(groupCode)){
                if (!idMap.get(groupCode).enough()){
                    idMap.put(groupCode, buildIDGenerator(groupCode));
                }
            }
        }
        return 0;
    }

    private static IDGenerator buildIDGenerator(String groupCode) {
        // 取出数据库值
        int dbCur = getDBCur(groupCode);
        // 取区间
        return getDBGenerator(groupCode, dbCur);
    }

    //CREATE TABLE `id_generator`(
    //	`id` INT AUTO_INCREMENT,
    //	`cur` INT Comment  '当前数',
    //	`range` INT Comment '增加区间',
    //	`groupCode` VARCHAR(20) Comment '分组依据',
    //	`desc` VARCHAR(100) Comment '备注',
    //	PRIMARY KEY(`id`),
    //	unique index idx_unique_code(`groupCode`)
    //)ENGINE=INNODB DEFAULT CHARSET=UTF8MB4;

    private static IDGenerator getDBGenerator(String groupCode, int dbCur) {
        // update table set cur = dbCur + range where groupCode = groupCode and cur = dbCur;

        return null;
    }

    private static int getDBCur(String groupCode) {
        // select cur from table where groupCode = groupCode;
        return 0;
    }

}
