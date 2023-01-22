package hrms.hrms.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.*;

@Getter
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
@Setter
public class Candidate extends BaseEntity {

	private String firstName;

	private String lastName;

	private String dateOfBirth;

	private String mailAddress;

	private String password;

	private String  phoneNumber;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cv_id")
	private CV cv;

}
