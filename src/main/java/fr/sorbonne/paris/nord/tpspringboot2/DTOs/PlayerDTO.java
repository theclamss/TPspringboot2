package fr.sorbonne.paris.nord.tpspringboot2.DTOs;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class PlayerDTO {


    @NotNull
    private Long id;

    @NotEmpty
    private String firstname;

    @NotEmpty
    private String lastname;

    @Override
    public String toString() {
        return "PlayerDTO{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthday=" + birthday +
                ", position='" + position + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public PlayerDTO(Long id, String firstname, String lastname, Date birthday, String position) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.position = position;
    }
    public PlayerDTO() {

    }

    @NotEmpty
    private Date birthday;

    @NotEmpty
    private String position;

    // Getters and setters
}
