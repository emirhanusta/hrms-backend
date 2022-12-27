package hrms.hrms.dto.response;

import hrms.hrms.model.City;
import hrms.hrms.model.JobType;
import hrms.hrms.model.WorkplaceType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JobDto {

    private Long id;

    private Long employerId;

    private String description;

    private String deadline;

    private Double maxSalary;

    private Double minSalary;

    private Boolean isActive;

    private City city;

    private JobType jobType;

    private WorkplaceType workplaceType;

    private Long jobPositionId;
}
