package com.ilatis.zdravstvuyurf.Fragments.Registrations;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ilatis.zdravstvuyurf.R;

public class EnterCode extends Fragment {
    public EnterCode() { }
    public static EnterCode newInstace(){
        return new EnterCode();
    }
    private View mView;
    private Button butNext;
    private Button butUndo;

    private void loadFragment(Fragment fragment) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.regContainer, fragment);
        ft.commit();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.enter_code_fragment, container, false);
        butNext = (Button)mView.findViewById(R.id.next);
        butUndo = (Button)mView.findViewById(R.id.undo);

        butUndo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(EnterPhone.newInstace());
            }
        });
        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(EnterPassword.newInstace());
            }
        });

        return mView;
    }
}
