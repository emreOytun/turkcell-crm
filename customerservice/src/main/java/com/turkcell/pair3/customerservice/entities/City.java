package com.turkcell.pair3.customerservice.entities;

import com.turkcell.pair3.customerservice.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cities")
public class City extends BaseEntity<Integer> {

    @Column(name = "city_name", nullable = false)
    private String cityName;
}
