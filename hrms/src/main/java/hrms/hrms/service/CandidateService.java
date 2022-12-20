package hrms.hrms.service;

import hrms.hrms.dto.CandidateConverterDto;
import hrms.hrms.dto.CreateCandidateRequest;
import hrms.hrms.dto.CandidateDto;
import hrms.hrms.dto.UpdateCandidateRequest;
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
    private final CandidateConverterDto candidateConverterDto;

    public CandidateDto createCandidate(CreateCandidateRequest request) {
        Candidate candidate = Candidate.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .mailAddress(request.getMailAddress())
                .password(request.getPassword())
                .phoneNumber(request.getPhoneNumber())
                .build();
        candidateRepository.save(candidate);
        return candidateConverterDto.convertToDto(candidate);
    }

    public List<CandidateDto> getAllCandidates() {
        return candidateRepository.findAll().stream().map(candidateConverterDto::convertToDto).collect(Collectors.toList());
    }

    public CandidateDto getById(Long id) {
        return candidateRepository.findById(id).map(candidateConverterDto::convertToDto).orElseThrow();
    }

    public CandidateDto updateCandidate(Long id, UpdateCandidateRequest request) {
        Candidate candidate = candidateRepository.findById(id).orElseThrow();
        candidate.setFirstName(request.getFirstName());
        candidate.setLastName(request.getLastName());
        candidate.setMailAddress(request.getMailAddress());
        candidate.setPassword(request.getPassword());
        candidate.setPhoneNumber(request.getPhoneNumber());
        candidateRepository.save(candidate);
        return candidateConverterDto.convertToDto(candidate);
    }

    public void deleteCandidate(Long id) {
        candidateRepository.deleteById(id);
    }
}
