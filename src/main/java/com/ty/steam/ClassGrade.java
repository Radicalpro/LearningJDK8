package com.ty.steam;

import lombok.Data;

import java.util.List;

/**
 * 班级
 *
 * @author tianyi
 */
@Data
public class ClassGrade {

    /**
     * 年级
     */
    private int gradeLeven;

    /**
     * 班
     */
    private int grade;

    /**
     * 班级里的学生
     */
    private List<Student> students;
}
