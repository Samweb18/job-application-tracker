package com.example.job_tracker.dto;

import com.example.job_tracker.enums.ApplicationStatus;

import java.time.LocalDate;

public class ApplicationResponse {

    private Long id;
    private String companyName;
    private String jobRole;
    private LocalDate applicationDate;
    private ApplicationStatus status;
    private String notes;

    public ApplicationResponse(){

    }

    public ApplicationResponse(
            Long id, String companyName, String jobRole, LocalDate applicationDate, ApplicationStatus status, String notes
    ){
        this.id =id;
        this.companyName = companyName;
        this.jobRole = jobRole;
        this.applicationDate = applicationDate;
        this.status = status;
        this.notes = notes;
    }
    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
