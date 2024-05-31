package com.fullsecurity.fullsecurity.repository;

import com.fullsecurity.fullsecurity.models.enumeration.ERole;
import com.fullsecurity.fullsecurity.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole role);
}
