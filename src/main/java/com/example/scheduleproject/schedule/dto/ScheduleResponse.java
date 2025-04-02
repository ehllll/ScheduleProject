package com.example.scheduleproject.schedule.dto;

import java.time.LocalDateTime;

public class ScheduleResponse {
    Long id;
    String content;
    String writer;
    LocalDateTime createdQAt;
    LocalDateTime modifiedAt;
}
