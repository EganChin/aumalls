package com.mall.common.domain;

/**
 * @author Egan
 * @date 2019/7/15 23:58
 **/
public class Operator {

    private Integer id;

    private String name;
    private String pass;

    private Integer role;

    private String address;

    private String phone;

    private Long whiteTime;

    private boolean isAdmin = false;


    public Operator(Admin admin) {
        this(admin.getAdminId(), admin.getAdminName(), admin.getAdminPass(), admin.getAdminRole(), null, null, null, true);
    }

    public Operator(User user) {
        this(user.getUserId(), user.getUserName(), user.getUserPass(), null, user.getUserAddress(), user.getUserPhone(), user.getUserWhitetime(), false);
    }

    public Admin toAdmin() {
        if (!isAdmin)
            throw new ClassCastException("无法将User转换为Admin");
        Admin admin = new Admin();
        admin.setAdminId(getId());
        admin.setAdminName(getName());
        admin.setAdminPass(getPass());
        admin.setAdminRole(getRole());
        return admin;
    }

    public User toUser() {
        if (isAdmin)
            throw new ClassCastException("无法将Admin转换为User");
        User user = new User();
        user.setUserId(getId());
        user.setUserName(getName());
        user.setUserPass(getPass());
        user.setUserAddress(getAddress());
        user.setUserPhone(getPhone());
        user.setUserWhitetime(getWhiteTime());
        return user;
    }

    public static Operator fromObject(Object object) {
        if (object instanceof Admin)
            return new Operator((Admin) object);
        else if (object instanceof User)
            return new Operator((User) object);
        else
            throw new ClassCastException("不能将非User和非Admin的实体转换为Operator");
    }

    private Operator(Integer id, String name, String pass, Integer role, String address, String phone, Long whiteTime, boolean isAdmin) {
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.role = role;
        this.address = address;
        this.phone = phone;
        this.whiteTime = whiteTime;
        this.isAdmin = isAdmin;
    }

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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getWhiteTime() {
        return whiteTime;
    }

    public void setWhiteTime(Long whiteTime) {
        this.whiteTime = whiteTime;
    }


}
