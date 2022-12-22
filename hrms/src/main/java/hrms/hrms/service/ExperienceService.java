package hrms.hrms.service;

import hrms.hrms.dto.converter.ExperienceDtoConverter;
import hrms.hrms.dto.request.CreateExperienceRequest;
import hrms.hrms.dto.response.ExperienceDto;
import hrms.hrms.model.CV;
import hrms.hrms.model.Experience;
import hrms.hrms.repository.ExperienceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Lazy))
public class ExperienceService {

    private final ExperienceRepository experienceRepository;
    private final ExperienceDtoConverter experienceDtoConverter;
    private final CVService cvService;

    protected List<Experience> createExperience(List<CreateExperienceRequest> experiences, CV cv) {

        for (CreateExperienceRequest request : experiences) {
            Experience experience = Experience.builder()
                    .companyName(request.getCompanyName())
                    .position(request.getPosition())
                    .startDate(request.getStartDate())
                    .endDate(request.getEndDate())
                    .description(request.getDescription())
                    .cv(cv)
                    .build();
            experienceRepository.save(experience);
        }
        return experienceRepository.findAll();
    }

    protected List<ExperienceDto> getAllExperiences() {
      List<Experience> experiences = experienceRepository.findAll();
      return experiences.stream().map(experienceDtoConverter::convertToDto)
              .collect(java.util.stream.Collectors.toList());
    }
}

