package com.lucalanzo.data.repository;

import com.lucalanzo.data.resource.ApplicationStatus;
import com.lucalanzo.data.resource.JobInterview;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public abstract class JobInterviewRepository implements MongoRepository<JobInterview, String> {
    public abstract List<JobInterview> findByStatus(ApplicationStatus status);

    public abstract List<JobInterview> findByPosition(String position);
}
