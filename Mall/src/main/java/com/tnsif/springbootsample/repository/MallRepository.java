package com.tnsif.springbootsample.repository;



import com.tnsif.springbootsample.entity.Mall;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MallRepository extends JpaRepository<Mall, Long> {
}
