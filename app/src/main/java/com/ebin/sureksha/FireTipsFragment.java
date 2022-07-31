package com.ebin.sureksha;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;

import com.ebin.sureksha.databinding.FragmentFireTipsBinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FireTipsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FireTipsFragment extends Fragment {

    public static final int NUMBER_OF_TABS = 6;

    private static final int BUTTON_STYLE_SKIP = 0;
    private static final int BUTTON_STYLE_GO = 1;
    private Context context;
    private FragmentFireTipsBinding binding;
    private int currentPosition;

    public FireTipsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FireTipsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FireTipsFragment newInstance(String param1, String param2) {
        FireTipsFragment fragment = new FireTipsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public static FireTipsFragment newInstance(){
        return newInstance("", "");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
        context = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_fire_tips, container, false);
        initValues();
        initViews();
        return binding.getRoot();
    }

    private void initValues(){
        currentPosition = 0;
    }

    private void initViews(){
        FireTipsPagerAdapter adapter = new FireTipsPagerAdapter(getChildFragmentManager(), NUMBER_OF_TABS);
        binding.viewPager.setAdapter(adapter);
        binding.viewPager.setOffscreenPageLimit(1);
        binding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentPosition = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        binding.scrollingIndicator.attachToPager(binding.viewPager);
    }
}