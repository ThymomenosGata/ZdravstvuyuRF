package com.ilatis.zdravstvuyurf;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.ilatis.zdravstvuyurf.Fragments.Registrations.EnterPhone;

public class RegistrationActivity extends AppCompatActivity {

    private void loadFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.regContainer, fragment);
        ft.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.mipmap.ic_logo_1);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        loadFragment(EnterPhone.newInstace());
    }
}
