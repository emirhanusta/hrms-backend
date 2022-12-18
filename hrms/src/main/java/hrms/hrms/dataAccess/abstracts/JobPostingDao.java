package hrms.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.model.JobPosting;

public interface JobPostingDao extends JpaRepository<JobPosting,Integer>{
	JobPosting findById(int id);

	List<JobPosting> getAllByIsActiveTrue();
	List<JobPosting> getAllByIsActiveTrueAndEmployer(int employerId);
	List<JobPosting> getAllByIsActiveTrueOrderByDeadlineDesc();
}
