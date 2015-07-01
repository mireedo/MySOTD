package com.team5.mysotd.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.team5.mysotd.R;

/**
 * Created by Mira on 6/29/2015.
 */
public class ShaveDen extends Fragment {
    View rootview;
    private ListView mDrawerListView;
    private View mFragmentContainerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_shave_den, container, false);
        return rootview;
    }
}
