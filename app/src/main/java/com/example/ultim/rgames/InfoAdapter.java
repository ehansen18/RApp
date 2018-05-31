package com.example.ultim.rgames;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ultim on 5/1/2018.
 */

public class InfoAdapter extends BaseAdapter {
    Context context;
    List<String> infoList;
    LayoutInflater inflater;

    public InfoAdapter(Context applicationContext, List<String> infoList) {
        this.context = context;
        this.infoList = infoList;
        inflater = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return infoList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.listview, null);
        TextView info = (TextView) view.findViewById(R.id.infoView);
        info.setText(infoList.get(i));
        return view;
    }

}