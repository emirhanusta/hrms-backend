package hrms.hrms.businees.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.businees.abstracts.JobPostingService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.ErrorResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.JobPostingDao;
import hrms.hrms.entities.concretes.JobPosting;

@Service
public class JobPostingManager implements JobPostingService{

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
    public DataResult<JobPosting> getById(int id) {
        return new SuccessDataResult<JobPosting>(this.jobPostingDao.findById(id),"Data listed");
    }
	@Override
	public DataResult<List<JobPosting>> getAllByIsActiveTrue() {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getAllByIsActiveTrue(), "All active job posting listed");
	}

	@Override
	public DataResult<List<JobPosting>> getAllByIsActiveTrueAndEmployer(int employerId) {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getAllByIsActiveTrueAndEmployer(employerId),"All active job posting of this employer are listed");
	}

	@Override
	public DataResult<List<JobPosting>> getAllByIsActiveTrueOrderByDeadlineDesc() {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getAllByIsActiveTrueOrderByDeadlineDesc(),"All active job posting listed order by application deadline descending");
	}

	@Override
    public Result changeToUnActive(int id) {
        if(getById(id)== null) {
            return new ErrorResult("Job posting not found ");
        }
        if (getById(id).getData().isActive()==false) {
            return new SuccessResult("job posting is already closed");
        }
        JobPosting jobPosting=getById(id).getData();
        jobPosting.setActive(false);
        this.jobPostingDao.save(jobPosting);
        return new SuccessResult("job posting closed");
    }

}
