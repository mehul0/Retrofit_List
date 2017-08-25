package com.m.retrofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class UserDetailActivity extends AppCompatActivity {

    private TextView tvName;
    private TextView tvCity;
    private TextView tvHouse;
    private TextView tvYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        if (getActionBar() != null){
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }

        tvName = findViewById(R.id.tv_name);
        tvCity = findViewById(R.id.tv_city);
        tvHouse = findViewById(R.id.tv_house);
        tvYear = findViewById(R.id.tv_year);

        Intent intent = getIntent();

        tvName.setText(intent.getStringExtra(MainActivity.KEY_USER_NAME));
        tvCity.setText(intent.getStringExtra(MainActivity.KEY_USER_CITY));
        tvHouse.setText(intent.getStringExtra(MainActivity.KEY_USER_HOUSE));
        tvYear.setText(intent.getStringExtra(MainActivity.KEY_USER_HOUSE));

    }
}
