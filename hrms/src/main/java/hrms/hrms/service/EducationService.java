package hrms.hrms.service;

import hrms.hrms.dto.request.CreateEducationRequest;
import hrms.hrms.dto.request.UpdateEducationRequest;
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

    protected List<Education> createEducation(List<CreateEducationRequest> educations) {
        for (CreateEducationRequest educationDto : educations) {
            Education education = Education.builder()
                    .schoolName(educationDto.getSchoolName())
                    .department(educationDto.getDepartment())
                    .startDate(educationDto.getStartDate())
                    .endDate(educationDto.getEndDate())
                    .build();
            educationRepository.save(education);
        }
        return educationRepository.findAll();
    }

    protected List<Education> updateEducation(List<UpdateEducationRequest> educations) {
        for (UpdateEducationRequest request : educations) {
            Education education = educationRepository.findById(request.getId()).orElseThrow();
            education.setSchoolName(request.getSchoolName());
            education.setDepartment(request.getDepartment());
            education.setStartDate(request.getStartDate());
            education.setEndDate(request.getEndDate());
            educationRepository.save(education);
        }
        return educationRepository.findAll();
    }
}
