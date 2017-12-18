package cn.no7player.model;

import java.util.Date;

public class ApplyInformationEntity {
    private String ID;
    private String APPLY_NAME;
    private String APPLY_TYPE;
    private String APPLY_CODE;
    private Date APPLY_START_TIME;
    private Date APPLY_END_TIME;
    private Date APPLY_CHECK_TIME;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getAPPLY_NAME() {
        return APPLY_NAME;
    }

    public void setAPPLY_NAME(String APPLY_NAME) {
        this.APPLY_NAME = APPLY_NAME;
    }

    public String getAPPLY_TYPE() {
        return APPLY_TYPE;
    }

    public void setAPPLY_TYPE(String APPLY_TYPE) {
        this.APPLY_TYPE = APPLY_TYPE;
    }

    public String getAPPLY_CODE() {
        return APPLY_CODE;
    }

    public void setAPPLY_CODE(String APPLY_CODE) {
        this.APPLY_CODE = APPLY_CODE;
    }

    public Date getAPPLY_START_TIME() {
        return APPLY_START_TIME;
    }

    public void setAPPLY_START_TIME(Date APPLY_START_TIME) {
        this.APPLY_START_TIME = APPLY_START_TIME;
    }

    public Date getAPPLY_END_TIME() {
        return APPLY_END_TIME;
    }

    public void setAPPLY_END_TIME(Date APPLY_END_TIME) {
        this.APPLY_END_TIME = APPLY_END_TIME;
    }

    public Date getAPPLY_CHECK_TIME() {
        return APPLY_CHECK_TIME;
    }

    public void setAPPLY_CHECK_TIME(Date APPLY_CHECK_TIME) {
        this.APPLY_CHECK_TIME = APPLY_CHECK_TIME;
    }
}
