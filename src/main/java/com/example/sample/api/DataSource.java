package com.example.sample.api;

import com.example.sample.model.*;

import org.springframework.web.servlet.function.ServerResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;

public class DataSource {
    StudentGrade studentGrade = null;
    StudentAccount studentAccount = null;
    StudentAddress address = null;
    Users user = null;
    private DataSourceUpdater observer = null;
    static DataSource instance = new DataSource();
    static String BASE_URL = "http://demo7675902.mockable.io/student/";
    static String BASE_ADDRESS_URL = "https://demo1585645.mockable.io/student/";

    private DataSource() {

    }

    public static DataSource getInstance() {
        return instance;
    }
    public StudentAccount getStudentAccount(){
        Call<StudentAccount> responseCall  = ApiClient.create(BASE_URL).getAccount();
        try {
            Response<StudentAccount> response = responseCall.execute();
            studentAccount = response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studentAccount;
    }

    public StudentGrade getStudentGrade() {
        Call<StudentGrade> responseCall  = ApiClient.create(BASE_URL).getGrades();
        try {
            Response<StudentGrade> response = responseCall.execute();
            studentGrade = response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studentGrade;
    }

    public StudentAddress getStudentAddress() {
        Call<StudentAddress> responseCall = ApiClient.create(BASE_ADDRESS_URL).getAddress();
        try {
            Response<StudentAddress> response = responseCall.execute();
            address = response.body();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return address;
    }

    public Users getAdmin() {
        Call<Users> responseCall = ApiClient.create(BASE_URL).getAdmin();
        try {
            Response<Users> response = responseCall.execute();
            user = response.body();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return user;
    }

    public Users getUsers() {
        Call<Users> responseCall = ApiClient.create(BASE_URL).getUsers();
        try {
            Response<Users> response = responseCall.execute();
            user = response.body();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return user;
    }

    public void setObserver(DataSourceUpdater observer){
        this.observer = observer;
    }
}
