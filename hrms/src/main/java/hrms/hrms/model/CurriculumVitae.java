package hrms.hrms.model;

import java.util.List;
import javax.persistence.*;

import lombok.*;

@Getter
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
@Setter
public class CurriculumVitae extends BaseEntity{

	private String coverLetter;

    @OneToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

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
