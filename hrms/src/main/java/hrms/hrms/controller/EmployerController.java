package hrms.hrms.controller;

import hrms.hrms.dto.EmployerCreateRequest;
import hrms.hrms.dto.EmployerDto;
import hrms.hrms.dto.EmployerUpdateRequest;
import hrms.hrms.service.EmployerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/employer")
@RequiredArgsConstructor
public class EmployerController {

    private final EmployerService employerService;

    @PostMapping
    ResponseEntity<EmployerDto> createEmployer(@Valid @RequestBody EmployerCreateRequest employerCreateRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employerService.createEmployer(employerCreateRequest));
    }
    @GetMapping("/{id}")
    ResponseEntity<EmployerDto> getEmployer(@PathVariable Long id) {
        return ResponseEntity.ok(employerService.getEmployer(id));
    }

    @GetMapping
    ResponseEntity<List<EmployerDto>> getAllEmployers() {
        return ResponseEntity.ok(employerService.getAllEmployers());
    }
    @PutMapping("/{id}")
    ResponseEntity<EmployerDto> updateEmployer(@PathVariable Long id,
                                               @Valid @RequestBody EmployerUpdateRequest employerUpdateRequest) {
        return ResponseEntity.ok(employerService.updateEmployer(id, employerUpdateRequest));
    }
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteEmployer(@PathVariable Long id) {
        employerService.deleteEmployer(id);
        return ResponseEntity.ok().build();
    }
}
