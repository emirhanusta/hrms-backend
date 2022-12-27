package hrms.hrms.controller;

import hrms.hrms.dto.request.CreateJobRequest;
import hrms.hrms.dto.request.UpdateJobRequest;
import hrms.hrms.dto.response.JobDto;
import hrms.hrms.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/job")
@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;

    @GetMapping
    public ResponseEntity<List<JobDto>> getAllJobs() {
        return ResponseEntity.ok(jobService.getAllJobs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobDto> getJobById(@PathVariable Long id) {
        return ResponseEntity.ok(jobService.getJobById(id));
    }

    @GetMapping("/active")
    public ResponseEntity<List<JobDto>> getActiveJobs() {
        return ResponseEntity.ok(jobService.getActiveJobs());
    }

    @PostMapping
    public ResponseEntity<JobDto> createJob(@RequestBody CreateJobRequest createJobRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(jobService.createJob(createJobRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobDto> updateJob(@PathVariable Long id, @RequestBody UpdateJobRequest updateJobRequest) {
        return ResponseEntity.ok(jobService.updateJob(id, updateJobRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
        return ResponseEntity.ok().build();
    }
}
