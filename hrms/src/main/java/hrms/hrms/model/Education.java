package hrms.hrms.model;


import javax.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
@Setter
public class Education extends BaseEntity{

	private String schoolName;

	private String department;

	private String startDate;

	private String endDate;

}
