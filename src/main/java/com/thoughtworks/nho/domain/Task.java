package com.thoughtworks.nho.domain;

import com.thoughtworks.nho.util.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_task")
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Task {
    @Id
    private String id;

    @Column(unique = true)
    private String title;

    @Column
    private String trainingCampId;

    @Column
    private String desc;

    @Column
    private String StartDate;

    public Task() {
        id = StringUtils.uuid();
    }
}
