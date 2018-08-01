package com.ty.steam;

import lombok.Data;

/**
 * 学生实体类
 *
 * @author tianyi
 */
@Data
public class Student {

    /**
     * 学号
     */
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private int age;
}
