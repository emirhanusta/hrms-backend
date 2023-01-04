package hrms.hrms.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateJobPositionRequest {
    @NotBlank
    private String title;
}
