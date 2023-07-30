package com.example.springtestcontainer.service;

import com.example.springtestcontainer.entity.Reminder;
import com.example.springtestcontainer.repository.ReminderRepository;
import com.example.springtestcontainer.request.ReminderRequest;
import com.example.springtestcontainer.response.ReminderResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReminderService {

    private final ReminderRepository reminderRepository;

    public ReminderService(ReminderRepository reminderRepository) {
        this.reminderRepository = reminderRepository;
    }

    public ReminderResponse createReminder(ReminderRequest reminderRequest) {
        return buildResponse(reminderRepository.save(new Reminder(reminderRequest.getName())));
    }

    public ReminderResponse getReminder(Long id) {
        Reminder reminder = reminderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Found"));

        return buildResponse(reminder);
    }

    public ReminderResponse buildResponse(Reminder reminder) {
        return ReminderResponse.builder()
                .id(reminder.getId())
                .name(reminder.getName())
                .build();
    }

    public List<ReminderResponse> getAllReminders() {
        return reminderRepository.findAll()
                .stream()
                .map(this::buildResponse)
                .collect(Collectors.toList());
    }
}
