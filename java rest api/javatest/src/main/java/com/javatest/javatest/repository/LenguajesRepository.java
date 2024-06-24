package com.javatest.javatest.repository;

import com.javatest.javatest.models.Lenguajes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LenguajesRepository extends CrudRepository<Lenguajes, Long>{
}
