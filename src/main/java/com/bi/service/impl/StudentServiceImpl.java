package com.bi.service.impl;

import com.bi.entity.Student;
import com.bi.exception.BaseException;
import com.bi.mapper.StudentMapper;
import com.bi.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> queryStudent() {
        return studentMapper.queryStudent();
    }

    @Override
    public Student queryStudentsById(Integer stuNo) {
        Student student = studentMapper.queryStudentsById(stuNo);
        if (student.getStuNo() == 0) {
            throw new BaseException("学号不存在,请重新输入");
        }
        return student;
    }

    @Override
    public int addStudent(String studName, int stuNo, String sex, String nation, String political, String school, String major, String birthday, String entranceTime) {
        Map<String, Object> map = new HashMap<>();
        map.put("studName", studName);
        map.put("stuNo", stuNo);
        map.put("sex", sex);
        map.put("nation", nation);
        map.put("political", political);
        map.put("school", school);
        map.put("major", major);
        map.put("birthday", birthday);
        map.put("entranceTime", entranceTime);
        return studentMapper.addStudent(map);
    }

    @Override
    public void editstudentByStuNo(Student student) {
        Student student1 = studentMapper.queryStudentsById(student.getStuNo());
        if (student1 == null) {
            throw new BaseException("学号不存在,请勿操作");
        }

//        if (student1.getStuNo() != student.getStuNo()) {
//            throw new BaseException("不是本人,请勿操作");
//        }
        if (student1 != null) {
            Student studentEdit = new Student();
            studentEdit.setMajor(student.getMajor());
            studentEdit.setStuNo(student.getStuNo());
            studentEdit.setStudName(student.getStudName());
            studentEdit.setSex(student.getSex());
            studentEdit.setSchool(student.getSchool());
            studentEdit.setPolitical(student.getPolitical());
            studentEdit.setNation(student.getNation());
            studentMapper.editstudentByStuNo(student);
        }
    }

    @Override
    public int delStudentByStuNo(int stuNo) {
        Student student1 = studentMapper.queryStudentsById(stuNo);
        if (student1.getStuNo() == 0) {
            throw new BaseException("学号不存在,请勿操作");
        }
        return studentMapper.delStudentByStuNo(stuNo);
    }


}
