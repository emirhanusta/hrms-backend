package hrms.hrms.service;

import hrms.hrms.dto.request.CreateCVRequest;
import hrms.hrms.dto.converter.CVDtoConverter;
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
        CV cv = new CV();
        cvRepository.save(cv);
        cv.setCandidate(candidateService.getCandidate(request.getCandidateId()));
        cv.setCoverLetter(request.getCoverLetter());
        cv.setExperience(experienceService.createExperience(request.getExperience(),cv));
        cv.setEducation(educationService.createEducation(request.getEducation(),cv));
        cv.setLanguage(languageService.createLanguage(request.getLanguage(),cv));
        cv.setSkill(skillService.createSkill(request.getSkill(),cv));
        cv.setImage(imageService.createImage(request.getImage(),cv));
        cvRepository.save(cv);
        candidateService.updateCandidateCV(cv.getCandidate().getId(),cv);
        return cvDtoConverter.convertToDto(cv);
    }

    public List<CVDto> getAllCVs() {
        List<CV> cvList = cvRepository.findAll();

        return cvList.stream().map(cvDtoConverter::convertToDto).collect(Collectors.toList());
    }

    protected CV getOneCv(Long id){
        return cvRepository.findById(id).orElseThrow(() -> new RuntimeException("CV not found"));
    }
    public CVDto getCVById(Long id){
        return cvDtoConverter.convertToDto(getOneCv(id));
    }

    public void deleteCV(Long id) {
        cvRepository.deleteById(id);
    }
}
