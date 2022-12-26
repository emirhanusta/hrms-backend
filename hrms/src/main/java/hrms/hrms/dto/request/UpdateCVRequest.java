package hrms.hrms.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class UpdateCVRequest {
    
    private String coverLetter;

    private List<UpdateExperienceRequest> experience;

    private List<UpdateEducationRequest> education;

    private List<UpdateLanguageRequest> language;

    private UpdateImageRequest image;

    private List<UpdateSkillRequest> skill;
}
