package hrms.hrms.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class CandidateDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String MailAddress;
    private String password;
    private String phoneNumber;
    private Date dateOfBirth;
}
