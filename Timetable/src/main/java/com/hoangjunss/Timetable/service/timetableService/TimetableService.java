package com.hoangjunss.Timetable.service.timetableService;

import org.springframework.stereotype.Service;

@Service
public interface TimetableService {
    String getTimetable(String username,String password);
}
