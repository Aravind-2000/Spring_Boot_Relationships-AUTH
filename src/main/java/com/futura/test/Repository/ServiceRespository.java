package com.futura.test.Repository;


import com.futura.test.Entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRespository extends JpaRepository<Service, Long> {
}
