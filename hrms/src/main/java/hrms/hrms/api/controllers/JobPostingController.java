package hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.businees.abstracts.JobPostingService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.entities.concretes.JobPosting;
@CrossOrigin

@RestController
@RequestMapping("/api/job_posting")
public class JobPostingController {
	
	private JobPostingService jobPostingService;

	@Autowired
	public JobPostingController(JobPostingService jobPostingService) {
		this.jobPostingService = jobPostingService;
	}
	

    @GetMapping(value = "/getAllByIsActiveTrue")
    public DataResult<List<JobPosting>> getAll(){ 
    	return this.jobPostingService.getAllByIsActiveTrue(); 
    	}
}
