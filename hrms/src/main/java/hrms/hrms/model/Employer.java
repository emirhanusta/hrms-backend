package hrms.hrms.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.*;
import lombok.experimental.SuperBuilder;

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

}
