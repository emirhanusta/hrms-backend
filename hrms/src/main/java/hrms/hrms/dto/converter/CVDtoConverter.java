package hrms.hrms.dto.converter;

import hrms.hrms.dto.response.CVDto;
import hrms.hrms.model.CV;
import org.springframework.stereotype.Component;

@Component
public class CVDtoConverter {

    public CVDto convertToDto(CV CV) {
        CVDto CVDto = new CVDto();
        CVDto.setId(CV.getId());
        CVDto.setCoverLetter(CV.getCoverLetter());
        CVDto.setCandidateId(CV.getCandidate().getId());
        CVDto.setExperience(CV.getExperience());
        CVDto.setEducation(CV.getEducation());
        CVDto.setLanguage(CV.getLanguage());
        CVDto.setImage(CV.getImage());
        CVDto.setSkill(CV.getSkill());
        return CVDto;
    }
}
