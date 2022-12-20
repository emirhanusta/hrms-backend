package hrms.hrms.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
public class City extends BaseEntity{

	private String cityName;
	
	@OneToMany(mappedBy = "city")
	private List<JobPosting> jobPostings;
}
