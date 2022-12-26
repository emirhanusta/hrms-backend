package hrms.hrms.dto.request;

import lombok.Data;

@Data
public class UpdateEducationRequest {
    private Long id;
    private String schoolName;
    private String department;
    private String startDate;
    private String endDate;
}
