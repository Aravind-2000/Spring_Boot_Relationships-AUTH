package com.futura.test.Repository;

import com.futura.test.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {


    @Query(value = "select * from address where is_active = true", nativeQuery = true)
    List<Address> getAllValidAddress();

}
