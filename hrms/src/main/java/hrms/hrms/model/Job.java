package hrms.hrms.model;

import javax.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
@Setter
public class Job extends BaseEntity{

	private String description;

	private String deadline;
	
	private Double maxSalary;
	
	private Double minSalary;
	
	private Boolean isActive;

	@Enumerated(EnumType.STRING)
	private City city;

	@Enumerated(EnumType.STRING)
	private JobType jobType;

	@Enumerated(EnumType.STRING)
	private WorkplaceType workplaceType;
    
	@ManyToOne()
	@JoinColumn(name = "job_position_id")
	private JobPosition jobPosition;
}
