package hrms.hrms.service;

import hrms.hrms.dto.request.CreateExperienceRequest;
import hrms.hrms.dto.request.UpdateExperienceRequest;
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

    protected List<Experience> createExperience(List<CreateExperienceRequest> experiences) {

        for (CreateExperienceRequest request : experiences) {
            Experience experience = Experience.builder()
                    .companyName(request.getCompanyName())
                    .position(request.getPosition())
                    .startDate(request.getStartDate())
                    .endDate(request.getEndDate())
                    .description(request.getDescription())
                    .build();
            experienceRepository.save(experience);
        }
        return experienceRepository.findAll();
    }

    protected List<Experience> updateExperience(List<UpdateExperienceRequest> experiences) {
        for (UpdateExperienceRequest request : experiences) {
            Experience experience = experienceRepository.findById(request.getId()).orElseThrow();
            experience.setCompanyName(request.getCompanyName());
            experience.setPosition(request.getPosition());
            experience.setStartDate(request.getStartDate());
            experience.setEndDate(request.getEndDate());
            experience.setDescription(request.getDescription());
            experienceRepository.save(experience);
        }
        return experienceRepository.findAll();
    }
}

