package com.fasheng.service.dto;

import java.util.Date;

public class EvaluationDTO extends BaseDTO {

    private static final long serialVersionUID = 3334932433092005489L;

    private Integer id;

    private Integer type;

    private Integer score;

    private String authUserId;

    private String evalUserId;

    private String msgId;

    private Byte isUsed;

    private Date gmtCreate;

    private Date gmtUpdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getAuthUserId() {
        return authUserId;
    }

    public void setAuthUserId(String authUserId) {
        this.authUserId = authUserId == null ? null : authUserId.trim();
    }

    public String getEvalUserId() {
        return evalUserId;
    }

    public void setEvalUserId(String evalUserId) {
        this.evalUserId = evalUserId == null ? null : evalUserId.trim();
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId == null ? null : msgId.trim();
    }

    public Byte getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(Byte isUsed) {
        this.isUsed = isUsed;
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