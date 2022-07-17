package hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.businees.abstracts.ExperienceService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Experience;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/experience")
public class ExperienceController {

	private ExperienceService experienceService;

	public ExperienceController(ExperienceService experienceService) {
		super();
		this.experienceService = experienceService;
	}
	@GetMapping(value = "/getall")
	public DataResult<List<Experience>> getAll(){
		return this.experienceService.getAll();
	}
	@PostMapping(value="/add")
	public Result add(@RequestBody Experience experience) {
		return this.experienceService.add(experience);
		
	}
	@PostMapping(value = "/delete")
	public Result delete(@RequestBody Experience experience) {
		return this.experienceService.delete(experience);
	}
}
