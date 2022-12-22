package hrms.hrms.dto.request;

import lombok.Data;

@Data
public class CreateEmployerRequest {

    private String mailAddress;

    private String password;

    private Integer phoneNumber;

    private String companyName;

    private String website;

}
