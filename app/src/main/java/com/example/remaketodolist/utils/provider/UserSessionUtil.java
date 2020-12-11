package com.example.remaketodolist.utils.provider;

import com.example.remaketodolist.data.model.User;
import com.example.remaketodolist.data.source.UserSessionRepository;

public class UserSessionUtil {
    private UserSessionRepository userSessionRepository;

    public UserSessionUtil(UserSessionRepository userSessionRepository){
        this.userSessionRepository = userSessionRepository;
    }

    public void setSession(User user){
        userSessionRepository.setSessionData(user);
    }

    public User getSession(){
        return userSessionRepository.getSessionData();
    }

    public void updateSession(User user){
        userSessionRepository.update(user);
    }

    public void logout(){
        userSessionRepository.destroy();
    }
}
