package com.Aravind.productservice.InheritanceExample.tableperclass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("tpc_user")
public interface UserRepository extends JpaRepository<User, Long> {
}
