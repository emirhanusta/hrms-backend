package hrms.hrms.dto.converter;

import hrms.hrms.dto.response.EmployerDto;
import hrms.hrms.model.Employer;
import org.springframework.stereotype.Component;

@Component
public class EmployerDtoConverter {

    public EmployerDto convertToDto(Employer employer) {
        EmployerDto employerDto = new EmployerDto();
        employerDto.setId(employer.getId());
        employerDto.setCompanyName(employer.getCompanyName());
        employerDto.setWebsite(employer.getWebsite());
        employerDto.setPhoneNumber(employer.getPhoneNumber());
        employerDto.setMailAddress(employer.getMailAddress());
        employerDto.setPassword(employer.getPassword());
        return employerDto;
    }
}
