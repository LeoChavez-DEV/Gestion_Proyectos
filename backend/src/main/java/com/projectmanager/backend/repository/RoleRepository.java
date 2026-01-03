package com.projectmanager.backend.repository;
import com.projectmanager.backend.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
//   findByName(String name); igual a --> SELECT * FROM roles WHERE name = ?
    Optional<Role> findByName(String name);
}
