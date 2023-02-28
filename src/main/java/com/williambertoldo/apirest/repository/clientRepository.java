package com.williambertoldo.apirest.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.williambertoldo.apirest.entity.Client;

@Repository
public interface clientRepository extends JpaRepository <Client , Long>{
    Client findById(long id);

    @Query("SELECT p FROM Client p WHERE p.name LIKE %:name%")
    List<Client> findByNameLike(@Param("name") String name);
}
