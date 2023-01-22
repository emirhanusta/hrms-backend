package hrms.hrms.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CandidateDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String MailAddress;
    private String password;
    private String phoneNumber;
}
