package cn.no7player.model;

public class UserEntity {
    private String ID;
    private String REAL_NAME;
    private String USER_NAME;
    private String PASSWORD;
    private String PHONE;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getREAL_NAME() {
        return REAL_NAME;
    }

    public void setREAL_NAME(String REAL_NAME) {
        this.REAL_NAME = REAL_NAME;
    }

    public String getUSER_NAME() {
        return USER_NAME;
    }

    public void setUSER_NAME(String USER_NAME) {
        this.USER_NAME = USER_NAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getPHONE() {
        return PHONE;
    }

    public void setPHONE(String PHONE) {
        this.PHONE = PHONE;
    }
}
