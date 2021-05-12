package com.no3003.fatlonely.util;

import java.util.Objects;

/**
 * @Author: lz
 * @Date: 2021/5/12 16:01
 */
public class HashUtil {
    private static final int HASH_STR_LENGTH = 16;
    private static final int HASH_SALT_STR_LENGTH = 32;

    public static String addHashSalt(String hashStr){
        if (hashStr.length() != HASH_STR_LENGTH){
            return hashStr;
        }
        StringBuilder result = new StringBuilder("");
        for (int i = 0 ; i < HASH_SALT_STR_LENGTH; i ++){
            if (i % 2 == 0){
                result.append(hashStr.charAt(i));
            } else {
                result.append(SALT.charAt(i));
            }
        }
        return result.toString();
    }

    public static String removeHashSalt(String hashSaltStr){
        if (hashSaltStr.length() != HASH_SALT_STR_LENGTH){
            return hashSaltStr;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0 ; i < HASH_SALT_STR_LENGTH; i ++){
            if (i % 2 == 0){
                result.append(hashSaltStr.charAt(i));
            } else if (!Objects.equals(hashSaltStr.charAt(i), SALT.charAt(i))){
                return hashSaltStr;
            }
        }
        return result.toString();
    }

    private static final String SALT = "314hjdsa32jlfkd2348932hfda32nm24gd23hjkdahtr321ghjkldf1j23h4jklda" +
            "314hjlhfjdklh32j1l4hjklsdah3y78doa389fydajhlkdfdhfdlkahj38yfdah3jk2lqthjlda";
}
