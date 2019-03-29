package com.limon.user.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Alias("userInfo")
@Data
@NoArgsConstructor
public class UserInfo {

    private String id;
    private String username;
    private String password;
    private String nickname;
    private String mobile;
    private long birthday;
    private String regionCode;
    private String address;
    private int sex;
    private long registTime;
    private long lastLoginTime;
    private int status;
    private String headImage;
    private int source;
}
