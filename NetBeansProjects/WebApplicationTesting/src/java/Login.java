
/**
 *
 * @author bas200193
 */
//import lombok.Setter;
//import lombok.Getter;
//import lombok.AllArgsConstructor;
//import lombok.delombok;
//@Setter
//@Getter
//@AllArgsConstructor
public class Login {

    private String userId;
    private String pass;

    public Login(String userId, String pass) {
        this.userId = userId;
        this.pass = pass;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
