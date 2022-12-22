package hrms.hrms.dto.response;

import lombok.Data;

@Data
public class ExperienceDto {

    private Long id;

    private String companyName;

    private String position;

    private String startDate;

    private String endDate;

    private String description;
}
