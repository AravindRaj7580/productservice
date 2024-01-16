package com.Aravind.productservice.InheritanceExample.joinedtable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("jt_Student")
public interface StudentRepository extends JpaRepository<Student, Long> {
}
