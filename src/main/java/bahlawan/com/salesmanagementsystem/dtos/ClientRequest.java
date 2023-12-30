package bahlawan.com.salesmanagementsystem.dtos;

public class ClientRequest {

    private String name;
    private String lastname;
    private String mobile;

    public ClientRequest() {
    }

    public ClientRequest(String name, String lastName, String mobile) {
        this.name = name;
        this.lastname = lastName;
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
