package hrms.hrms.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class CreateCVRequest {

    @NotNull
    private Long candidateId;

    @NotBlank
    private String coverLetter;

    @NotNull
    private List<CreateExperienceRequest> experience;

    @NotNull
    private List<CreateEducationRequest> education;

    @NotNull
    private List<CreateLanguageRequest> language;

    private CreateImageRequest image;

    @NotNull
    private List<CreateSkillRequest> skill;

}
