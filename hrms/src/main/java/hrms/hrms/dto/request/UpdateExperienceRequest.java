package hrms.hrms.dto.request;

import lombok.Data;

@Data
public class UpdateExperienceRequest {

    private Long id;
    private String companyName;
    private String position;
    private String startDate;
    private String endDate;
    private String description;
}
