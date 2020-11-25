package pers.xiaolz.Dto;

/**
 * File: GetPlayersFunDto
 * Description:根据用户名查找用户id请求
 * Date: 2020-11-17 11:09
 *
 * @Author: 毛豪峰
 */
public class GetPlayersFunDto extends BasicFunDto{
    /** 需要搜索用户名，在type字段中指定搜索模式 */
    private String search;

    /** 返回的结果数，最大不超过100 */
    private int limit;

    /** 指定搜索模式，包括模糊搜索startswith（最短3位最长24位，只搜索以这个开头的用户）和精确搜索exact（需要完整的用户名，多个名字间用,分割） */
    private String type;

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
