package com.example.springtestcontainer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reminders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Reminder {

    @Id
    @GeneratedValue(generator = "reminders_id_seq")
    private Long id;

    @Column
    private String name;

    public Reminder(String name) {
        this.name = name;
    }
}
