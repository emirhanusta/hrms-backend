package hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.JobPosting;

public interface JobPostingDao extends JpaRepository<JobPosting,Integer>{

}
