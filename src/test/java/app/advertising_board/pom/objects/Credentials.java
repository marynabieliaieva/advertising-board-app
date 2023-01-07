package app.advertising_board.pom.objects;

import app.advertising_board.pom.utils.JacksonUtils;

import java.io.IOException;

public class Credentials {
    private String role;
    private String userName;
    private String password;

    public Credentials(){
    }

    public Credentials(String role) throws IOException {
        Credentials[] credentials = JacksonUtils.deserializeJson("credentials.json", Credentials[].class);
        for(Credentials credential : credentials){
            if(credential.getRole().equals(role)){
                this.role=credential.getRole();
                this.userName=credential.getUserName();
                this.password=credential.getPassword();
            }
        }
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
