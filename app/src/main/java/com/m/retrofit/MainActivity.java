package com.m.retrofit;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.m.retrofit.model.User;
import com.m.retrofit.retrofit_call.RetrofitCall;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener {

    public static final String BASE_URL = "http://www.mysafeinfo.com/";
    //public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    public static final String KEY_USER_NAME = "nm";
    public static final String KEY_USER_CITY = "key_user_city";
    public static final String KEY_USER_HOUSE = "key_user_house";
    public static final String KEY_USER_YEAR = "key_user_year";

    private ListView listView;
    private TextView listTextView;
    private List<User> user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        listTextView = findViewById(R.id.tv_list_name);
        getUser();

        listView.setOnItemClickListener(this);
    }

    private void getUser() {
        final ProgressDialog loading = ProgressDialog.show(this, "Fetching Data", "Please wait...", false, false);

        //Creating a rest adapter
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .build();

        RetrofitCall call = adapter.create(RetrofitCall.class);

        call.getUser(new Callback<List<User>>() {
            @Override
            public void success(List<User> users, Response response) {

                loading.dismiss(); //Dismissing the loading progressbar

                //Toast.makeText(MainActivity.this, "User List" + users.toString(), Toast.LENGTH_LONG).show();
                user = users;      //Storing data in our listVieww
                showList();        //Calling a method to show the list

            }

            @Override
            public void failure(RetrofitError error) {
                loading.dismiss();
                Toast.makeText(MainActivity.this, "Failed : " + error, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void showList() {

        String[] result = new String[user.size()];
        for (int i = 0; i < user.size(); i++) {
            result[i] = user.get(i).getNm();
        }

        //Creating an arrayAdapter for user list
        ArrayAdapter adapter = new ArrayAdapter<>(this, R.layout.item_list, result);
        //Toast.makeText(this, "User : " + result.toString(), Toast.LENGTH_SHORT).show();
        listView.setAdapter(adapter);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

        Intent intent = new Intent(this,UserDetailActivity.class);
        User u = user.get(position);
        intent.putExtra(KEY_USER_NAME,u.getNm());
        intent.putExtra(KEY_USER_CITY,u.getCty());
        intent.putExtra(KEY_USER_HOUSE,u.getHse());
        intent.putExtra(KEY_USER_YEAR,u.getYrs());

        startActivity(intent);

    }
}
