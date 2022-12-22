package hrms.hrms.model;

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

	private Integer phoneNumber;


	@OneToOne
	@JoinColumn(name = "cv_id")
	private CV cv;

}
