package hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.model.Employer;

public interface EmployerDao extends JpaRepository<Employer,Integer>{
	boolean existsByEmail(String email);
}
