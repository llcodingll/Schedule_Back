package com.lloll.myro.domain.schedule.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor

public class ScheduleController {
    private final ScheduleService service;
}
