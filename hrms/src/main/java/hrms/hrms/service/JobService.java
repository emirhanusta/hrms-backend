package hrms.hrms.service;

import hrms.hrms.dto.converter.JobConverterDto;
import hrms.hrms.dto.request.CreateJobRequest;
import hrms.hrms.dto.request.UpdateJobRequest;
import hrms.hrms.dto.response.JobDto;
import hrms.hrms.model.Job;
import hrms.hrms.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobService {

    private final JobRepository jobRepository;
    private final JobConverterDto jobConverterDto;
    private final EmployerService employerService;
    private final JobPositionService jobPositionService;
    public List<JobDto> getAllJobs() {
        List<Job> jobs = jobRepository.findAll();

        return jobs.stream().map(jobConverterDto::convertToDto).collect(Collectors.toList());
    }


    public JobDto getJobById(Long id) {
        Job job = jobRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Job not found"));
        return jobConverterDto.convertToDto(job);
    }

    public List<JobDto> getActiveJobs() {
        List<Job> jobs = jobRepository.findAllByIsActiveTrue();

        return jobs.stream().map(jobConverterDto::convertToDto).collect(Collectors.toList());
    }

    public JobDto createJob(CreateJobRequest createJobRequest) {
        Job job = Job.builder()
                .description(createJobRequest.getDescription())
                .minSalary(createJobRequest.getMinSalary())
                .maxSalary(createJobRequest.getMaxSalary())
                .deadline(createJobRequest.getDeadline())
                .isActive(createJobRequest.getIsActive())
                .city(createJobRequest.getCity())
                .jobType(createJobRequest.getJobType())
                .workplaceType(createJobRequest.getWorkplaceType())
                .jobPosition(jobPositionService.getJobPosition(createJobRequest.getJobPositionId()))
                .build();
        jobRepository.save(job);
        employerService.addJob(createJobRequest.getEmployerId(), job);
        return jobConverterDto.convertToDto(job);
    }

    public JobDto updateJob(Long id, UpdateJobRequest updateJobRequest) {
        Job job = jobRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Job not found"));
        job.setDescription(updateJobRequest.getDescription());
        job.setMinSalary(updateJobRequest.getMinSalary());
        job.setMaxSalary(updateJobRequest.getMaxSalary());
        job.setDeadline(updateJobRequest.getDeadline());
        job.setIsActive(updateJobRequest.getIsActive());
        job.setCity(updateJobRequest.getCity());
        job.setJobType(updateJobRequest.getJobType());
        job.setWorkplaceType(updateJobRequest.getWorkplaceType());

        return jobConverterDto.convertToDto(jobRepository.save(job));
    }

    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }
}
