package cn.no7player.model;

import java.util.Date;

public class AccessTbEntity {
    private String ID;
    private String ACCESS_NAME;
    private Date ACCESS_TIME;
    private Integer COUNTS;
    private String TYPE;
    private String INFORMATION_CODE;
    private String CID;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getACCESS_NAME() {
        return ACCESS_NAME;
    }

    public void setACCESS_NAME(String ACCESS_NAME) {
        this.ACCESS_NAME = ACCESS_NAME;
    }

    public Date getACCESS_TIME() {
        return ACCESS_TIME;
    }

    public void setACCESS_TIME(Date ACCESS_TIME) {
        this.ACCESS_TIME = ACCESS_TIME;
    }

    public Integer getCOUNTS() {
        return COUNTS;
    }

    public void setCOUNTS(Integer COUNTS) {
        this.COUNTS = COUNTS;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public String getINFORMATION_CODE() {
        return INFORMATION_CODE;
    }

    public void setINFORMATION_CODE(String INFORMATION_CODE) {
        this.INFORMATION_CODE = INFORMATION_CODE;
    }

    public String getCID() {
        return CID;
    }

    public void setCID(String CID) {
        this.CID = CID;
    }
}
