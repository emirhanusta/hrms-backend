package hrms.hrms.dto;

import lombok.Data;

@Data
public class EmployerCreateRequest  {

    private String mailAddress;

    private String password;

    private Integer phoneNumber;

    private String companyName;

    private String website;

}
