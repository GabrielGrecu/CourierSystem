package com.upt.form;

import com.upt.dto.BaseDTO;
import com.upt.dto.UserDTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Setter
@Getter
public class UserRegistrationForm extends BaseForm {
    @NotEmpty(message = "Login is required")
    @Pattern(regexp = "(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,}))*$", message = "Email id is invalid")
    private String login;
    @NotEmpty(message = "First Name is required")
    @Pattern(regexp = "(^[A-Za-z ]*)*$", message = "First Name is Invalid")
    private String firstName;
    @NotEmpty(message = "Last Name is required")
    @Pattern(regexp = "(^[A-Za-z ]*)*$", message = "Last Name is Invalid")
    private String lastName;
    @NotEmpty(message = "Gender is required")
    private String gender;
    @NotEmpty(message = "Mobile no. is required")
    @Pattern(regexp="(^07[0-9]{8})*$", message = "Contact Number is Invalid")
    private String mobileNo;
    @NotEmpty(message = "Password is required")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{6,20}$", message = "Incorrect Format")
    private String password;
    private Long roleId;
    private String roleName;
    @NotEmpty(message = "Date of Birth is required")
    private String dob;
    private String fullBranchName;

    @Override
    public BaseDTO getDTO() {
        UserDTO bean = new UserDTO();
        bean.setId(id);
        bean.setLogin(login);
        bean.setFirstName(firstName);
        bean.setLastName(lastName);
        bean.setGender(gender);
        bean.setMobileNo(mobileNo);
        bean.setRoleId(2L);
        bean.setRoleName("USER");
        bean.setDob(dob);
        bean.setPassword(password);
        bean.setCreatedBy(createdBy);
        bean.setModifiedBy(modifiedBy);
        bean.setCreatedDatetime(createdDateTime);
        bean.setModifiedDatetime(modifiedDateTime);
        return bean;
    }

    @Override
    public void populate(BaseDTO bDto) {
        UserDTO bean = (UserDTO) bDto;
        id = bean.getId();
        login = bean.getLogin();
        firstName = bean.getFirstName();
        lastName = bean.getLastName();
        gender = bean.getGender();
        mobileNo = bean.getMobileNo();
        password = bean.getPassword();
        roleId = bean.getRoleId();
        roleName = bean.getRoleName();
        dob = bean.getDob();
        createdBy = bean.getCreatedBy();
        createdDateTime = bean.getCreatedDatetime();
        modifiedBy = bean.getModifiedBy();
        modifiedDateTime = bean.getModifiedDatetime();
    }

}
