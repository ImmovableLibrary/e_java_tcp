package pers.xiaolz.Dto;

import java.util.Map;

/**
 * File: GetPlayerPersonalDataReturnDto
 * Description:
 * Date: 2020-11-17 15:28
 *
 * @Author: 毛豪峰
 */
public class GetPlayerPersonalDataReturnDto extends BasicReturnDto {

    private Map<String,GetPlayerPersonalDataReturnDetailDto> data;

    public Map<String, GetPlayerPersonalDataReturnDetailDto> getData() {
        return data;
    }

    public void setData(Map<String, GetPlayerPersonalDataReturnDetailDto> data) {
        this.data = data;
    }
}
