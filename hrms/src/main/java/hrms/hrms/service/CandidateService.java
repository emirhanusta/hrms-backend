package hrms.hrms.service;

import hrms.hrms.dto.converter.CandidateDtoConverter;
import hrms.hrms.dto.request.CreateCandidateRequest;
import hrms.hrms.dto.response.CandidateDto;
import hrms.hrms.dto.request.UpdateCandidateRequest;
import hrms.hrms.model.CV;
import hrms.hrms.model.Candidate;
import hrms.hrms.repository.CandidateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CandidateService {

    private final CandidateRepository candidateRepository;
    private final CandidateDtoConverter candidateDtoConverter;

    public CandidateDto createCandidate(CreateCandidateRequest request) {
        Candidate candidate = Candidate.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .mailAddress(request.getMailAddress())
                .password(request.getPassword())
                .phoneNumber(request.getPhoneNumber())
                .dateOfBirth(request.getDateOfBirth())
                .build();
        candidateRepository.save(candidate);
        return candidateDtoConverter.convertToDto(candidate);
    }

    public List<CandidateDto> getAllCandidates() {
        return candidateRepository.findAll().stream().map(candidateDtoConverter::convertToDto).collect(Collectors.toList());
    }

    public CandidateDto getCandidateById(Long id) {
        return candidateRepository.findById(id).map(candidateDtoConverter::convertToDto).orElseThrow();
    }

    public CandidateDto updateCandidateById(Long id, UpdateCandidateRequest request) {
        Candidate candidate = candidateRepository.findById(id).orElseThrow();
        candidate.setFirstName(request.getFirstName());
        candidate.setLastName(request.getLastName());
        candidate.setMailAddress(request.getMailAddress());
        candidate.setPassword(request.getPassword());
        candidate.setPhoneNumber(request.getPhoneNumber());
        candidateRepository.save(candidate);
        return candidateDtoConverter.convertToDto(candidate);
    }

    protected void updateCandidateCV(Long id, CV cv) {
        Candidate candidate = candidateRepository.findById(id).orElseThrow();
        candidate.setCv(cv);
        candidateRepository.save(candidate);
    }
    public void deleteCandidateById(Long id) {
        candidateRepository.deleteById(id);
    }
}
