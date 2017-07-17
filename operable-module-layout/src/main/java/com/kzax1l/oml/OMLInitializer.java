package com.kzax1l.oml;

import android.support.annotation.NonNull;

import com.kzax1l.oml.dao.ChannelItem;
import com.kzax1l.oml.dao.ChannelManager;

import java.util.List;

/**
 * Created by Zsago on 2017/7/17.
 *
 * @author Zsago
 */
public class OMLInitializer {
    private static OMLInitialization sInitialization;

    public static void initialize(@NonNull OMLInitialization initialization) {
        sInitialization = initialization;
    }

    @NonNull
    public static OMLInitialization initialization() {
        return sInitialization;
    }

    public static ChannelManager manager() {
        return sInitialization.getChannelManage();
    }

    /**
     * 获取未添加的模块集
     */
    public static List<ChannelItem> unavailable() {
        return sInitialization.getChannelManage().getOtherChannel();
    }

    /**
     * 获取已添加的模块集
     */
    public static List<ChannelItem> available() {
        return sInitialization.getChannelManage().getUserChannel();
    }
}
