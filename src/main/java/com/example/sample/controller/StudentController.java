package com.example.sample.controller;

import com.example.sample.api.DataSource;
import com.example.sample.api.DataSourceUpdater;
import com.example.sample.model.*;
import com.example.sample.repository.IStudentDao;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
public class StudentController implements DataSourceUpdater {

    public DataSource dataSource;
    private StudentGrade studentGrade;
    private StudentAccount studentAccount;
    private StudentAddress address;
    private Users user;
    private long time;
    private long pastTime;

    @Autowired
    private IStudentDao studentDao;

    public StudentController() {
        dataSource = DataSource.getInstance();
        dataSource.setObserver(this);
    }

    @RequestMapping("/api/student")
    public ResponseEntity<Map<Integer,Student>> returnConsolidatedStudentDetail() throws JsonProcessingException {
        studentAccount = dataSource.getStudentAccount();
        studentGrade = dataSource.getStudentGrade();
        address = dataSource.getStudentAddress();
        time = System.currentTimeMillis();
        Student student = null;
        if(pastTime == 0 || (time-pastTime)/60000 > 5) {
            student = new Student(studentAccount.studentNumber, studentAccount, address, studentGrade);
            if(pastTime == 0) studentDao.saveStudent(student);
            else studentDao.updateStudent(student);
            pastTime = time;
        }
        return ResponseEntity.ok(studentDao.getAllStudents());
    }

    @RequestMapping("/api/user")
    public ResponseEntity<Users> getUser() throws JsonProcessingException {
        user = dataSource.getUsers();
        return ResponseEntity.ok(user);
    }

    @RequestMapping("/api/admin")
    public ResponseEntity<Users> getAdmin() throws JsonProcessingException {
        user = dataSource.getAdmin();
        return ResponseEntity.ok(user);
    }


    @Override
    public void updateGrade(StudentGrade studentGrade) {
        this.studentGrade = studentGrade;
    }
}
