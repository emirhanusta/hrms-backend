package hrms.hrms.controller;

import hrms.hrms.dto.CandidateDto;
import hrms.hrms.dto.CreateCandidateRequest;
import hrms.hrms.dto.UpdateCandidateRequest;
import hrms.hrms.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/candidate")
@RequiredArgsConstructor
public class CandidateController {

    private final CandidateService candidateService;

    @GetMapping
    ResponseEntity<List<CandidateDto>> getAllCandidates() {
        return ResponseEntity.ok(candidateService.getAllCandidates());
    }

    @GetMapping("/{id}")
    ResponseEntity<CandidateDto> getCandidateById(@PathVariable Long id) {
        return ResponseEntity.ok(candidateService.getById(id));
    }

    @PostMapping
    ResponseEntity<CandidateDto> createCandidate(@Valid @RequestBody CreateCandidateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(candidateService.createCandidate(request));
    }

    @PutMapping("/{id}")
    ResponseEntity<CandidateDto> updateCandidate(@PathVariable Long id, @Valid @RequestBody UpdateCandidateRequest request) {
        return ResponseEntity.ok(candidateService.updateCandidate(id, request));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteCandidate(@PathVariable Long id) {
        candidateService.deleteCandidate(id);
        return ResponseEntity.ok().build();
    }
}

