package com.ti.crowd_manager.domain;

import java.util.Date;

public class ItemCat {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item_cat.id
     *
     * @mbg.generated Sun Jan 27 13:43:57 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item_cat.name
     *
     * @mbg.generated Sun Jan 27 13:43:57 CST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item_cat.is_parent
     *
     * @mbg.generated Sun Jan 27 13:43:57 CST 2019
     */
    private Integer isParent;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item_cat.parent_id
     *
     * @mbg.generated Sun Jan 27 13:43:57 CST 2019
     */
    private Integer parentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item_cat.create_time
     *
     * @mbg.generated Sun Jan 27 13:43:57 CST 2019
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item_cat.update_time
     *
     * @mbg.generated Sun Jan 27 13:43:57 CST 2019
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item_cat.status
     *
     * @mbg.generated Sun Jan 27 13:43:57 CST 2019
     */
    private Integer status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item_cat.id
     *
     * @return the value of item_cat.id
     *
     * @mbg.generated Sun Jan 27 13:43:57 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item_cat.id
     *
     * @param id the value for item_cat.id
     *
     * @mbg.generated Sun Jan 27 13:43:57 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item_cat.name
     *
     * @return the value of item_cat.name
     *
     * @mbg.generated Sun Jan 27 13:43:57 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item_cat.name
     *
     * @param name the value for item_cat.name
     *
     * @mbg.generated Sun Jan 27 13:43:57 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item_cat.is_parent
     *
     * @return the value of item_cat.is_parent
     *
     * @mbg.generated Sun Jan 27 13:43:57 CST 2019
     */
    public Integer getIsParent() {
        return isParent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item_cat.is_parent
     *
     * @param isParent the value for item_cat.is_parent
     *
     * @mbg.generated Sun Jan 27 13:43:57 CST 2019
     */
    public void setIsParent(Integer isParent) {
        this.isParent = isParent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item_cat.parent_id
     *
     * @return the value of item_cat.parent_id
     *
     * @mbg.generated Sun Jan 27 13:43:57 CST 2019
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item_cat.parent_id
     *
     * @param parentId the value for item_cat.parent_id
     *
     * @mbg.generated Sun Jan 27 13:43:57 CST 2019
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item_cat.create_time
     *
     * @return the value of item_cat.create_time
     *
     * @mbg.generated Sun Jan 27 13:43:57 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item_cat.create_time
     *
     * @param createTime the value for item_cat.create_time
     *
     * @mbg.generated Sun Jan 27 13:43:57 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item_cat.update_time
     *
     * @return the value of item_cat.update_time
     *
     * @mbg.generated Sun Jan 27 13:43:57 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item_cat.update_time
     *
     * @param updateTime the value for item_cat.update_time
     *
     * @mbg.generated Sun Jan 27 13:43:57 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item_cat.status
     *
     * @return the value of item_cat.status
     *
     * @mbg.generated Sun Jan 27 13:43:57 CST 2019
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item_cat.status
     *
     * @param status the value for item_cat.status
     *
     * @mbg.generated Sun Jan 27 13:43:57 CST 2019
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}