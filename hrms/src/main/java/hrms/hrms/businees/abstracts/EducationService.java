package hrms.hrms.businees.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.model.Education;

public interface EducationService {

	Result add(Education education);
	Result delete(Education education);
	DataResult<List<Education>> getAll();
}
