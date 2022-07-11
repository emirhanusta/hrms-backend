package hrms.hrms.businees.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.City;

public interface CityService {
	Result add(City city);

	DataResult<List<City>> getAll();
}
