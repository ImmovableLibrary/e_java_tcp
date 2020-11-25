package pers.xiaolz.Dto;

import java.util.ArrayList;

/**
 * File: GetPlayersReturnDto
 * Description:根据用户名查找用户id返回的整个结果
 * Date: 2020-11-17 11:10
 *
 * @Author: 毛豪峰
 */
public class GetPlayersReturnDto extends BasicReturnDto {

    private ArrayList<GetPlayersReturnDetailDto> data;

    public ArrayList<GetPlayersReturnDetailDto> getData() {
        return data;
    }

    public void setData(ArrayList<GetPlayersReturnDetailDto> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "GetPlayersReturnDto{" +
                "data=" + data +
                '}';
    }
}
