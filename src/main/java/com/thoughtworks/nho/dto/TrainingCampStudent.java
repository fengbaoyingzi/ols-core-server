package com.thoughtworks.nho.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class TrainingCampStudent {
    String name;
    String email;
    String score;

    public TrainingCampStudent(String name, String email, String score) {
        this.name = name;
        this.email = email;
        this.score = score;
    }
}
