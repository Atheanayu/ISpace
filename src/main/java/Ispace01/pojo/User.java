package Ispace01.pojo;

import Ispace01.service.SecurityImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;


public class User {// 对于这里的成员变量的基本想法是，必须成员变量在构造时候进行，非必须成员变量在注册之后设置中完成
    @Autowired
    SecurityImpl security;
    private Long id;
    private Date reg_time;//文档说是int类型，但是mysql中有固定的时间格式
    private String unionid;
    private String username;
    private String password;//加密后的
    private String profession;
    private String telephone ;
    private String email ;
    private String qq;
    private String wechat;
    private String organization;
    private String major;
    private String description ;
    private String ability;
    private String experience;



    public User(){
        reg_time = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setReg_time(Date reg_time) {
        this.reg_time = reg_time;
    }

    public Date getReg_time() {
        return reg_time;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getUnionid() {
        return unionid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = SecurityImpl.EncoderByMD5(password);
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
}


