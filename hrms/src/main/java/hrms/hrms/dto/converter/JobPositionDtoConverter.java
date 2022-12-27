package hrms.hrms.dto.converter;

import hrms.hrms.dto.response.JobPositionDto;
import hrms.hrms.model.JobPosition;
import org.springframework.stereotype.Component;

@Component
public class JobPositionDtoConverter
{
    public static JobPositionDto convertToDto(JobPosition jobPosition) {
        JobPositionDto jobPositionDto = new JobPositionDto();
        jobPositionDto.setId(jobPosition.getId());
        jobPositionDto.setJobTitle(jobPosition.getJobTitle());
        return jobPositionDto;
    }
}

