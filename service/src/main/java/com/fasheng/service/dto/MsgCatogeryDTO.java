package com.fasheng.service.dto;

import java.util.Date;

public class MsgCatogeryDTO extends BaseDTO {
    private static final long serialVersionUID = -6503523331048199943L;

    private Integer id;

    private String name;

    private Date gmtCreate;

    private Date gmtUpdate;

    private Integer parentId;

    private Integer defaultExpireTime;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getDefaultExpireTime() {
        return defaultExpireTime;
    }

    public void setDefaultExpireTime(Integer defaultExpireTime) {
        this.defaultExpireTime = defaultExpireTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}