package com.example.scholarship_app;

import android.support.annotation.Nullable;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class StuFragmentAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public StuFragmentAdapter(Context context, FragmentManager fm) {

        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new academicsFragment();
        } else if (position == 1) {
            return new OnlineFragment();
        } else  {
            return new InPersonFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Academics";
        } else if (position == 1) {
            return "Online";
        } else {
            return "In Person";
        }
    }

}
