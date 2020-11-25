package pers.xiaolz.Dto;

/**
 * File: GetPlayerPersonalDataFunDto
 * Description:
 * Date: 2020-11-17 15:28
 *
 * @Author: 毛豪峰
 */
public class GetPlayerPersonalDataFunDto extends BasicFunDto {

    private String account_id;

    private String access_token;

    private String extra;

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
}
