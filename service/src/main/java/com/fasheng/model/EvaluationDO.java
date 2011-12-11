package com.fasheng.model;

import java.util.Date;

public class EvaluationDO extends BaseDo{
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluation.id
     *
     * @mbggenerated Tue Dec 06 23:15:11 CST 2011
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluation.type
     *
     * @mbggenerated Tue Dec 06 23:15:11 CST 2011
     */
    private Integer type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluation.score
     *
     * @mbggenerated Tue Dec 06 23:15:11 CST 2011
     */
    private Integer score;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluation.auth_user_id
     *
     * @mbggenerated Tue Dec 06 23:15:11 CST 2011
     */
    private String authUserId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluation.eval_user_id
     *
     * @mbggenerated Tue Dec 06 23:15:11 CST 2011
     */
    private String evalUserId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluation.msg_id
     *
     * @mbggenerated Tue Dec 06 23:15:11 CST 2011
     */
    private String msgId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluation.is_used
     *
     * @mbggenerated Tue Dec 06 23:15:11 CST 2011
     */
    private Byte isUsed;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluation.gmt_create
     *
     * @mbggenerated Tue Dec 06 23:15:11 CST 2011
     */
    private Date gmtCreate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluation.gmt_update
     *
     * @mbggenerated Tue Dec 06 23:15:11 CST 2011
     */
    private Date gmtUpdate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluation.id
     *
     * @return the value of evaluation.id
     *
     * @mbggenerated Tue Dec 06 23:15:11 CST 2011
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluation.id
     *
     * @param id the value for evaluation.id
     *
     * @mbggenerated Tue Dec 06 23:15:11 CST 2011
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluation.type
     *
     * @return the value of evaluation.type
     *
     * @mbggenerated Tue Dec 06 23:15:11 CST 2011
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluation.type
     *
     * @param type the value for evaluation.type
     *
     * @mbggenerated Tue Dec 06 23:15:11 CST 2011
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluation.score
     *
     * @return the value of evaluation.score
     *
     * @mbggenerated Tue Dec 06 23:15:11 CST 2011
     */
    public Integer getScore() {
        return score;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluation.score
     *
     * @param score the value for evaluation.score
     *
     * @mbggenerated Tue Dec 06 23:15:11 CST 2011
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluation.auth_user_id
     *
     * @return the value of evaluation.auth_user_id
     *
     * @mbggenerated Tue Dec 06 23:15:11 CST 2011
     */
    public String getAuthUserId() {
        return authUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluation.auth_user_id
     *
     * @param authUserId the value for evaluation.auth_user_id
     *
     * @mbggenerated Tue Dec 06 23:15:11 CST 2011
     */
    public void setAuthUserId(String authUserId) {
        this.authUserId = authUserId == null ? null : authUserId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluation.eval_user_id
     *
     * @return the value of evaluation.eval_user_id
     *
     * @mbggenerated Tue Dec 06 23:15:11 CST 2011
     */
    public String getEvalUserId() {
        return evalUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluation.eval_user_id
     *
     * @param evalUserId the value for evaluation.eval_user_id
     *
     * @mbggenerated Tue Dec 06 23:15:11 CST 2011
     */
    public void setEvalUserId(String evalUserId) {
        this.evalUserId = evalUserId == null ? null : evalUserId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluation.msg_id
     *
     * @return the value of evaluation.msg_id
     *
     * @mbggenerated Tue Dec 06 23:15:11 CST 2011
     */
    public String getMsgId() {
        return msgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluation.msg_id
     *
     * @param msgId the value for evaluation.msg_id
     *
     * @mbggenerated Tue Dec 06 23:15:11 CST 2011
     */
    public void setMsgId(String msgId) {
        this.msgId = msgId == null ? null : msgId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluation.is_used
     *
     * @return the value of evaluation.is_used
     *
     * @mbggenerated Tue Dec 06 23:15:11 CST 2011
     */
    public Byte getIsUsed() {
        return isUsed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluation.is_used
     *
     * @param isUsed the value for evaluation.is_used
     *
     * @mbggenerated Tue Dec 06 23:15:11 CST 2011
     */
    public void setIsUsed(Byte isUsed) {
        this.isUsed = isUsed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluation.gmt_create
     *
     * @return the value of evaluation.gmt_create
     *
     * @mbggenerated Tue Dec 06 23:15:11 CST 2011
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluation.gmt_create
     *
     * @param gmtCreate the value for evaluation.gmt_create
     *
     * @mbggenerated Tue Dec 06 23:15:11 CST 2011
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluation.gmt_update
     *
     * @return the value of evaluation.gmt_update
     *
     * @mbggenerated Tue Dec 06 23:15:11 CST 2011
     */
    public Date getGmtUpdate() {
        return gmtUpdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluation.gmt_update
     *
     * @param gmtUpdate the value for evaluation.gmt_update
     *
     * @mbggenerated Tue Dec 06 23:15:11 CST 2011
     */
    public void setGmtUpdate(Date gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }
}