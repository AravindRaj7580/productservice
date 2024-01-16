package com.Aravind.productservice.InheritanceExample.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_TA")
@DiscriminatorValue(value = "3")
public class TA extends User {
    private String startTime;
    private String endTime;
}
