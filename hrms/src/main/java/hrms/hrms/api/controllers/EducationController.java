package hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.businees.abstracts.EducationService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Education;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/education")
public class EducationController {
	
	private EducationService educationService;

	public EducationController(EducationService educationService) {
		super();
		this.educationService = educationService;
	}
	@GetMapping(value = "/getall")
	public DataResult<List<Education>> getAll(){
		return this.educationService.getAll();
	}
	@PostMapping(value="/add")
	public Result add(@RequestBody Education education) {
		return this.educationService.add(education);
		
	}
	@PostMapping(value = "/delete")
	public Result delete(@RequestBody Education education) {
		return this.educationService.delete(education);
	}
}
