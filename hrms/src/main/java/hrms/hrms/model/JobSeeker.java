package hrms.hrms.model;

import javax.persistence.Entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class JobSeeker extends User{

	private String firstName;
	
	private String lastName;
	
	private String dateOfBirth;
	
}
