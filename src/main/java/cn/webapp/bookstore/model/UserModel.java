package cn.webapp.bookstore.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * user model
 * @author china
 */
@Data
@Getter
@Setter
public class UserModel {
    private int userId;
    private String userName;
    private String password;
    private String gender;
    private int age;
}
