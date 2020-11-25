package pers.xiaolz.Dto;

/**
 * File: GetPlayersReturnDetailDto
 * Description:根据用户名查找用户id返回的data
 * Date: 2020-11-17 11:10
 *
 * @Author: 毛豪峰
 */
public class GetPlayersReturnDetailDto{

    /** 用户名昵称 */
    private String nickname;

    /** 帐号id */
    private String account_id;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }
}
