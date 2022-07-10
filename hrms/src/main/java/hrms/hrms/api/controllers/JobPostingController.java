package hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.businees.abstracts.JobPostingService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.JobPosting;
import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("/api/job_posting")
public class JobPostingController {
	
	private JobPostingService jobPostingService;

	@Autowired
	public JobPostingController(JobPostingService jobPostingService) {
		this.jobPostingService = jobPostingService;
	}
	
	@PostMapping(value="/add")
	public Result add(@RequestBody JobPosting jobPosting) {
		return this.jobPostingService.add(jobPosting);
		
	}
    @GetMapping("/getById")
    public DataResult<JobPosting> getById(@RequestParam int id){
        return jobPostingService.getById(id);
    }
    @GetMapping(value = "/getAllByIsActiveTrue")
    public DataResult<List<JobPosting>> getAllByIsActiveTrue(){ 
    	return this.jobPostingService.getAllByIsActiveTrue(); 
    	}
    
    @GetMapping(value="/getAllByIsActiveTrueAndEmployer")
    public DataResult<List<JobPosting>> getAllByIsActiveTrueAndEmployer(int employerId){
    	return this.jobPostingService.getAllByIsActiveTrueAndEmployer(employerId);
    }
    
    @GetMapping(value="/getAllByIsActiveTrueOrderByDeadlineDesc")
    public DataResult<List<JobPosting>> getAllByIsActiveTrueOrderByDeadlineDesc(){
    	return this.jobPostingService.getAllByIsActiveTrueOrderByDeadlineDesc();
    }
    
    @PostMapping("/changeToUnActive")
    public Result changeToUnActive( int id) {
        return this.jobPostingService.changeToUnActive(id);
    }
}
