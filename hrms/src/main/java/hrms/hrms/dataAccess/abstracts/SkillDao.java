package hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.Skill;

public interface SkillDao extends JpaRepository<Skill,Integer>{

}
