package hrms.hrms.service;

import hrms.hrms.dto.request.CreateEducationRequest;
import hrms.hrms.model.CV;
import hrms.hrms.model.Education;
import hrms.hrms.repository.EducationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Lazy))
public class EducationService {

    private final EducationRepository educationRepository;
    private final CVService cvService;
    public List<Education> createEducation(List<CreateEducationRequest> educations, CV cv) {
        for (CreateEducationRequest educationDto : educations) {
            Education education = Education.builder()
                    .schoolName(educationDto.getSchoolName())
                    .department(educationDto.getDepartment())
                    .startDate(educationDto.getStartDate())
                    .endDate(educationDto.getEndDate())
                    .cv(cv)
                    .build();
            educationRepository.save(education);
        }
        return educationRepository.findAll();
    }
}
