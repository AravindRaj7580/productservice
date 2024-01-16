package com.Aravind.productservice.InheritanceExample.joinedtable;

import com.Aravind.productservice.InheritanceExample.tableperclass.User;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_mentor")
public class Mentor extends User {
    private double avg_rating;
}
