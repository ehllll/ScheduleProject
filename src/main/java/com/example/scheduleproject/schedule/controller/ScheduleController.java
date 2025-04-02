package com.example.scheduleproject.schedule.controller;

import com.example.scheduleproject.schedule.entity.Schedule;
import com.example.scheduleproject.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public Schedule createSchedule(@RequestBody Schedule schedule) {
        return scheduleService.createSchedule(schedule);
    }

    @GetMapping
    public List<Schedule> getSchedules(
            @RequestParam(required = false) String writer,
            @RequestParam(required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate modifiedDate
    ) {
        return scheduleService.getSchedules(writer, modifiedDate);
    }

    @GetMapping("/{id}")
    public Schedule getScheduleById(@PathVariable Long id) {
        return scheduleService.getScheduleById(id)
                .orElseThrow(() -> new RuntimeException("해당 ID의 일정이 없습니다."));
    }
}
