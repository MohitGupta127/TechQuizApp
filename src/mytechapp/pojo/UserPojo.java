/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytechapp.pojo;

/**
 *
 * @author HP
 */
public class UserPojo {
    private String userid;
    private String usertype;
        private String password;

    public UserPojo(String userid, String usertype, String password) {
        this.userid = userid;
        this.usertype = usertype;
        this.password = password;
    }

    public UserPojo() {
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}
