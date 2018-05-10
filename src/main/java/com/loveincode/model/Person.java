package com.loveincode.model;

import java.util.Date;
import javax.persistence.*;

import cn.afterturn.easypoi.excel.annotation.Excel;

@Table(name = "t_person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Excel(name="姓名", orderNum="0")
    private String name;

    @Excel(name="性别", orderNum="1")
    private String sex;

    @Excel(name="年龄", orderNum="2")
    private Integer age;

    @Excel(name="生日", orderNum="3", importFormat="yyyy-MM-dd", exportFormat="yyyy-MM-dd")
    private Date birth;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @return birth
     */
    public Date getBirth() {
        return birth;
    }

    /**
     * @param birth
     */
    public void setBirth(Date birth) {
        this.birth = birth;
    }
}