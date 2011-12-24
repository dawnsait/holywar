package com.fasheng.service.dto;

import java.util.Date;

public class UserCatogeryConcernDTO extends BaseDTO {
    private static final long serialVersionUID = 4878775171513213534L;

    private Integer id;

    private String userId;

    private Integer msgCatogeryId;

    private Date gmtCreate;

    private Date gmtUpdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getMsgCatogeryId() {
        return msgCatogeryId;
    }

    public void setMsgCatogeryId(Integer msgCatogeryId) {
        this.msgCatogeryId = msgCatogeryId;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtUpdate() {
        return gmtUpdate;
    }

    public void setGmtUpdate(Date gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }

}