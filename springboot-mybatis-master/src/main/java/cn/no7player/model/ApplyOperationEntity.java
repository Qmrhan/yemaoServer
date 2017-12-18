package cn.no7player.model;

import java.util.Date;

public class ApplyOperationEntity {
    private String ID;
    private Date OPERATION_TIME;
    private String OPERATION_TYPE;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Date getOPERATION_TIME() {
        return OPERATION_TIME;
    }

    public void setOPERATION_TIME(Date OPERATION_TIME) {
        this.OPERATION_TIME = OPERATION_TIME;
    }

    public String getOPERATION_TYPE() {
        return OPERATION_TYPE;
    }

    public void setOPERATION_TYPE(String OPERATION_TYPE) {
        this.OPERATION_TYPE = OPERATION_TYPE;
    }
}
