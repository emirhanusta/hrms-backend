package hrms.hrms.service;

import hrms.hrms.dto.request.CreateEmployerRequest;
import hrms.hrms.dto.response.EmployerDto;
import hrms.hrms.dto.converter.EmployerDtoConverter;
import hrms.hrms.dto.request.UpdateEmployerRequest;
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

    public EmployerDto createEmployer(CreateEmployerRequest createEmployerRequest) {
        Employer employer = Employer.builder()
                .companyName(createEmployerRequest.getCompanyName())
                .mailAddress(createEmployerRequest.getMailAddress())
                .password(createEmployerRequest.getPassword())
                .phoneNumber(createEmployerRequest.getPhoneNumber())
                .website(createEmployerRequest.getWebsite())
                .build();
        employerRepository.save(employer);
        return employerDtoConverter.convertToDto(employer);
    }



    public EmployerDto updateEmployer(Long id, UpdateEmployerRequest updateEmployerRequest) {
        Optional<Employer> employer = employerRepository.findById(id);
        if (employer.isPresent()) {
            employer.get().setCompanyName(updateEmployerRequest.getCompanyName());
            employer.get().setMailAddress(updateEmployerRequest.getMailAddress());
            employer.get().setPassword(updateEmployerRequest.getPassword());
            employer.get().setPhoneNumber(updateEmployerRequest.getPhoneNumber());
            employer.get().setWebsite(updateEmployerRequest.getWebsite());
            employerRepository.save(employer.get());
            return employer.map(employerDtoConverter::convertToDto).orElseThrow();
        }
        return null;
    }

    public void deleteEmployer(Long id) {
        employerRepository.deleteById(id);
    }
}
