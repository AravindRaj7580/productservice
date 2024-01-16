package com.Aravind.productservice.InheritanceExample.joinedtable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_TA")
@DiscriminatorValue(value = "3")
public class TA extends User {
    private String startTime;
    private String endTime;
}
