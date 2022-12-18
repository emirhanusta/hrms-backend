package hrms.hrms.dataAccess.abstracts;



import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.model.City;

public interface CityDao extends JpaRepository<City,Integer>{

}
