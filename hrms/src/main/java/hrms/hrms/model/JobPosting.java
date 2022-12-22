package hrms.hrms.model;

import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
public class JobPosting extends BaseEntity{

	private String description;
	
	private Integer openPositions;
	
	private LocalDateTime deadline;
	
	private Double maxSalary;
	
	private Double minSalary;
	
	private Boolean isActive;

	private City city;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employer_id")
	private Employer employer;
    
	@ManyToOne()
	@JoinColumn(name = "job_position_id")
	private JobPosition jobPosition;
}
