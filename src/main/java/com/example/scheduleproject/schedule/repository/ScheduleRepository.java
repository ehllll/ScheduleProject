package com.example.scheduleproject.schedule.repository;

import com.example.scheduleproject.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    List<Schedule> findByWriterContainingAndModifiedAtBetweenOrderByModifiedAtDesc(
            String writer, LocalDateTime start, LocalDateTime end);

    List<Schedule> findByWriterContainingOrderByModifiedAtDesc(String writer);

    List<Schedule> findByModifiedAtBetweenOrderByModifiedAtDesc(LocalDateTime start, LocalDateTime end);
}
