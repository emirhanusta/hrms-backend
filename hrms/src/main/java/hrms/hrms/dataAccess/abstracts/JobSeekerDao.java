package hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;


import hrms.hrms.model.JobSeeker;

public interface JobSeekerDao extends JpaRepository<JobSeeker,Integer>{
	boolean existsByEmail(String email);

}
