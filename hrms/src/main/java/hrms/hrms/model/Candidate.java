package hrms.hrms.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
@Setter
public class Candidate extends BaseEntity {

	private String firstName;

	private String lastName;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	private String mailAddress;

	private String password;

	private String  phoneNumber;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "candidate_cv",
			joinColumns={@JoinColumn(name = "candidate_id", referencedColumnName = "id")},
			inverseJoinColumns = {@JoinColumn(name = "cv_id", referencedColumnName = "id")})
	private CV cv;

}
