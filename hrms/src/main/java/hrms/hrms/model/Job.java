package hrms.hrms.model;

import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
	@OnDelete(action = OnDeleteAction.CASCADE)
	private JobPosition jobPosition;
}
