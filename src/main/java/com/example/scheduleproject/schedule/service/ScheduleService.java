package com.example.scheduleproject.schedule.service;


import com.example.scheduleproject.schedule.entity.Schedule;
import com.example.scheduleproject.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public Schedule createSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public List<Schedule> getSchedules(String writer, LocalDate modifiedDate) {
        if (writer != null && modifiedDate != null) {
            LocalDateTime start = modifiedDate.atStartOfDay();
            LocalDateTime end = modifiedDate.atTime(LocalTime.MAX);
            return scheduleRepository.findByWriterContainingAndModifiedAtBetweenOrderByModifiedAtDesc(writer, start, end);
        } else if (writer != null) {
            return scheduleRepository.findByWriterContainingOrderByModifiedAtDesc(writer);
        } else if (modifiedDate != null) {
            LocalDateTime start = modifiedDate.atStartOfDay();
            LocalDateTime end = modifiedDate.atTime(LocalTime.MAX);
            return scheduleRepository.findByModifiedAtBetweenOrderByModifiedAtDesc(start, end);
        } else {
            return scheduleRepository.findAll().stream()
                    .sorted((a, b) -> b.getModifiedAt().compareTo(a.getModifiedAt()))
                    .toList();
        }
    }

    public Optional<Schedule> getScheduleById(Long id) {
        return scheduleRepository.findById(id);
    }
}
