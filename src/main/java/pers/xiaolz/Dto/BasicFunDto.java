package pers.xiaolz.Dto;

/**
 * File: BasicFunDto
 * Description:请求基类
 * Date: 2020-11-17 11:12
 *
 * @Author: 毛豪峰
 */
public class BasicFunDto {
    /** api的id，一般为固定值，申请application后wg提供该id */
    private String application_id;

    /** 指定返回结果的范围，置空则返回所有结果。如有值则返回指定的结果（多个返回字段中间用,分割）。如指定某个字段不返回，在字段前加- */
    private String fields;

    /** 指定返回结果的显示语言，默认为英语en，常用选项包括日语ja、简中zh-cn、繁中zh-tw */
    private String language;

    public String getApplication_id() {
        return application_id;
    }

    public void setApplication_id(String application_id) {
        this.application_id = application_id;
    }

    public String getFields() {
        return fields;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
