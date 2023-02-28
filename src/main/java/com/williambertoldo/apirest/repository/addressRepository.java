package com.williambertoldo.apirest.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.williambertoldo.apirest.entity.Address;

public interface addressRepository extends JpaRepository <Address , Long>{
    List<Address> findByClientId(long clientId);
    
    Address findById(long id);
}
