package hrms.hrms.model;

import javax.persistence.Entity;
import lombok.*;

@Getter
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
@Setter
public class JobPosition extends BaseEntity{

	private String jobTitle;

}	
