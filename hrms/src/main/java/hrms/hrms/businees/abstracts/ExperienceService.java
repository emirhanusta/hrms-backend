package hrms.hrms.businees.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Experience;

public interface ExperienceService {
	Result add(Experience experience);
	Result delete(Experience experience);
	DataResult<List<Experience>> getAll();
}
