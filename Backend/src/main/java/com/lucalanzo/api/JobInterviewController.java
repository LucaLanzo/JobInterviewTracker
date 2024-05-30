package com.lucalanzo.api;

import com.lucalanzo.data.resource.JobInterview;
import com.lucalanzo.service.JobInterviewService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/interviews")
@AllArgsConstructor
public class JobInterviewController {
    private final JobInterviewService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<JobInterview> getAll() {
        var jobInterviews = service.getAllJobInterviews();

        if (jobInterviews.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return jobInterviews;
    }


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public JobInterview getSingle(@PathVariable String id) {
        var jobInterview = service.getJobInterview(id);

        if (jobInterview.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return jobInterview.get();
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JobInterview> create(@RequestBody @Valid JobInterview jobInterview) {
        var createdJobInterview = service.createJobInterview(jobInterview);

        if (createdJobInterview == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdJobInterview);
    }


    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void put(@PathVariable String id, @RequestBody JobInterview jobInterview) {
        var changed = service.changeJobInterview(id, jobInterview);

        if (!changed) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }


    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable String id) {
        var deleted = service.deleteJobInterview(id);

        if (!deleted) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
}
