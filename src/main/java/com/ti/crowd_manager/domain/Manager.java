package com.ti.crowd_manager.domain;

public class Manager {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager.id
     *
     * @mbg.generated Sun Jan 27 13:43:57 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager.name
     *
     * @mbg.generated Sun Jan 27 13:43:57 CST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager.password
     *
     * @mbg.generated Sun Jan 27 13:43:57 CST 2019
     */
    private String password;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager.id
     *
     * @return the value of manager.id
     *
     * @mbg.generated Sun Jan 27 13:43:57 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager.id
     *
     * @param id the value for manager.id
     *
     * @mbg.generated Sun Jan 27 13:43:57 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager.name
     *
     * @return the value of manager.name
     *
     * @mbg.generated Sun Jan 27 13:43:57 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager.name
     *
     * @param name the value for manager.name
     *
     * @mbg.generated Sun Jan 27 13:43:57 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager.password
     *
     * @return the value of manager.password
     *
     * @mbg.generated Sun Jan 27 13:43:57 CST 2019
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager.password
     *
     * @param password the value for manager.password
     *
     * @mbg.generated Sun Jan 27 13:43:57 CST 2019
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}