package nl.novi.techiteasy1121.dto;

import lombok.Data;

@Data
public class UserDto {

    private long id;
    private String username;
    private String password;
    private String role;

    public UserDto() {
    }

    public UserDto( long id, String username, String password, String role ) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId( long id ) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole( String role ) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername( String username ) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }
}
