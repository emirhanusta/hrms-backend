package hrms.hrms.businees.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.businees.abstracts.JobPostingService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.dataAccess.abstracts.JobPostingDao;
import hrms.hrms.entities.concretes.JobPosting;

@Service
public class JobPostingManager implements JobPostingService{
	public @interface EnableFeignClients {

	}

	private JobPostingDao jobPostingDao;
	
	@Autowired
	public JobPostingManager(JobPostingDao jobPostingDao) {
		this.jobPostingDao = jobPostingDao;
	}
	@Override
	public Result add(JobPosting jobPosting) {
		this.jobPostingDao.save(jobPosting);
		return new SuccessDataResult("Job posting added");
	}

	@Override
	public DataResult<List<JobPosting>> getAllByIsActiveTrue() {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getAllByIsActiveTrue(), "All active job advertisements listed");
	}

	@Override
	public DataResult<List<JobPosting>> getAllByIsActiveTrueAndEmployer(int employerId) {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getAllByIsActiveTrueAndEmployer(employerId),"All active job advertisements of this employer are listed");
	}

	@Override
	public DataResult<List<JobPosting>> getAllByIsActiveTrueOrderByDeadlineDesc() {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getAllByIsActiveTrueOrderByDeadlineDesc(),"All active job advertisements listed order by application deadline descending");
	}

	@Override
	public Result setDeactivateJobAdvertisement(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result setActivateJobAdvertisement(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
