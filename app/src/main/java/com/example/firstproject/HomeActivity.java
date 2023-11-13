package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    Button button1;
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        button1 = findViewById(R.id.Button);
        button1.setOnClickListener(e -> {
            //pour appeller une autre activity on utilise le intent
            Intent intent = new Intent(this, ProductList.class);
            startActivity(intent);
        });
       /** button2 = findViewById(R.id.Button2);
        button2.setOnClickListener(e -> {
            //pour appeller une autre activity on utilise le intent
            Intent intent = new Intent(this, AddProductActivity.class);
            startActivity(intent);
        });**/
    }



    @Override
        public boolean onCreateOptionsMenu (Menu menu){

            getMenuInflater().inflate(R.menu.app_menu, menu);
            return true;
        }




}