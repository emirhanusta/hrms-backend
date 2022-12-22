package hrms.hrms.dto.request;

import lombok.Data;

@Data
public class CreateCandidateRequest {

    private String firstName;
    private String lastName;
    private String MailAddress;
    private String password;
    private String dateOfBirth;
    private Integer phoneNumber;

}
