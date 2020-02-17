package com.students.students;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.students.students.Model.StudentsModel;
import com.students.students.Network.ConnectorService;

import java.lang.reflect.Array;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static java.lang.Integer.valueOf;


public class MainActivity extends AppCompatActivity {

    EditText id;
    TextView name,gender,class_title,remark;
    CheckBox yes,no;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = findViewById(R.id.id);
        name = findViewById(R.id.name);
        gender = findViewById(R.id.gender);
        class_title = findViewById(R.id.class_title);
        remark = findViewById(R.id.remark);
        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);


        id.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {

                        getStudentInfo(id.getText().toString());
                    Log.d("TTT", "onEditorAction: "+id);

                    return true;
                }
                return false;
            }
        });

        getStudentInfo(id.getText().toString());

    }

    public void getStudentInfo(String id){
        Log.d("TTT", "getStudentInfo: "+id);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConnectorService.BaseURL)
                .addConverterFactory(GsonConverterFactory.create(new Gson())).build();

        ConnectorService connectorService = retrofit.create(ConnectorService.class);

      connectorService.getStudent(id).enqueue(new Callback<ArrayList<StudentsModel>>() {


          @Override
          public void onResponse(Call<ArrayList<StudentsModel>> call, Response<ArrayList<StudentsModel>> response) {
              Log.d("TTT", "onResponse: "+call.request().url());
              if (response.isSuccessful()) {
                  Log.d("TTT", "onResponse: " + response.body().size());
                  Log.d("TTT", "onResponse: " + response.code());
                 // Log.d("TTT", "onResponse: " + response.body().get(0).getTrName() + "");

                  if (response.body().isEmpty()) {
                      Toast.makeText(MainActivity.this, "student with this id doesn't exist", Toast.LENGTH_LONG).show();
                      return;
                  }
                  else
                  {
                      name.setText(response.body().get(0).getTrName() + "");
                  if (response.body().get(0).getGenderID() == 1) {
                      gender.setText("ذكر");
                  } else {
                      gender.setText("انثى");
                  }
                  class_title.setText(response.body().get(0).getClassTitle() + "");
                  if (response.body().get(0).getRemark() == null) {
                      remark.setText(" ");
                  } else {
                      remark.setText(response.body().get(0).getRemark() + "");
                  }
                  if (response.body().get(0).getIsActive() == true) {
                      yes.setChecked(true);
                      no.setChecked(false);
                  } else {
                      no.setChecked(true);
                      yes.setChecked(false);
                  }
              }
              }
          }

          @Override
          public void onFailure(Call<ArrayList<StudentsModel>> call, Throwable t) {
              Log.d("TTT", "onResponse: "+t.getMessage());
          }
      });


}
}
