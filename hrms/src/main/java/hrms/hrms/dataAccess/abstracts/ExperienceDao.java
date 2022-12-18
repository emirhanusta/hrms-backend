package hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.model.Experience;

public interface ExperienceDao extends JpaRepository<Experience, Integer>{

}
