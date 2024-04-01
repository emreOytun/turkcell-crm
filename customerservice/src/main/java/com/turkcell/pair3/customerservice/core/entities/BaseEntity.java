package com.turkcell.pair3.customerservice.core.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Column(name="created_date")
    private LocalDateTime createdDate;
    @Column(name="updated_date")
    private LocalDateTime updatedDate;
    @Column(name="deleted_date")
    private LocalDateTime deletedDate;
}
