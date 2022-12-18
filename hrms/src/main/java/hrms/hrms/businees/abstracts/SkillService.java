package hrms.hrms.businees.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.model.Skill;

public interface SkillService {
	Result add(Skill skill);
	Result delete(Skill skill);
	DataResult<List<Skill>> getAll();
}
