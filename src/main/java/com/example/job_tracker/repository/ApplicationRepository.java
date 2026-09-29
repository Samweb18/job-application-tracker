package com.example.job_tracker.repository;
import com.example.job_tracker.enums.ApplicationStatus;
import com.example.job_tracker.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

    List<Application> findByCompanyNameContainingIgnoreCase(String companyName);
    long countByStatus(ApplicationStatus status);
}
