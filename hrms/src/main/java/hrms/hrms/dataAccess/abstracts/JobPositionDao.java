package hrms.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.JobPosition;
import hrms.hrms.entities.concretes.JobPosting;

public interface JobPositionDao extends JpaRepository<JobPosition,Integer>{

}
