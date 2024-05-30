package com.lucalanzo.repository;

import com.lucalanzo.resource.JobInterview;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface JobInterviewRepository extends MongoRepository<JobInterview, String> {
    // List<JobInterview> findByStatus(ApplicationStatus status);

    List<JobInterview> findByPosition(String position);
}
