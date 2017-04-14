package com.lwj.liweijian.criminalintent;

import java.util.UUID;

/**
 * Created by liweijian on 2017/4/14.
 */

public class Crime {
    private UUID mId;
    private String mTitle;

    public Crime() {
        mId = UUID.randomUUID();
    }

    public UUID getmId() {
        return mId;
    }


    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }
}
