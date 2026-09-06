package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PageFragment extends Fragment {
    private static final String ARG_NUM = "num";

    public static PageFragment newInstance(int num) {
        PageFragment f = new PageFragment();
        Bundle b = new Bundle();
        b.putInt(ARG_NUM, num);
        f.setArguments(b);
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        TextView tv = new TextView(requireContext());
        int num = getArguments() != null ? getArguments().getInt(ARG_NUM) : 0;
        tv.setText("Page " + num);
        tv.setTextSize(28f);
        tv.setGravity(android.view.Gravity.CENTER);
        return tv;
    }
}
