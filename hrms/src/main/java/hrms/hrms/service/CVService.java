package hrms.hrms.service;

import hrms.hrms.dto.request.CreateCVRequest;
import hrms.hrms.dto.converter.CVDtoConverter;
import hrms.hrms.dto.request.UpdateCVRequest;
import hrms.hrms.dto.response.CVDto;
import hrms.hrms.exception.CvNotFoundException;
import hrms.hrms.model.CV;
import hrms.hrms.repository.CVRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
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
        Optional<CV> cv = cvRepository.findById(id);
        if (cv.isPresent()) {
            cv.get().setCoverLetter(request.getCoverLetter());
            cv.get().setExperiences(experienceService.updateExperience(request.getExperience()));
            cv.get().setEducations(educationService.updateEducation(request.getEducation()));
            cv.get().setLanguages(languageService.updateLanguage(request.getLanguage()));
            cv.get().setSkills(skillService.updateSkill(request.getSkill()));
            cv.get().setImage(imageService.updateImage(request.getImage()));
            cvRepository.save(cv.get());
            return cvDtoConverter.convertToDto(cv.get());
        } else {
            throw new CvNotFoundException("Could not find cv with id: " + id);
        }
    }
    public List<CVDto> getAllCVs() {
        List<CV> cvList = cvRepository.findAll();

        return cvList.stream().map(cvDtoConverter::convertToDto).collect(Collectors.toList());
    }

    public CVDto getCVById(Long id){
        return cvRepository.findById(id).map(cvDtoConverter::convertToDto).orElseThrow(() -> new CvNotFoundException("Could not find CV with id: " + id));
    }

    public void deleteCV(Long id) {
        try {
            cvRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new CvNotFoundException("Could not find CV with id: " + id);
        }
    }
}
