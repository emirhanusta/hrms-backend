package hrms.hrms.dto;

import hrms.hrms.model.Candidate;
import org.springframework.stereotype.Component;
@Component
public class CandidateConverterDto {
    public CandidateDto convertToDto(Candidate candidate) {
        CandidateDto candidateDto = new CandidateDto();
        candidateDto.setId(candidate.getId());
        candidateDto.setFirstName(candidate.getFirstName());
        candidateDto.setLastName(candidate.getLastName());
        candidateDto.setMailAddress(candidate.getMailAddress());
        candidateDto.setPassword(candidate.getPassword());
        return candidateDto;
    }

}
