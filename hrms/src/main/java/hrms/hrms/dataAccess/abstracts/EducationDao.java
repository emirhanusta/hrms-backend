package hrms.hrms.dataAccess.abstracts;
import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.Education;



public interface EducationDao extends JpaRepository<Education,Integer>{

}
