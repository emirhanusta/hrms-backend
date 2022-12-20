package hrms.hrms.service;

import hrms.hrms.dto.EmployerCreateRequest;
import hrms.hrms.dto.EmployerDto;
import hrms.hrms.dto.EmployerDtoConverter;
import hrms.hrms.dto.EmployerUpdateRequest;
import hrms.hrms.model.Employer;
import hrms.hrms.repository.EmployerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployerService {
    private final EmployerRepository employerRepository;
    private final EmployerDtoConverter employerDtoConverter;

    public List<EmployerDto> getAllEmployers() {
        List<Employer> employers = employerRepository.findAll();
        return employers.stream().map(employerDtoConverter::convertToDto).collect(Collectors.toList());
    }

    public EmployerDto getEmployer(Long id) {
        Employer employer = employerRepository.findById(id).orElseThrow();
        return employerDtoConverter.convertToDto(employer);
    }

    public EmployerDto createEmployer(EmployerCreateRequest employerCreateRequest) {
        Employer employer = Employer.builder()
                .companyName(employerCreateRequest.getCompanyName())
                .mailAddress(employerCreateRequest.getMailAddress())
                .password(employerCreateRequest.getPassword())
                .phoneNumber(employerCreateRequest.getPhoneNumber())
                .website(employerCreateRequest.getWebsite())
                .build();
        employerRepository.save(employer);
        return employerDtoConverter.convertToDto(employer);
    }



    public EmployerDto updateEmployer(Long id, EmployerUpdateRequest employerUpdateRequest) {
        Optional<Employer> employer = employerRepository.findById(id);
        if (employer.isPresent()) {
            employer.get().setCompanyName(employerUpdateRequest.getCompanyName());
            employer.get().setMailAddress(employerUpdateRequest.getMailAddress());
            employer.get().setPassword(employerUpdateRequest.getPassword());
            employer.get().setPhoneNumber(employerUpdateRequest.getPhoneNumber());
            employer.get().setWebsite(employerUpdateRequest.getWebsite());
            employerRepository.save(employer.get());
            return employer.map(employerDtoConverter::convertToDto).orElseThrow();
        }
        return null;
    }

    public void deleteEmployer(Long id) {
        employerRepository.deleteById(id);
    }
}
