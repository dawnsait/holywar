package com.fasheng.model;

public class DistrictDO {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column district.id
     *
     * @mbggenerated Tue Dec 06 23:15:11 CST 2011
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column district.district_name
     *
     * @mbggenerated Tue Dec 06 23:15:11 CST 2011
     */
    private String districtName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column district.city_id
     *
     * @mbggenerated Tue Dec 06 23:15:11 CST 2011
     */
    private Integer cityId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column district.id
     *
     * @return the value of district.id
     *
     * @mbggenerated Tue Dec 06 23:15:11 CST 2011
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column district.id
     *
     * @param id the value for district.id
     *
     * @mbggenerated Tue Dec 06 23:15:11 CST 2011
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column district.district_name
     *
     * @return the value of district.district_name
     *
     * @mbggenerated Tue Dec 06 23:15:11 CST 2011
     */
    public String getDistrictName() {
        return districtName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column district.district_name
     *
     * @param districtName the value for district.district_name
     *
     * @mbggenerated Tue Dec 06 23:15:11 CST 2011
     */
    public void setDistrictName(String districtName) {
        this.districtName = districtName == null ? null : districtName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column district.city_id
     *
     * @return the value of district.city_id
     *
     * @mbggenerated Tue Dec 06 23:15:11 CST 2011
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column district.city_id
     *
     * @param cityId the value for district.city_id
     *
     * @mbggenerated Tue Dec 06 23:15:11 CST 2011
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }
}