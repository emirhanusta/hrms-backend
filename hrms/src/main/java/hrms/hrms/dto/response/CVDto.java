package hrms.hrms.dto.response;

import hrms.hrms.model.*;
import lombok.Data;

import java.util.List;

@Data
public class CVDto {

    private Long id;

    private String coverLetter;

    private Long candidateId;

    private List<Experience> experience;

    private List<Education> education;

    private List<Language> language;

    private Image image;

    private List<Skill> skill;
}
