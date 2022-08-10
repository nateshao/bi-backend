package com.bi.service;

import com.bi.entity.Student;

import java.util.List;

public interface StudentService {
    public List<Student> queryStudent();

    public Student queryStudentsById(Integer id);

    int addStudent(String studName, int stuNo, String sex, String nation, String political, String school, String major, String birthday, String entranceTime);

    void editstudentByStuNo(Student student);

    int delStudentByStuNo(int stuNo);
}
