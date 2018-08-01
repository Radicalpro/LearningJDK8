package com.ty.steam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 测试类
 *
 * @author tianyi
 */
public class Test {

    public static void main(String[] args) {
        String contents = "ddada.faqwewq.dsadasdasddsas.sda.dadqweqd.sadas.gfhfhjhgngh";
        List<String> words = Arrays.asList(contents.split("."));
//        int count = 0;
//        for (String word : words) {
//            if (word.length() > 5) {
//                count++;
//            }
//        }
//        System.out.println("字段超过5的个数：" + count);

        long count = words.stream().filter(word -> word.length() > 5).count();
        System.out.println("字段超过5的个数：" + count);

        //省略add，懒
        List<Student> students = new ArrayList<>();

        List<Student> newStudents = new ArrayList<>();

        //过滤出大于18岁的学生集合
        for (Student student : students) {
            if (student.getAge() > 18) {
                newStudents.add(student);
            }
        }
        //stream 过滤出大于18岁的学生集合
        newStudents = students.stream()
                .filter(student -> student.getAge() > 18)
                .collect(Collectors.toList());

        //对姓名元素进行操作，组合成新集合
        List<String> names = students.stream()
                .filter(student -> student.getAge() > 18)
                .map(Student::getName).collect(Collectors.toList());

        //班级集合
        List<ClassGrade> classGrades = new ArrayList<>();
        //将所有班级的学生组成新集合
        List<Student> studentList = new ArrayList<>();
        for (ClassGrade classGrade : classGrades) {
            studentList.addAll(classGrade.getStudents());
        }
        //stream 将所有班级的学生组成新集合
        studentList = classGrades.stream()
                .flatMap(classGrade -> classGrade.getStudents().stream())
                .collect(Collectors.toList());


        //Optional 类
        //拿到所有班级学生的第一个
        Optional<Student> studentOptional;
        Student student;
        //拿到Optional，判断是否为null进行取值
        studentOptional = classGrades.stream()
                .flatMap(classGrade -> classGrade.getStudents().stream()).sorted().findFirst();
        if(studentOptional.isPresent()){
            student = studentOptional.get();
        }
        //为空的话，自己new 值
        student = classGrades.stream()
                .flatMap(classGrade -> classGrade.getStudents().stream()).sorted().findFirst().orElse(new Student());
        //还可以抛异常
        student = classGrades.stream()
                .flatMap(classGrade -> classGrade.getStudents().stream()).sorted().findFirst().orElseThrow(NullPointerException::new);


    }
}
