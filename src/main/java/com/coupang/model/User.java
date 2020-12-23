package com.coupang.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class User {
    @Id
    @Column(length = 20, nullable = false)
    private String userId;

    @Column(length = 20, nullable = false)
    private String phoneNumber;

    @Column(length = 20, nullable = false)
    private String email;

    @Column(length = 20, nullable = false)
    private String gender;

    @Builder
    public User(String userId, String phoneNumber, String email, String gender) {
        this.userId = userId;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return String.format(
                "User[userId='%s', phoneNumber='%s', email='%s', gender='%s']",
                this.userId, this.phoneNumber, this.email, this.gender
        );
    }
}
