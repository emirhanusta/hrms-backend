package hrms.hrms.dto;

import lombok.Data;

@Data
public class CreateCandidateRequest {

    private String firstName;
    private String lastName;
    private String MailAddress;
    private String password;
    private Integer phoneNumber;

}
