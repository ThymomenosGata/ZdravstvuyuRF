package com.ilatis.zdravstvuyurf.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ilatis.zdravstvuyurf.Adapters.ServiceAdapter;
import com.ilatis.zdravstvuyurf.HelperClass.Services;
import com.ilatis.zdravstvuyurf.R;

import java.util.ArrayList;

public class ServiceFragment extends Fragment {
    public ServiceFragment() {
    }
    
    public static ServiceFragment newInstace(){
        return new ServiceFragment();
    }
    
    private View mView;
    private ListView listView;
    ServiceAdapter adapter;

    
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.service_fragment, container, false);
        ArrayList<Services> serv = new ArrayList<>();
        listView = (ListView)mView.findViewById(R.id.services);
        listView.setVerticalScrollBarEnabled(false);
        serv.add(new Services("Контроль веса"));
        serv.add(new Services("Здоровое питание"));
        serv.add(new Services("Отказ от курения"));
        serv.add(new Services("Персональный менеджер здоровья"));
        serv.add(new Services("Напоминания"));
        serv.add(new Services("Поднятие иммунитета"));
        serv.add(new Services("Сдача анализов"));
        serv.add(new Services("Домашний медосмотр"));
        serv.add(new Services("Здоровое сердце"));
        serv.add(new Services("Жду малыша"));
        serv.add(new Services("Хочу быть мамой"));
        serv.add(new Services("Хочу быть папой"));
        adapter = new ServiceAdapter(getContext(), serv);
        listView.setAdapter(adapter);
        return mView;
    }
    
    
}
