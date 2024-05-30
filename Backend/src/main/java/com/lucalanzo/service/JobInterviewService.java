package com.lucalanzo.service;

import com.lucalanzo.data.repository.JobInterviewRepository;
import com.lucalanzo.data.resource.JobInterview;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class JobInterviewService {
    private final JobInterviewRepository repository;

    public List<JobInterview> getAllJobInterviews() {
        return repository.findAll();
    }

    public Optional<JobInterview> getJobInterview(String id) {
        return repository.findById(id);
    }

    public JobInterview createJobInterview(JobInterview jobInterview) {
        return repository.insert(jobInterview);
    }

    public boolean changeJobInterview(String id, JobInterview jobInterview) {
        if (!repository.existsById(id)) return false;

        jobInterview.setId(id);
        repository.save(jobInterview);

        return true;
    }

    public boolean deleteJobInterview(String id) {
        if (!repository.existsById(id)) return false;

        repository.deleteById(id);

        return true;
    }

}
