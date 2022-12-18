package hrms.hrms.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CurriculumVitae {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long id;
	
	private String coverLetter;
    
    @OneToMany(mappedBy = "curriculumVitae")
    private List<Experience> experience;
    
    @OneToMany(mappedBy = "curriculumVitae")
    private List<Education> education;
    
    @OneToMany(mappedBy = "curriculumVitae")
    private List<Language> language;
    
    @OneToOne(mappedBy = "curriculumVitae")
    private Image image;
    
    @OneToMany(mappedBy = "curriculumVitae")
    private List<Skill> skill;
}
