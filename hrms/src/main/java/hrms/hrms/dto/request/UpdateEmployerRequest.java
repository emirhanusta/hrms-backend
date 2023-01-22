package hrms.hrms.dto.request;

import lombok.Data;

@Data
public class UpdateEmployerRequest {
    private String mailAddress;
    private String password;
    private String phoneNumber;
    private String companyName;
    private String website;
}
