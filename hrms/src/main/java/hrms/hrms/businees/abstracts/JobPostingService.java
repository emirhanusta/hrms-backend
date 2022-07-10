package hrms.hrms.businees.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.JobPosting;

public interface JobPostingService {
	Result add(JobPosting jobPosting);
    DataResult<JobPosting>getById(int id);

	DataResult<List<JobPosting>> getAllByIsActiveTrue();
	DataResult<List<JobPosting>> getAllByIsActiveTrueAndEmployer(int employerId);
	DataResult<List<JobPosting>> getAllByIsActiveTrueOrderByDeadlineDesc();

    Result changeToUnActive(int id);

}
