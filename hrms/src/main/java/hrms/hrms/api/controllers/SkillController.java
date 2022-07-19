package hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.businees.abstracts.ExperienceService;
import hrms.hrms.businees.abstracts.SkillService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Skill;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("api/skill")
public class SkillController {
	
	private SkillService skillService;

	public SkillController(SkillService skillService) {
		super();
		this.skillService = skillService;
	}
	@GetMapping(value = "/getall")
	public DataResult<List<Skill>> getAll(){
		return this.skillService.getAll();
	}
	@PostMapping(value="/add")
	public Result add(@RequestBody Skill skill) {
		return this.skillService.add(skill);
		
	}
	@PostMapping(value = "/delete")
	public Result delete(@RequestBody Skill skill) {
		return this.skillService.delete(skill);
	}
}
