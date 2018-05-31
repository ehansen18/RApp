package com.example.ultim.rgames;

/**
 * Created by Em on 4/3/2018.
 */

import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sponsors extends Fragment {

    private View view;
    ListView simpleList;
    List<String> infoList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// Inflate the layout for this fragment
        view = inflater.inflate(R.layout.sponsor, container, false);

        simpleList = (ListView) view.findViewById(R.id.infoListView);
        infoList =  Arrays.asList(getResources().getStringArray(R.array.sponsorSchedule));

        InfoAdapter customAdapter = new InfoAdapter(getActivity(), infoList);
        simpleList.setAdapter(customAdapter);

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}