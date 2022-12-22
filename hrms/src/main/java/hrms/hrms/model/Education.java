package hrms.hrms.model;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
public class Education extends BaseEntity{

	private String schoolName;

	private String department;

	private String startDate;

	private String endDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="cv_id")
	@JsonIgnore
	private CV cv;
	
}
