package hrms.hrms.dto.request;

import hrms.hrms.model.Level;
import lombok.Data;

@Data
public class CreateSkillRequest {

    private String name;

    private Level level;

}
