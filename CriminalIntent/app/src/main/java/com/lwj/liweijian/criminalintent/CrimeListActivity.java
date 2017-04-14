package com.lwj.liweijian.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by liweijian on 2017/4/14.
 */

public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
