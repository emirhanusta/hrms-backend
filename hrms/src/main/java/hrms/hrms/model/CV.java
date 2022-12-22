package hrms.hrms.model;

import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
@Setter
public class CV extends BaseEntity{

	private String coverLetter;

    @OneToOne
    @JoinColumn(name = "candidate_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Candidate candidate;

    @OneToMany(mappedBy = "cv",fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<Experience> experience;

    @OneToMany(mappedBy = "cv",fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<Education> education;

    @OneToMany(mappedBy = "cv",fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<Language> language;

    @OneToOne(mappedBy = "cv")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Image image;

    @OneToMany(mappedBy = "cv",fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<Skill> skill;

}
