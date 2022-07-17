package com.futura.test.Repository;


import com.futura.test.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByroleName(String roleName);

}
