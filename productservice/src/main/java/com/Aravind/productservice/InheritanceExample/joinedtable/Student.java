package com.Aravind.productservice.InheritanceExample.joinedtable;

import com.Aravind.productservice.InheritanceExample.tableperclass.User;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_student")
public class Student extends User {
    private double psp;
    private String batch;

}
