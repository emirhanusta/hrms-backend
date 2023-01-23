package hrms.hrms.service;

import hrms.hrms.dto.converter.JobConverterDto;
import hrms.hrms.dto.request.CreateJobRequest;
import hrms.hrms.dto.request.UpdateJobRequest;
import hrms.hrms.dto.response.JobDto;
import hrms.hrms.exception.JobNotFoundException;
import hrms.hrms.model.Job;
import hrms.hrms.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
        Job job = jobRepository.findById(id).orElseThrow(() -> new JobNotFoundException("Could not find job with id: " + id));
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
                .employer(employerService.getEmployer(createJobRequest.getEmployerId()))
                .build();
        jobRepository.save(job);
        employerService.addJob(createJobRequest.getEmployerId(), job);
        return jobConverterDto.convertToDto(job);
    }

    public JobDto updateJob(Long id, UpdateJobRequest updateJobRequest) {
        Optional<Job> job = jobRepository.findById(id);
        if (job.isPresent()) {
            job.get().setDescription(updateJobRequest.getDescription());
            job.get().setMinSalary(updateJobRequest.getMinSalary());
            job.get().setMaxSalary(updateJobRequest.getMaxSalary());
            job.get().setDeadline(updateJobRequest.getDeadline());
            job.get().setIsActive(updateJobRequest.getIsActive());
            job.get().setCity(updateJobRequest.getCity());
            job.get().setJobType(updateJobRequest.getJobType());
            job.get().setWorkplaceType(updateJobRequest.getWorkplaceType());
            job.get().setJobPosition(jobPositionService.getJobPosition(updateJobRequest.getJobPositionId()));
            jobRepository.save(job.get());
            return jobConverterDto.convertToDto(job.get());
        } else {
            throw new JobNotFoundException("Could not find job with id: " + id);
        }
    }

    public void deleteJob(Long id) {
        Optional<Job> job = jobRepository.findById(id);
        if (job.isPresent()) {
            job.get().getEmployer().getJobs().remove(job.get());
            jobRepository.deleteById(id);
        } else {
            throw new JobNotFoundException("Could not find job with id: " + id);
        }
    }
}
