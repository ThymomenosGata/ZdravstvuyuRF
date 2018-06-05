package com.ilatis.zdravstvuyurf.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ilatis.zdravstvuyurf.HelperClass.Services;
import com.ilatis.zdravstvuyurf.R;

import java.util.ArrayList;

public class ServiceAdapter extends BaseAdapter{

    private Context ctx;
    private LayoutInflater inflater;
    private ArrayList<Services> objects;

    public ServiceAdapter(Context ctx, ArrayList<Services> objects) {
        this.ctx = ctx;
        this.inflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.objects = objects;
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int i) {
        return objects.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.list_service, viewGroup, false);
        }
        Services list = getService(i);
        // заполняем View в пункте списка данными
        ((TextView) view.findViewById(R.id.service_)).setText(String.valueOf(list.getmService()));
        return view;
    }

    Services getService(int position) {
        return ((Services) getItem(position));
    }
}
