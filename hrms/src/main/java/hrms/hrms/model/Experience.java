package hrms.hrms.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
public class Experience extends BaseEntity{

	private String companyName;

	private String position;

	private String startDate;

	private String endDate;

	private String description;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="cv_id")
	@JsonIgnore
	private CV cv;


}
