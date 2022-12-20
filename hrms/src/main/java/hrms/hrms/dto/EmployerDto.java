package hrms.hrms.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployerDto {

        private Long id;

        private String mailAddress;

        private String password;

        private String companyName;

        private String website;

        private Integer phoneNumber;
}
