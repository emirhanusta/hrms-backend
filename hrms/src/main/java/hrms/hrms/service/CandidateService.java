package hrms.hrms.service;

import hrms.hrms.dto.converter.CandidateDtoConverter;
import hrms.hrms.dto.request.CreateCandidateRequest;
import hrms.hrms.dto.response.CandidateDto;
import hrms.hrms.dto.request.UpdateCandidateRequest;
import hrms.hrms.exception.CandidateNotFoundException;
import hrms.hrms.model.CV;
import hrms.hrms.model.Candidate;
import hrms.hrms.repository.CandidateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
        return candidateRepository.findById(id).map(candidateDtoConverter::convertToDto).orElseThrow(() -> new CandidateNotFoundException("Could not find candidate with id: " + id));
    }

    public CandidateDto updateCandidateById(Long id, UpdateCandidateRequest request) {
        Optional<Candidate> candidate = candidateRepository.findById(id);
        if (candidate.isPresent()) {
            candidate.get().setFirstName(request.getFirstName());
            candidate.get().setLastName(request.getLastName());
            candidate.get().setMailAddress(request.getMailAddress());
            candidate.get().setPassword(request.getPassword());
            candidate.get().setPhoneNumber(request.getPhoneNumber());
            candidate.get().setDateOfBirth(request.getDateOfBirth());
            candidateRepository.save(candidate.get());
            return candidateDtoConverter.convertToDto(candidate.get());
        } else {
            throw new CandidateNotFoundException("Could not find candidate with id: " + id);
        }
    }

    protected void updateCandidateCV(Long id, CV cv) {
        Optional<Candidate> candidate = candidateRepository.findById(id);
        if (candidate.isPresent()) {
            candidate.get().setCv(cv);
            candidateRepository.save(candidate.get());
        } else {
            throw new CandidateNotFoundException("Could not find candidate with id: " + id);
        }
    }
    protected Candidate getOneCandidate(Long id) {
        return candidateRepository.findById(id).orElseThrow(() -> new CandidateNotFoundException("Could not find candidate with id: " + id));
    }
    public void deleteCandidateById(Long id) {
        Optional<Candidate> candidate = candidateRepository.findById(id);
        if (candidate.isPresent()) {
            candidateRepository.delete(candidate.get());
        } else {
            throw new CandidateNotFoundException("Could not find candidate with id: " + id);
        }
    }
}
