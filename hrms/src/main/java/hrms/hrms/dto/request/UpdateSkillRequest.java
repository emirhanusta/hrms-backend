package hrms.hrms.dto.request;

import hrms.hrms.model.Level;
import lombok.Data;

@Data
public class UpdateSkillRequest {
    private Long id;
    private String name;
    private Level level;

}
