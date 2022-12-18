package hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.model.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition,Integer>{

}