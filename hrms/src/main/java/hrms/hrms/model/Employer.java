package hrms.hrms.model;

import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
@Setter
public class Employer extends BaseEntity {

	private String companyName;

	private String website;

	private String mailAddress;

	private String password;

	private Integer phoneNumber;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Job> jobs;

}
