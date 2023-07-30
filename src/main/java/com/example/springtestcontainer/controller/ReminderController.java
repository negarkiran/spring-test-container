package com.example.springtestcontainer.controller;


import com.example.springtestcontainer.request.ReminderRequest;
import com.example.springtestcontainer.response.ReminderResponse;
import com.example.springtestcontainer.service.ReminderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/reminders")
@RestController
public class ReminderController {

    private final ReminderService reminderService;

    public ReminderController(ReminderService reminderService) {
        this.reminderService = reminderService;
    }

    @GetMapping
    public List<ReminderResponse> getReminders() {
        return reminderService.getAllReminders();
    }

    @GetMapping("/{id}")
    public ReminderResponse getReminder(@PathVariable("id") Long id) {
        return reminderService.getReminder(id);
    }

    @PostMapping
    public ReminderResponse createReminder(@RequestBody ReminderRequest reminderRequest) {
        return reminderService.createReminder(reminderRequest);
    }
}
