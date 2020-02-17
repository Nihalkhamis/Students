package com.students.students.Network;

import com.students.students.Model.StudentsModel;

import java.lang.reflect.Array;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ConnectorService {

   public String BaseURL = "http://192.168.1.121/hmh/api/students/";

    @GET("{id}")
    Call<ArrayList<StudentsModel>> getStudent(@Path("id") String id);
}
