package com.example.job_tracker.service;
import com.example.job_tracker.enums.ApplicationStatus;
import com.example.job_tracker.model.Application;
import com.example.job_tracker.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    public Application addApplication(Application application) {
        return applicationRepository.save(application);
    }

    public Application getApplicationById(Long id) {
      return applicationRepository.findById(id).orElse(null);
    }
    public Application updateApplication(Long id, Application updateApplication){
        Application application = applicationRepository.findById(id).orElse(null);
            if(application.getId().equals(id)){
                application.setCompanyName(updateApplication.getCompanyName());
                application.setJobRole(updateApplication.getJobRole());
                application.setApplicationDate(updateApplication.getApplicationDate());
                application.setStatus(updateApplication.getStatus());
                application.setNotes(updateApplication.getNotes());

                return applicationRepository.save(application);
            }
        return null;

    }
    public Application deleteApplication(Long id){
Application application = applicationRepository.findById(id).orElse(null);

            if (application.getId().equals(id)) {
                applicationRepository.delete(application);
                return application;
            }
        return null;
    }
    public List<Application> searchByCompanyName(String companyName) {
        return applicationRepository.findByCompanyNameContainingIgnoreCase(companyName);
    }
    public long countByStatus(ApplicationStatus status) {
        return applicationRepository.countByStatus(status);
    }
}