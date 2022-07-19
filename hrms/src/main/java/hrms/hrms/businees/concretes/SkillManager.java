package hrms.hrms.businees.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.businees.abstracts.SkillService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.dataAccess.abstracts.SkillDao;
import hrms.hrms.entities.concretes.Skill;

@Service
public class SkillManager implements SkillService{
	
	private SkillDao SkillDao;
	
	@Autowired
	public SkillManager(SkillDao SkillDao) {
		super();
		this.SkillDao = SkillDao;
	}

	@Override
	public Result add(Skill experience) {
		this.SkillDao.save(experience);
		return new SuccessDataResult("Education added");
	}

	@Override
	public Result delete(Skill experience) {
		this.SkillDao.delete(experience);
		return new SuccessDataResult("Experience deleted");
	}

	@Override
	public DataResult<List<Skill>> getAll() {
		return new SuccessDataResult<List<Skill>>(this.SkillDao.findAll(),"Data listed");
	}
}
