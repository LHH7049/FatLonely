package com.no3003.fatlonely.access.mapper;

import com.no3003.fatlonely.access.data.UserAccessDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @Author: lz
 * @Date: 2021/5/11 9:42
 */
@Mapper
@Repository
public interface UserAccessMapper {

    UserAccessDo getUserAccessByAccount(@Param("account") int account);

    int existsAccount(@Param("account") String account);

    int addUserAccess(@Param("do") UserAccessDo userAccess);

    int updateUserAccessLastRemarksByAccount(@Param("account") int account, @Param("lastLoginIp") String lastLoginIp, @Param("lastLoginTime") Date lastLoginTime);

    int updateUserAccess(@Param("userAccess") UserAccessDo userAccess);

    int deleteUserAccessByAccount(@Param("account") String account);
}
