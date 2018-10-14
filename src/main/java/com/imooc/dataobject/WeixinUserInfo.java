package com.imooc.dataobject;

import java.util.List;

/**
 * Created by cmy on 2017/9/5
 */
public class WeixinUserInfo {

    /**
     * openid : otB_EwcsAxFxAmSEXBPS5hUU5fdc
     * nickname : 故梦里
     * sex : 2
     * language : zh_CN
     * city :
     * province : 都柏林
     * country : 爱尔兰
     * headimgurl : http://wx.qlogo.cn/mmopen/vi_32/YEQ8PA64TQXicLNxL5JMJfnmyWFrPDSsGYrCT4FEfDoZ6gEV9auRN02hqaq5thzic1grrSpWjTgBLgibGXdDbyhIg/0
     * privilege : []
     */

    private String openid;
    private String nickname;
    private int sex;
    private String language;
    private String city;
    private String province;
    private String country;
    private String headimgurl;
    private List<?> privilege;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public List<?> getPrivilege() {
        return privilege;
    }

    public void setPrivilege(List<?> privilege) {
        this.privilege = privilege;
    }
}
