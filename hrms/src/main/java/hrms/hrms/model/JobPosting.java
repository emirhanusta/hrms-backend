package hrms.hrms.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	
	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
    @ManyToOne()
    @JoinColumn(name = "city_id")
	private City city;
    
	@ManyToOne()
	@JoinColumn(name = "job_position_id")
	private JobPosition jobPosition;
}
