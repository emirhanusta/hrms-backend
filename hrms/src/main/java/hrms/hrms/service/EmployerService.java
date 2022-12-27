package hrms.hrms.service;

import hrms.hrms.dto.request.CreateEmployerRequest;
import hrms.hrms.dto.response.EmployerDto;
import hrms.hrms.dto.converter.EmployerDtoConverter;
import hrms.hrms.dto.request.UpdateEmployerRequest;
import hrms.hrms.model.Employer;
import hrms.hrms.model.Job;
import hrms.hrms.repository.EmployerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
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

    public EmployerDto getEmployerById(Long id) {
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
        Employer employer = employerRepository.findById(id).orElseThrow();
        employer.setCompanyName(updateEmployerRequest.getCompanyName());
        employer.setMailAddress(updateEmployerRequest.getMailAddress());
        employer.setPassword(updateEmployerRequest.getPassword());
        employer.setPhoneNumber(updateEmployerRequest.getPhoneNumber());
        employer.setWebsite(updateEmployerRequest.getWebsite());
        employerRepository.save(employer);
        return employerDtoConverter.convertToDto(employer);
    }

    public void deleteEmployer(Long id) {
        employerRepository.deleteById(id);
    }

    protected void addJob(Long id,Job job) {
        Employer employer = employerRepository.findById(id).orElseThrow();
        employer.getJobs().add(job);
        employerRepository.save(employer);
    }
}
