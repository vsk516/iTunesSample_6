package com.gopi.itunes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SearchScreenFragment homePageFragment = new SearchScreenFragment();
        getFragmentManager().beginTransaction().replace(R.id.container, homePageFragment).commit();
    }

}
