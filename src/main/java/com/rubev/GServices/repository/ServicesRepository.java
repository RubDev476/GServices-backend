package com.rubev.GServices.repository;

import com.rubev.GServices.model.Service;
import com.rubev.GServices.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServicesRepository extends JpaRepository<Service, Long> {
    List<Service> findByCreatedBy(User user);
}
