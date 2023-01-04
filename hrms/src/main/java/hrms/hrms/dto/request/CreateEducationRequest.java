package hrms.hrms.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateEducationRequest {

        @NotBlank
        private String schoolName;
        @NotBlank
        private String department;
        @NotBlank
        private String startDate;

        private String endDate;

}
