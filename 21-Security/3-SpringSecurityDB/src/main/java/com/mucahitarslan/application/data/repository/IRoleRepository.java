package com.mucahitarslan.application.data.repository;

import com.mucahitarslan.application.data.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role,Long> {
}
