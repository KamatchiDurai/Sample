package com.example.sample.api;

import com.example.sample.model.StudentGrade;

public interface DataSourceUpdater {
    void updateGrade(StudentGrade studentGrade);
}