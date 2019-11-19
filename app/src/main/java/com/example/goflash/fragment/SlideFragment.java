package com.example.goflash.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.goflash.R;

public class SlideFragment extends Fragment {
    private static final String ARG_POSITION = "position";

    private int position;
    private LinearLayout layout;
    private TextView icon;

    public static SlideFragment newInstance(int position) {
        SlideFragment f = new SlideFragment();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        f.setArguments(b);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt(ARG_POSITION);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_slide,
                container, false);
        layout = rootView
                .findViewById(R.id.fragment_wizard_universal_layout);
        icon = rootView
                .findViewById(R.id.fragment_wizard_universal_icon);

        if (position == 0) {
//            layout.setBackgroundColor(getResources().getColor(R.color.material_purple_300));
//            layout.invalidate();
//            icon.setText(R.string.material_icon_cloud_first);
            layout.setBackground(getResources().getDrawable(R.drawable.bri_banner));
            icon.setVisibility(View.GONE);
        } else if (position == 1) {
//            layout.setBackgroundColor(getResources().getColor(
//                    R.color.material_purple_700));
//            layout.invalidate();
//            icon.setText(R.string.material_icon_cloud_second);
            layout.setBackground(getResources().getDrawable(R.drawable.bri_banner));
            icon.setVisibility(View.GONE);
        } else {
//            layout.setBackgroundColor(getResources().getColor(
//                    R.color.material_purple_900));
//            layout.invalidate();
//            icon.setText(R.string.material_icon_cloud_third);
            layout.setBackground(getResources().getDrawable(R.drawable.bri_banner));
            icon.setVisibility(View.GONE);
        }

        ViewCompat.setElevation(rootView, 50);
        return rootView;
    }
}