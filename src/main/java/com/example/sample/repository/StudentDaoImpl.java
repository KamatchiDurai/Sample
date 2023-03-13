package com.example.sample.repository;

import com.example.sample.model.Student;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Map;

@Repository
public class StudentDaoImpl implements IStudentDao {

    private final String hashReference= "Student";

    @Resource(name="redisTemplate")          // 'redisTemplate' is defined as a Bean in AppConfig.java
    private HashOperations<String, Integer, Student> hashOperations;

    @Override
    public void saveStudent(Student emp) {
        //creates one record in Redis DB if record with that Id is not present
        hashOperations.putIfAbsent(hashReference, Integer.parseInt(emp.studentId), emp);
    }

    @Override
    public void saveAllStudents(Map<Integer, Student> map) {
        hashOperations.putAll(hashReference, map);
    }

    @Override
    public Student getOneStudent(Integer id) {
        return hashOperations.get(hashReference, id);
    }

    @Override
    public void updateStudent(Student emp) {
        hashOperations.put(hashReference, Integer.parseInt(emp.studentId), emp);
    }

    @Override
    public Map<Integer, Student> getAllStudents() {
        return hashOperations.entries(hashReference);
    }

    @Override
    public void deleteStudent(Integer id) {
        hashOperations.delete(hashReference, id);
    }
}
