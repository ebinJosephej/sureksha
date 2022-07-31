package com.ebin.sureksha;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ebin.sureksha.databinding.FragmentFireTipsTabsBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FireTipsTabsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FireTipsTabsFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "position";

    private int position;

    private Context context;
    private FragmentFireTipsTabsBinding binding;

    public FireTipsTabsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param position Parameter 1.
     * @return A new instance of fragment FireTipsTabsFragment.
     */
    public static FireTipsTabsFragment newInstance(int position) {
        FireTipsTabsFragment fragment = new FireTipsTabsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            position = getArguments().getInt(ARG_PARAM1);
        }
        context = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_fire_tips_tabs, container, false);
        initValues();
        initViews();
        return binding.getRoot();
    }

    private void initValues(){

    }

    private void initViews(){
        switch (position){
            case 0:
                binding.imgBanner.setImageDrawable(context.getDrawable(R.drawable.fire_class_a));
                binding.tvTitle.setText(context.getString(R.string.fire_tip_title_1));
                binding.tvDescription.setText(context.getString(R.string.fire_tip_description_1));
                binding.tvExtinguishers.setText(context.getString(R.string.fire_tip_extinguishers_1));
                break;
            case 1:
                binding.imgBanner.setImageDrawable(context.getDrawable(R.drawable.fire_class_b));
                binding.tvTitle.setText(context.getString(R.string.fire_tip_title_2));
                binding.tvDescription.setText(context.getString(R.string.fire_tip_description_2));
                binding.tvExtinguishers.setText(context.getString(R.string.fire_tip_extinguishers_2));
                break;
            case 2:
                binding.imgBanner.setImageDrawable(context.getDrawable(R.drawable.fire_class_c));
                binding.tvTitle.setText(context.getString(R.string.fire_tip_title_3));
                binding.tvDescription.setText(context.getString(R.string.fire_tip_description_3));
                binding.tvExtinguishers.setText(context.getString(R.string.fire_tip_extinguishers_3));
                break;
            case 3:
                binding.imgBanner.setImageDrawable(context.getDrawable(R.drawable.fire_class_d));
                binding.tvTitle.setText(context.getString(R.string.fire_tip_title_4));
                binding.tvDescription.setText(context.getString(R.string.fire_tip_description_4));
                binding.tvExtinguishers.setText(context.getString(R.string.fire_tip_extinguishers_4));
                break;
            case 4:
                binding.imgBanner.setImageDrawable(context.getDrawable(R.drawable.fire_class_e));
                binding.tvTitle.setText(context.getString(R.string.fire_tip_title_5));
                binding.tvDescription.setText(context.getString(R.string.fire_tip_description_5));
                binding.tvExtinguishers.setText(context.getString(R.string.fire_tip_extinguishers_5));
                break;
            case 5:
                binding.imgBanner.setImageDrawable(context.getDrawable(R.drawable.fire_class_f));
                binding.tvTitle.setText(context.getString(R.string.fire_tip_title_6));
                binding.tvDescription.setText(context.getString(R.string.fire_tip_description_6));
                binding.tvExtinguishers.setText(context.getString(R.string.fire_tip_extinguishers_6));
                break;
        }
    }
}