package com.limon.user.viewobject;

import com.limon.common.enums.SexEnums;
import com.limon.common.viewobject.DateVo;
import com.limon.common.viewobject.RegionVo;
import com.limon.user.enums.UserSourceEnums;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoVo {

    private String userId;
    private String username;
    private String password;
    private String nickname;
    private String mobile;
    private DateVo birthday;
    private RegionVo regionInfo;
    private String address;
    private SexEnums sex;
    private String headImage;
    private DateVo registTime;
    private DateVo lastLoginTime;
    private UserSourceEnums source;
}
