package com.ade.daggerroomdatabinding.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.ade.daggerroomdatabinding.MyApp;
import com.ade.daggerroomdatabinding.R;
import com.ade.daggerroomdatabinding.adapter.MyAdapter;
import com.ade.daggerroomdatabinding.database.UserDao;
import com.ade.daggerroomdatabinding.databinding.ActivityMainBinding;
import com.ade.daggerroomdatabinding.entity.User;

import java.util.List;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    String name, email, age;

    @Inject
    UserDao userDao;

    private MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        MyApp.app().appComponent().inject(this);

        binding.resyclerview.setLayoutManager(new LinearLayoutManager(this));

        binding.insertdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showEntryBox();

            }
        });

        new RequestData().execute();

    }

    private void showEntryBox() {

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        View view= LayoutInflater.from(this).inflate(R.layout.entry_box,null);

        final EditText etname=(EditText)view.findViewById(R.id.etname);
        final EditText etemail=(EditText)view.findViewById(R.id.etemail);
        final EditText etcity=(EditText)view.findViewById(R.id.etcity);

        builder.setView(view);
        builder.setNegativeButton("Insert", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                name = etname.getText().toString();
                email = etemail.getText().toString();
                age = etcity.getText().toString();

                new RequestData().execute();
                dialogInterface.dismiss();
            }
        });
        builder.show();

    }

    private void insert(String name, String email, String age) {
        User myUserData=new User();
        myUserData.setFirstName(name);
        myUserData.setLastName(email);
        myUserData.setAge(age);
        userDao.insert(myUserData);
    }


    private void getdata(List<User> users){
        adapter = new MyAdapter(users);
        binding.resyclerview.setAdapter(adapter);
    }

    private class RequestData extends AsyncTask<Void, Void, List<User>> {
        @Override
        protected List<User> doInBackground(Void... voids) {

            if (name == null||email == null|| age == null){
                userDao.all();
            }
            else {
                insert(name, email, age);
            }

            return userDao.all();

        }

        @Override
        protected void onPostExecute(List<User> user) {
            getdata(user);
        }
    }
}