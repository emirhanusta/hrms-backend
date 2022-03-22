package hrms.hrms.businees.abstracts;

import java.util.List;

import hrms.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	
	List<JobPosition> getAll();
}
