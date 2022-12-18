package hrms.hrms.model;

import java.util.List;
import javax.persistence.Entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employer extends User{
	
	private String companyName;
	
	private String webSite;
	
	private Integer telNo;
	
	private List<JobPosting> jobPostings;
}
