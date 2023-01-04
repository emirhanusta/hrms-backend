package hrms.hrms.dto.request;

import hrms.hrms.model.City;
import hrms.hrms.model.JobType;
import hrms.hrms.model.WorkplaceType;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateJobRequest {

        @NotBlank
        private String description;
        @NotBlank
        private String deadline;

        private Double maxSalary;

        private Double minSalary;
        @NotBlank
        private Boolean isActive;
        @NotBlank
        private City city;
        @NotBlank
        private JobType jobType;
        @NotBlank
        private WorkplaceType workplaceType;
        @NotBlank
        private Long employerId;
        @NotBlank
        private Long jobPositionId;
}
