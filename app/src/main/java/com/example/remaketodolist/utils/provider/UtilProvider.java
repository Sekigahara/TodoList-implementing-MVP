package com.example.remaketodolist.utils.provider;

import android.content.Context;

import com.example.remaketodolist.data.source.UserSessionRepository;

public class UtilProvider {
    private static UserSessionUtil userSessionUtil;

    public static void initUserSession(Context context){
        UserSessionRepository userSession = new UserSessionRepository(context);
        userSessionUtil = new UserSessionUtil(userSession);
    }

    public static UserSessionUtil getUserSessionUtil(){
        return userSessionUtil;
    }
}
