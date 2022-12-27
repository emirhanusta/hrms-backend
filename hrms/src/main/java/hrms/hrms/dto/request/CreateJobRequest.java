package hrms.hrms.dto.request;

import hrms.hrms.model.City;
import hrms.hrms.model.JobType;
import hrms.hrms.model.WorkplaceType;
import lombok.Data;

@Data
public class CreateJobRequest {

        private String description;

        private String deadline;

        private Double maxSalary;

        private Double minSalary;

        private Boolean isActive;

        private City city;

        private JobType jobType;

        private WorkplaceType workplaceType;

        private Long employerId;

        private Long jobPositionId;
}
