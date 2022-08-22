package com.bi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author coder-zc
 * @date 2022年08月20日 11:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConnEntity {
    // 驱动器
    String driverName;
    // 连接对象地址
    String url;
    // 用户
    String user;
    // 密码
    String password;
}
