package hrms.hrms.dto.request;

import lombok.Data;

@Data
public class CreateExperienceRequest {

        private String companyName;

        private String position;

        private String startDate;

        private String endDate;

        private String description;

}
