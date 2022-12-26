package hrms.hrms.model;

import javax.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
@Setter
public class Skill extends BaseEntity{
	
	private String name;
	
	private Level level;

}
