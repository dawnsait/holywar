package com.fasheng.dao;

import com.fasheng.model.UserDO;

public interface UserDAO {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Tue Dec 06 23:15:11 CST 2011
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Tue Dec 06 23:15:11 CST 2011
     */
    int insert(UserDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Tue Dec 06 23:15:11 CST 2011
     */
    int insertSelective(UserDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Tue Dec 06 23:15:11 CST 2011
     */
    UserDO selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Tue Dec 06 23:15:11 CST 2011
     */
    int updateByPrimaryKeySelective(UserDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Tue Dec 06 23:15:11 CST 2011
     */
    int updateByPrimaryKey(UserDO record);
}