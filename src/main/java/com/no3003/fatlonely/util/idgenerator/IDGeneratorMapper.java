package com.no3003.fatlonely.util.idgenerator;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author: lz
 * @Date: 2021/5/14 15:43
 */
@Mapper
@Repository
public interface IDGeneratorMapper {
    IDGenerator getDBGenerator(@Param("groupCode") String groupCode, @Param("dbCur") int dbCur);

    int getDBCur(@Param("groupCode") String groupCode);
}
