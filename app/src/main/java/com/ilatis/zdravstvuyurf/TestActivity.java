package com.ilatis.zdravstvuyurf;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.ilatis.zdravstvuyurf.Fragments.questions.FirstQw;

public class TestActivity extends AppCompatActivity {

    private void loadFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.test_content, fragment);
        ft.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        toolbar.setLogo(R.mipmap.ic_logo_1);
        setSupportActionBar(toolbar);
        loadFragment(FirstQw.newInstace());

    }

}
