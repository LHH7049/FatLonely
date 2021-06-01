package com.no3003.fatlonely.access.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: lz
 * @Date: 2021/5/8 10:13
 */
@AllArgsConstructor
@Data
public class RegisterReq {
    private String accountName;
    private String pwd;
    private String code;
}
