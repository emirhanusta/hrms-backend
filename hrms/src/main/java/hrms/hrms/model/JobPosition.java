package hrms.hrms.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
public class JobPosition extends BaseEntity{

	private String jobTitle;

	@OneToMany(mappedBy = "jobPosition")
	private List<JobPosting> jobPostings;


}	
