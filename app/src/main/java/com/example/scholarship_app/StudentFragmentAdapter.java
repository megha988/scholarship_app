package com.example.scholarship_app;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class StudentFragmentAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public StudentFragmentAdapter(Context context, FragmentManager fm) {

        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new ProfileFragment();
        } else if (position == 1) {
            return new ProgramFragment();
        } else  {
            return new AcademicFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Profile";
        } else if (position == 1) {
            return "Programs";
        } else {
            return "Academics";
        }
    }

}
