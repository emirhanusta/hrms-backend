package hrms.hrms.model;

import javax.persistence.Entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
public class JobSeeker extends BaseEntity {

	private String firstName;

	private String lastName;

	private String dateOfBirth;

	private String mailAddress;

	private String password;

	private Integer phoneNumber;


}
