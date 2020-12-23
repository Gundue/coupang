package com.coupang.datamodel.dto;

import com.coupang.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDTO {

    private String userId;
    private String phoneNumber;
    private String email;
    private String gender;

    public UserDTO(User user) {
        this.userId = user.getUserId();
        this.phoneNumber = user.getPhoneNumber();
        this.email = user.getEmail();
        this.gender = user.getGender();
    }

    @Override
    public String toString() {
        return String.format(
                "User[userId='%s', phoneNumber='%s', email='%s', gender='%s']",
                this.userId, this.phoneNumber, this.email, this.gender
        );
    }
}
