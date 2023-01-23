package hrms.hrms.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class UpdateCandidateRequest {
    private String firstName;
    private String lastName;
    private String MailAddress;
    private String password;
    private String phoneNumber;
    private Date dateOfBirth;
}
