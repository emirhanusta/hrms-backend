package hrms.hrms.service;

import hrms.hrms.dto.converter.JobConverterDto;
import hrms.hrms.dto.request.CreateEmployerRequest;
import hrms.hrms.dto.response.EmployerDto;
import hrms.hrms.dto.converter.EmployerDtoConverter;
import hrms.hrms.dto.request.UpdateEmployerRequest;
import hrms.hrms.dto.response.JobDto;
import hrms.hrms.exception.EmployerNotFoundException;
import hrms.hrms.model.Employer;
import hrms.hrms.model.Job;
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
    private final JobConverterDto jobConverterDto;

    public List<EmployerDto> getAllEmployers() {
        List<Employer> employers = employerRepository.findAll();
        return employers.stream().map(employerDtoConverter::convertToDto).collect(Collectors.toList());
    }

    public EmployerDto getEmployerById(Long id) {
        Employer employer = employerRepository.findById(id).orElseThrow(() -> new EmployerNotFoundException("Could not find employer with id: " + id));
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
            return employerDtoConverter.convertToDto(employer.get());
        } else {
            throw new EmployerNotFoundException("Could not find employer with id: " + id);
        }
    }

    public void deleteEmployer(Long id) {
        Optional<Employer> employer = employerRepository.findById(id);
        if (employer.isPresent()) {
            employerRepository.delete(employer.get());
        } else {
            throw new EmployerNotFoundException("Could not find employer with id: " + id);
        }
    }

    public List<JobDto> getActiveJobsByEmployerId(Long id) {
        Optional<Employer> employer = employerRepository.findById(id);
        if (employer.isPresent()) {
            List<Job> jobs = employer.get().getJobs().stream().filter(Job::getIsActive).toList();
            return jobs.stream().map(jobConverterDto::convertToDto).toList();
        } else {
            throw new EmployerNotFoundException("Could not find employer with id: " + id);
        }
    }
    protected void addJob(Long id,Job job) {
        Employer employer = employerRepository.findById(id).orElseThrow(() -> new EmployerNotFoundException("Could not find employer with id: " + id));
        employer.getJobs().add(job);
        employerRepository.save(employer);
    }

    protected Employer getEmployer(Long id) {
        return employerRepository.findById(id).orElseThrow(() -> new EmployerNotFoundException("Could not find employer with id: " + id));
    }
}
