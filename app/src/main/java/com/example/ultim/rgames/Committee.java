package com.example.ultim.rgames;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Em on 4/8/2018.
 */

public class Committee extends Fragment {
    private View view;
    ListView simpleList;
    List<String> infoList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// Inflate the layout for this fragment
        view = inflater.inflate(R.layout.committee, container, false);

        simpleList = (ListView) view.findViewById(R.id.committeeListView);
        infoList =  Arrays.asList(getResources().getStringArray(R.array.committeeList));

        CommitteeAdapter customAdapter = new CommitteeAdapter(getActivity(), infoList);
        simpleList.setAdapter(customAdapter);

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
