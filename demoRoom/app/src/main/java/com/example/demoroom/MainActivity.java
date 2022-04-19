package com.example.demoroom;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.demoroom.db.AppDatabase;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private UserListAdapter userListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addNewUserButton findViewById(R.id.addNewUserButton);
        addNewUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(packageContext: MainActivity.this, AddNewUserActivity.class), requestCode:100 );

            }
        });

        initRecyclerView();

        loadUserList();

    }
    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager( context: this));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(context: this, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(dividerItemDecoration);
        userListAdapter = new UserListAdapter(this);
        recyclerView.setAdapter(userListAdapter);
        recyclerView.setAdapter();

    }

    private void loadUserList(){
        AppDatabase db =AppDatabase.getDbInstance(this.getApplicationContext());
        List<User> userList = db.userDao().getAllUsers();
        userListAdapter.setUserList(userList);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        if (requestCode == 100){

        }
            super.onActivityResult(requestCode, resultCode, data);
    }
}