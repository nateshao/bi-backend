package com.bi;

import com.bi.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @date Created by JOYY on 2022/8/26 15:35
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
@SpringBootTest
public class DemoTest {
    @Test
    public void demo(){
        Object o = new Object();

        boolean equals = o.equals(new Student());
    }
}
