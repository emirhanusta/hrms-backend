package hrms.hrms.model;

import javax.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
@Setter
public class Experience extends BaseEntity{

	private String companyName;

	private String position;

	private String startDate;

	private String endDate;

	private String description;


}
