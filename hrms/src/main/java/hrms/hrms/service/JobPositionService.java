package hrms.hrms.service;

import hrms.hrms.dto.converter.JobPositionDtoConverter;
import hrms.hrms.dto.request.CreateJobPositionRequest;
import hrms.hrms.dto.request.UpdateJobPositionRequest;
import hrms.hrms.dto.response.JobPositionDto;
import hrms.hrms.model.JobPosition;
import hrms.hrms.repository.JobPositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobPositionService {

    private final JobPositionRepository jobPositionRepository;


    public List<JobPositionDto> getAllJobPositions() {
        List<JobPosition> jobPositions = jobPositionRepository.findAll();

        return jobPositions.stream().map(JobPositionDtoConverter::convertToDto).toList();
    }

    public JobPositionDto getJobPositionById(Long id) {
        JobPosition jobPosition = jobPositionRepository.findById(id).orElseThrow();

        return JobPositionDtoConverter.convertToDto(jobPosition);
    }

    public JobPositionDto createJobPosition(CreateJobPositionRequest request) {
        JobPosition jobPosition = JobPosition.builder()
                .jobTitle(request.getTitle())
                .build();
        jobPositionRepository.save(jobPosition);

        return JobPositionDtoConverter.convertToDto(jobPosition);
    }

    public JobPositionDto updateJobPosition(Long id, UpdateJobPositionRequest request) {
        JobPosition jobPosition = jobPositionRepository.findById(id).orElseThrow();
        jobPosition.setJobTitle(request.getTitle());
        jobPositionRepository.save(jobPosition);

        return JobPositionDtoConverter.convertToDto(jobPosition);
    }

    public void deleteJobPosition(Long id) {
        Optional<JobPosition> jobPosition = jobPositionRepository.findById(id);
        jobPosition.ifPresent(jobPositionRepository::delete);
    }

    protected JobPosition getJobPosition(Long jobPositionId) {
        return jobPositionRepository.findById(jobPositionId).orElseThrow();
    }
}
