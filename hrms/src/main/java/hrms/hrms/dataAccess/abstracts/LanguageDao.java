package hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.model.Language;

public interface LanguageDao extends JpaRepository<Language, Integer>{

}
