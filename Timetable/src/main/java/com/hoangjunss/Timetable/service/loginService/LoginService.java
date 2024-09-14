package com.hoangjunss.Timetable.service.loginService;

import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    String login(String username,String password);
}
