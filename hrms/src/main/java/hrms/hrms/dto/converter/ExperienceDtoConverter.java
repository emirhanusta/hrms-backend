package hrms.hrms.dto.converter;

import hrms.hrms.dto.response.ExperienceDto;
import hrms.hrms.model.Experience;
import org.springframework.stereotype.Component;

@Component
public class ExperienceDtoConverter {

    public ExperienceDto convertToDto(Experience experience) {
        ExperienceDto experienceDto = new ExperienceDto();
        experienceDto.setId(experience.getId());
        experienceDto.setCompanyName(experience.getCompanyName());
        experienceDto.setPosition(experience.getPosition());
        experienceDto.setStartDate(experience.getStartDate());
        experienceDto.setEndDate(experience.getEndDate());
        experienceDto.setDescription(experience.getDescription());
        return experienceDto;
    }
}
