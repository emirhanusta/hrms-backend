package hrms.hrms.dto.converter;

import hrms.hrms.dto.response.CandidateDto;
import hrms.hrms.model.Candidate;
import org.springframework.stereotype.Component;
@Component
public class CandidateDtoConverter {
    public CandidateDto convertToDto(Candidate candidate) {
        CandidateDto candidateDto = new CandidateDto();
        candidateDto.setId(candidate.getId());
        candidateDto.setFirstName(candidate.getFirstName());
        candidateDto.setLastName(candidate.getLastName());
        candidateDto.setMailAddress(candidate.getMailAddress());
        candidateDto.setPassword(candidate.getPassword());
        candidateDto.setPhoneNumber(candidate.getPhoneNumber());
        candidateDto.setDateOfBirth(candidate.getDateOfBirth());
        return candidateDto;
    }

}
