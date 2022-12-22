package hrms.hrms.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class CreateCVRequest {

    private Long candidateId;

    private String coverLetter;

    private List<CreateExperienceRequest> experience;

    private List<CreateEducationRequest> education;

    private List<CreateLanguageRequest> language;

    private CreateImageRequest image;

    private List<CreateSkillRequest> skill;

}
