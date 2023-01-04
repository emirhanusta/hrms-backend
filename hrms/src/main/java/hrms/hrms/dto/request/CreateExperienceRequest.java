package hrms.hrms.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateExperienceRequest {

        @NotBlank
        private String companyName;
        @NotBlank
        private String position;
        @NotBlank
        private String startDate;

        private String endDate;

        private String description;

}
