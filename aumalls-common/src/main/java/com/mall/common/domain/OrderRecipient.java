package com.mall.common.domain;


import com.baomidou.mybatisplus.annotation.TableId;

public class OrderRecipient {

    @TableId
    private Integer recipientsId;
    private String recipientsName;
    private String recipientsAddress;
    private String recipientsPhone;
    private Integer recipientsUser;
    private Integer recipientsChecked;


    public Integer getRecipientsId() {
        return recipientsId;
    }

    public void setRecipientsId(Integer recipientsId) {
        this.recipientsId = recipientsId;
    }


    public String getRecipientsName() {
        return recipientsName;
    }

    public void setRecipientsName(String recipientsName) {
        this.recipientsName = recipientsName;
    }


    public String getRecipientsAddress() {
        return recipientsAddress;
    }

    public void setRecipientsAddress(String recipientsAddress) {
        this.recipientsAddress = recipientsAddress;
    }


    public String getRecipientsPhone() {
        return recipientsPhone;
    }

    public void setRecipientsPhone(String recipientsPhone) {
        this.recipientsPhone = recipientsPhone;
    }


    public Integer getRecipientsUser() {
        return recipientsUser;
    }

    public void setRecipientsUser(Integer recipientsUser) {
        this.recipientsUser = recipientsUser;
    }


    public Integer getRecipientsChecked() {
        return recipientsChecked;
    }

    public void setRecipientsChecked(Integer recipientsChecked) {
        this.recipientsChecked = recipientsChecked;
    }

}
