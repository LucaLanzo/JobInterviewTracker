package com.lucalanzo.api;

import com.lucalanzo.data.resource.JobInterview;
import com.lucalanzo.service.JobInterviewService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/interviews")
@AllArgsConstructor
public class JobInterviewController {
    private final JobInterviewService jobInterviewService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<JobInterview> getAll() {
        return null;
    }
}
