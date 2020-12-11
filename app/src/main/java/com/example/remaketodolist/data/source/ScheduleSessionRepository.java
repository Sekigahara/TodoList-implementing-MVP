package com.example.remaketodolist.data.source;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.remaketodolist.data.model.Schedule;
import com.google.gson.Gson;


public class ScheduleSessionRepository implements SessionRepository<Schedule> {
    private static String SESSION_USER = "SessionSchedule";
    private SharedPreferences sharedPref;

    public ScheduleSessionRepository(Context context) {
        sharedPref = context.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public Schedule initialize(Schedule sessionData) {
        //save to shared preference
        setSessionData(sessionData);

        //load from shared preference
        return getSessionData();
    }

    @Override
    public Schedule getSessionData() {
        String sessionDataJson = sharedPref.getString(SESSION_USER, null);
        if (sessionDataJson != null) {
            return new Gson().fromJson(sessionDataJson, Schedule.class);
        }
        return null;
    }

    @Override
    public void setSessionData(Schedule sessionData) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(SESSION_USER, new Gson().toJson(sessionData));
        editor.apply();
    }

    @Override
    public void destroy() {
        sharedPref.edit().clear().apply();
    }

    @Override
    public void update(Schedule sessionData) {
        destroy();
        setSessionData(sessionData);
    }
}
