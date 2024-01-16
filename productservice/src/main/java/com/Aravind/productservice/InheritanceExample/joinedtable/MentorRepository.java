package com.Aravind.productservice.InheritanceExample.joinedtable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("jt_Mentor")
public interface MentorRepository extends JpaRepository<Mentor, Long> {

}
