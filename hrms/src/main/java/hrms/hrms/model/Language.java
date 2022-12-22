package hrms.hrms.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
public class Language extends BaseEntity{

	private String name;
	
	private Level level;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="cv_id")
	@JsonIgnore
	private CV cv;
	
}
