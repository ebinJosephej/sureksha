package com.ebin.sureksha.helpers;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.ebin.sureksha.R;


public class FragmentHelper {

    private Activity activity;

    //Public Constructor
    public FragmentHelper(Activity activity) {
        this.activity = activity;
    }

    //Getters
    public Activity getActivity() {
        return this.activity;
    }

    //Setters
    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void initFragment(Fragment fragment, FragmentManager fragmentManager, String tag, boolean addToBackStack) {
        if (addToBackStack) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.content, fragment, tag).addToBackStack(null);
            fragmentTransaction.commit();
        } else {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.content, fragment, tag);
            fragmentTransaction.commit();
        }
    }

    public void initFragment(Fragment fragment, FragmentManager fragmentManager, String tag) {
        initFragment(fragment, fragmentManager, tag, true);
    }

    public void initFragment(Fragment fragment, FragmentManager fragmentManager) {
        initFragment(fragment, fragmentManager, "");
    }

    public void initFragment(DialogFragment fragment, FragmentManager fragmentManager) {
        initFragment(fragment, fragmentManager, "");
    }

    public void initFragment(DialogFragment fragment, FragmentManager fragmentManager, String tag) {
        fragment.show(fragmentManager, tag);
    }

    /**
     * Replaces the current fragment with the new fragment,
     * and add the current fragment to backStack
     *
     * @param fragment        - Fragment to be added.
     * @param fragmentManager - FragmentManager of the current activity.
     * @param tag             - Tag to be given to the fragment
     * @param addToBackStack  - If true adds the fragment to backStack else the fragment won't be
     *                        added to backStack.
     */
    public static void startFragment(Fragment fragment, FragmentManager fragmentManager, String tag, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction = fragmentTransaction.replace(R.id.content, fragment, tag);
        if (addToBackStack) {
            fragmentTransaction = fragmentTransaction.addToBackStack(fragment.toString());
        }
        fragmentTransaction.commit();
    }

    /**
     * Replaces the current fragment with the new fragment,
     * and add the current fragment to backStack
     *
     * @param fragment        - Fragment to be added.
     * @param fragmentManager - FragmentManager of the current activity.
     * @param tag             - Tag to be given to the fragment
     */
    public static void startFragment(Fragment fragment, FragmentManager fragmentManager, String tag) {
        startFragment(fragment, fragmentManager, tag, true);
    }

    /**
     * Replaces the current fragment with the new fragment,
     * and add the current fragment to backStack
     *
     * @param fragment        - Fragment to be added.
     * @param fragmentManager - FragmentManager of the current activity.
     */
    public static void startFragment(Fragment fragment, FragmentManager fragmentManager) {
        startFragment(fragment, fragmentManager, "");
    }

    /***
     * popup window bg dimmer
     */
    public static void dimBehind(PopupWindow popupWindow) {
        View container = popupWindow.getContentView().getRootView();
        Context context = popupWindow.getContentView().getContext();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        WindowManager.LayoutParams p = (WindowManager.LayoutParams) container.getLayoutParams();
        p.flags |= WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        p.dimAmount = 0.5f;
        wm.updateViewLayout(container, p);
    }
}
