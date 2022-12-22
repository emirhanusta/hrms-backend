package hrms.hrms.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
public class Image extends BaseEntity{

	private String url;

	@OneToOne
	@JoinColumn(name="cv_id")
	@JsonIgnore
	private CV cv;
}
