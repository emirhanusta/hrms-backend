package hrms.hrms.controller;

import hrms.hrms.dto.request.CreateEmployerRequest;
import hrms.hrms.dto.response.EmployerDto;
import hrms.hrms.dto.request.UpdateEmployerRequest;
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
    ResponseEntity<EmployerDto> createEmployer(@Valid @RequestBody CreateEmployerRequest createEmployerRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employerService.createEmployer(createEmployerRequest));
    }
    @GetMapping("/{id}")
    ResponseEntity<EmployerDto> getEmployerById(@PathVariable Long id) {
        return ResponseEntity.ok(employerService.getEmployerById(id));
    }

    @GetMapping
    ResponseEntity<List<EmployerDto>> getAllEmployers() {
        return ResponseEntity.ok(employerService.getAllEmployers());
    }
    @PutMapping("/{id}")
    ResponseEntity<EmployerDto> updateEmployer(@PathVariable Long id,
                                               @Valid @RequestBody UpdateEmployerRequest updateEmployerRequest) {
        return ResponseEntity.ok(employerService.updateEmployer(id, updateEmployerRequest));
    }
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteEmployer(@PathVariable Long id) {
        employerService.deleteEmployer(id);
        return ResponseEntity.ok().build();
    }
}
