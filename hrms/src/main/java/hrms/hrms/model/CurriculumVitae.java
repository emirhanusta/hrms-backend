package hrms.hrms.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
public class CurriculumVitae extends BaseEntity{

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
