package hrms.hrms.service;

import hrms.hrms.dto.request.CreateCVRequest;
import hrms.hrms.dto.converter.CVDtoConverter;
import hrms.hrms.dto.request.UpdateCVRequest;
import hrms.hrms.dto.response.CVDto;
import hrms.hrms.model.CV;
import hrms.hrms.repository.CVRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CVService {

    private final CVRepository cvRepository;
    private final CandidateService candidateService;
    private final CVDtoConverter cvDtoConverter;
    private final ExperienceService experienceService;
    private final EducationService educationService;
    private final LanguageService languageService;
    private final SkillService skillService;
    private final ImageService imageService;

    public CVDto createCV(CreateCVRequest request) {
        CV cv = CV.builder()
                .coverLetter(request.getCoverLetter())
                .experiences(experienceService.createExperience(request.getExperience()))
                .educations(educationService.createEducation(request.getEducation()))
                .languages(languageService.createLanguage(request.getLanguage()))
                .skills(skillService.createSkill(request.getSkill()))
                .image(imageService.createImage(request.getImage()))
                .build();
        cvRepository.save(cv);
        candidateService.updateCandidateCV(request.getCandidateId(), cv);
        return cvDtoConverter.convertToDto(cv);
    }

    public CVDto updateCV(Long id, UpdateCVRequest request) {
        CV cv = cvRepository.findById(id).orElseThrow();
        cv.setCoverLetter(request.getCoverLetter());
        cv.setExperiences(experienceService.updateExperience(request.getExperience()));
        cv.setEducations(educationService.updateEducation(request.getEducation()));
        cv.setLanguages(languageService.updateLanguage(request.getLanguage()));
        cv.setSkills(skillService.updateSkill(request.getSkill()));
        cv.setImage(imageService.updateImage(request.getImage()));
        cvRepository.save(cv);
        return cvDtoConverter.convertToDto(cv);
    }
    public List<CVDto> getAllCVs() {
        List<CV> cvList = cvRepository.findAll();

        return cvList.stream().map(cvDtoConverter::convertToDto).collect(Collectors.toList());
    }

    public CVDto getCVById(Long id){
        return cvRepository.findById(id).map(cvDtoConverter::convertToDto).orElseThrow();
    }

    public void deleteCV(Long id) {
        cvRepository.deleteById(id);
    }
}
