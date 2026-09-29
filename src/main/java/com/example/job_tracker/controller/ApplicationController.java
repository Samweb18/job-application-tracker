package com.example.job_tracker.controller;

import java.util.Map;
import java.util.HashMap;
import com.example.job_tracker.enums.ApplicationStatus;
import com.example.job_tracker.dto.ApplicationRequest;
import com.example.job_tracker.dto.ApplicationResponse;
import com.example.job_tracker.model.Application;
import com.example.job_tracker.service.ApplicationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;


    @GetMapping("/applications")
    public List<ApplicationResponse> getApplications() {

        List<Application> applications = applicationService.getAllApplications();

        return applications.stream().map(application -> new ApplicationResponse(
                application.getId(),
                application.getCompanyName(),
                application.getJobRole(),
                application.getApplicationDate(),
                application.getStatus(),
                application.getNotes()
        )).toList();
    }

    @PostMapping("/applications")
    public ApplicationResponse addApplication(@Valid @RequestBody ApplicationRequest request) {
        Application application = new Application();

        application.setCompanyName(request.getCompanyName());
        application.setJobRole(request.getJobRole());
        application.setApplicationDate(request.getApplicationDate());
        application.setStatus(request.getStatus());
        application.setNotes(request.getNotes());

        Application savedApplication = applicationService.addApplication(application);

        return new ApplicationResponse(
                savedApplication.getId(),
                savedApplication.getCompanyName(),
                savedApplication.getJobRole(),
                savedApplication.getApplicationDate(),
                savedApplication.getStatus(),
                savedApplication.getNotes()
        );
    }

    @GetMapping("/applications/{id}")
    public ResponseEntity<ApplicationResponse> getApplicationById(
            @PathVariable Long id) {

        Application application = applicationService.getApplicationById(id);

        if (application != null) {
            ApplicationResponse response = new ApplicationResponse(
                    application.getId(),
                    application.getCompanyName(),
                    application.getJobRole(),
                    application.getApplicationDate(),
                    application.getStatus(),
                    application.getNotes()
            );

            return ResponseEntity.ok(response);
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/applications/{id}")
    public ResponseEntity<ApplicationResponse> updateApplication(@PathVariable Long id,@Valid @RequestBody ApplicationRequest request) {

        Application updatedApplication = new Application();

        updatedApplication.setCompanyName(request.getCompanyName());
        updatedApplication.setJobRole(request.getJobRole());
        updatedApplication.setApplicationDate(request.getApplicationDate());
        updatedApplication.setStatus(request.getStatus());
        updatedApplication.setNotes(request.getNotes());

        Application application = applicationService.updateApplication(id,updatedApplication);

        if(application != null){
            ApplicationResponse response = new ApplicationResponse(
                    application.getId(),
                    application.getCompanyName(),
                    application.getJobRole(),
                    application.getApplicationDate(),
                    application.getStatus(),
                    application.getNotes()
            );
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/applications/{id}")
    public ResponseEntity<ApplicationResponse> deleteApplication(@PathVariable Long id) {

        Application application = applicationService.deleteApplication(id);
        if (application != null) {
           ApplicationResponse response = new ApplicationResponse(
                   application.getId(),
                   application.getCompanyName(),
                   application.getJobRole(),
                   application.getApplicationDate(),
                   application.getStatus(),
                   application.getNotes()
           );
           return ResponseEntity.ok(response);

        }
        return ResponseEntity.notFound().build();

    }
    @GetMapping("/applications/search")
    public List<ApplicationResponse> searchByCompanyName(
            @RequestParam String company) {

        List<Application> applications =
                applicationService.searchByCompanyName(company);

        return applications.stream()
                .map(application -> new ApplicationResponse(
                        application.getId(),
                        application.getCompanyName(),
                        application.getJobRole(),
                        application.getApplicationDate(),
                        application.getStatus(),
                        application.getNotes()
                ))
                .toList();
    }
    @GetMapping("/applications/statistics")
    public Map<String, Long> getStatistics() {
        Map<String, Long> statistics = new HashMap<>();

        for (ApplicationStatus status : ApplicationStatus.values()) {
            statistics.put(
                    status.name(),
                    applicationService.countByStatus(status)
            );
        }

        return statistics;
    }
}