package hrms.hrms.dto;

import lombok.Data;

@Data
public class UpdateCandidateRequest {
    private String firstName;
    private String lastName;
    private String MailAddress;
    private String password;
    private Integer phoneNumber;
}
