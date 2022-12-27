package hrms.hrms.controller;

import hrms.hrms.dto.request.CreateJobPositionRequest;
import hrms.hrms.dto.request.UpdateJobPositionRequest;
import hrms.hrms.dto.response.JobPositionDto;
import hrms.hrms.service.JobPositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/job-position")
@RequiredArgsConstructor
public class JobPositionController {

    private final JobPositionService jobPositionService;

    @GetMapping
    public ResponseEntity<List<JobPositionDto>> getAllJobPositions() {
        return ResponseEntity.ok(jobPositionService.getAllJobPositions());
    }

    @GetMapping("{id}")
    public ResponseEntity<JobPositionDto> getJobPositionById(@PathVariable Long id) {
        return ResponseEntity.ok(jobPositionService.getJobPositionById(id));
    }

    @PostMapping
    public ResponseEntity<JobPositionDto> createJobPosition(CreateJobPositionRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(jobPositionService.createJobPosition(request));
    }

    @PutMapping("{id}")
    public ResponseEntity<JobPositionDto> updateJobPosition(@PathVariable Long id, UpdateJobPositionRequest request) {
        return ResponseEntity.ok(jobPositionService.updateJobPosition(id, request));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteJobPosition(@PathVariable Long id) {
        jobPositionService.deleteJobPosition(id);
        return ResponseEntity.ok().build();
    }
}
