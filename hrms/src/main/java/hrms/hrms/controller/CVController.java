package hrms.hrms.controller;

import hrms.hrms.dto.request.CreateCVRequest;
import hrms.hrms.dto.response.CVDto;
import hrms.hrms.model.CV;
import hrms.hrms.service.CVService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/cv")
@RequiredArgsConstructor
public class CVController {

    private final CVService cvService;

    @PostMapping
    public ResponseEntity<CVDto> createCV(@Valid @RequestBody CreateCVRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cvService.createCV(request));
    }
    @GetMapping
    public ResponseEntity<List<CVDto>> getAllCVs(){
        return ResponseEntity.ok(cvService.getAllCVs());
    }
    @GetMapping("/{id}")
    public ResponseEntity<CVDto> getCVById(@PathVariable Long id){
        return ResponseEntity.ok(cvService.getCVById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCV(@PathVariable Long id){
        cvService.deleteCV(id);
        return ResponseEntity.ok().build();
    }
}
