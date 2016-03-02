package com.sky31.gonggong.base;

import android.content.Context;
import android.content.res.Resources;
import android.widget.Toast;

import com.sky31.gonggong.R;

import java.util.HashMap;

/**
 * Created by root on 16-3-1.
 */
public class CommonFunction {
    private CommonFunction(){

    }
    private static final CommonFunction comminFunction = new CommonFunction();

    /**
     * -1	Wrong Hash
     * 0	OK
     * 1	Wrong Password
     * 2	Timeout
     * 3	Network Outage
     * 4	Unknown Error
     * 5	No Such Username
     * 6	Already Renew
     * 7	Bad Book ID
     * 65535	Missing Parameters
     */
    public static void errorToast(Context context, int code) {
        Resources resources = context.getResources();
        HashMap<String,String> errMsg = new HashMap<String,String>();
        errMsg.put("-1",resources.getString(R.string.err_msg__1));
        errMsg.put("1",resources.getString(R.string.err_msg_1));
        errMsg.put("2",resources.getString(R.string.err_msg_2));
        errMsg.put("3",resources.getString(R.string.err_msg_3));
        errMsg.put("4",resources.getString(R.string.err_msg_4));
        errMsg.put("5",resources.getString(R.string.err_msg_5));
        errMsg.put("6",resources.getString(R.string.err_msg_6));
        errMsg.put("7",resources.getString(R.string.err_msg_7));
        errMsg.put("65535",resources.getString(R.string.err_msg_65535));
        Toast.makeText(context, errMsg.get(code+""), Toast.LENGTH_SHORT).show();


    }
}