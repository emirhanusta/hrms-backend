package hrms.hrms.businees.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.model.Employer;


public interface EmployerService {
	DataResult<List<Employer>> getAll();
	Result add(Employer employer);

}
