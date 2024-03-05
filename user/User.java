package user;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class User {
    private String username;
    private String password;
    private String passwordConfirm;
    private String name;
    private String socialSecurityNumber;
    private String phoneNumber;
    private String address;
    private String job;
    private double height;
    private double weight;
    @Builder
    public User(String username, String password, String passwordConfirm, String name, String socialSecurityNumber,
                String phoneNumber, String address, String job, double height, double weight){
        this.username = username;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.name = name;
        this.socialSecurityNumber = socialSecurityNumber;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.job = job;
        this.height = height;
        this.weight = weight;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
}