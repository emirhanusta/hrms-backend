package hrms.hrms.dto.converter;

import hrms.hrms.dto.response.JobDto;
import hrms.hrms.model.Job;
import org.springframework.stereotype.Component;

@Component
public class JobConverterDto {
    public JobDto convertToDto(Job job) {
        return JobDto.builder()
                .id(job.getId())
                .description(job.getDescription())
                .minSalary(job.getMinSalary())
                .maxSalary(job.getMaxSalary())
                .deadline(job.getDeadline())
                .isActive(job.getIsActive())
                .city(job.getCity())
                .jobType(job.getJobType())
                .workplaceType(job.getWorkplaceType())
                .jobPositionId(job.getJobPosition().getId())
                .employerId(job.getEmployer().getId())
                .build();
    }
}
