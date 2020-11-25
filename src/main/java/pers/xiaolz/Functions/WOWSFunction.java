package pers.xiaolz.Functions;

import pers.xiaolz.Dto.*;
import com.alibaba.fastjson.JSONObject;
import pers.xiaolz.Utils.*;

import java.awt.*;
import java.math.BigDecimal;
import java.util.*;

/**
 * File: WOWSFunction
 * Description:
 * Date: 2020-11-20 15:58
 *
 * @Author: 毛豪峰
 */
public class WOWSFunction {

    public static void selectPersonData(String msg, long selfQQ, long fromGroup){
        String msgs[] = msg.split("\\+");
        String area = msgs[1];
        if(!"eu".equals(area) && !"ru".equals(area) && !"com".equals(area) && !"asia".equals(area)){
            String result = "服务器代码无效，请检查（欧服eu，俄服ru，美服com，亚服asia）";
            Core.sendGroupMessages(selfQQ, fromGroup, result, 0);
        }else{
            try {
                Core.sendGroupMessages(selfQQ, fromGroup, "战绩查询开始", 0);

                StringBuffer url = new StringBuffer();
                url.append(Constant.wargamingUrl.GET_PLAYERS_START);
                url.append(area);
                url.append(Constant.wargamingUrl.GET_PLAYERS_END);

                GetPlayersFunDto getPlayersFunDto = new GetPlayersFunDto();
                getPlayersFunDto.setSearch(msgs[2]);
                getPlayersFunDto.setApplication_id(Constant.wargamingUrl.application_id);
                getPlayersFunDto.setType("exact");

                Map getPlayersMap = JSONObject.parseObject(JSONObject.toJSONString(getPlayersFunDto), Map.class);

                GetPlayersReturnDto getPlayersReturnDto=JSONObject.toJavaObject(HttpClient.get(url.toString(),getPlayersMap), GetPlayersReturnDto.class);
                ArrayList<GetPlayersReturnDetailDto> accountList = getPlayersReturnDto.getData();
                StringBuffer result = new StringBuffer();
                for (GetPlayersReturnDetailDto dto:accountList) {

                    url = new StringBuffer();
                    url.append(Constant.wargamingUrl.GET_PLAYER_PERSONAL_DATA_START);
                    url.append(area);
                    url.append(Constant.wargamingUrl.GET_PLAYER_PERSONAL_DATA_END);

                    GetPlayerPersonalDataFunDto getPlayerPersonalDataFunDto = new GetPlayerPersonalDataFunDto();
                    getPlayerPersonalDataFunDto.setAccount_id(dto.getAccount_id());
                    getPlayerPersonalDataFunDto.setApplication_id(Constant.wargamingUrl.application_id);
//                    getPlayerPersonalDataFunDto.setAccess_token("");
//                    getPlayerPersonalDataFunDto.setExtra("");
//                    getPlayerPersonalDataFunDto.setFields("");
//                    getPlayerPersonalDataFunDto.setLanguage("");
                    Map getPlayerPersonalDataMap = JSONObject.parseObject(JSONObject.toJSONString(getPlayerPersonalDataFunDto), Map.class);
                    GetPlayerPersonalDataReturnDto getPlayerPersonalDataReturnDto=JSONObject.toJavaObject(HttpClient.get(url.toString(),getPlayerPersonalDataMap), GetPlayerPersonalDataReturnDto.class);
//                    Map tempMap = getPlayerPersonalDataReturnDto.getData();
//                    String str = JSON.toJSONString(tempMap.get(dto.getAccount_id()));
//                    GetPlayerPersonalDataReturnDetailDto accountData = JSON.parseObject(str, GetPlayerPersonalDataReturnDetailDto.class);
                    GetPlayerPersonalDataReturnDetailDto accountData = getPlayerPersonalDataReturnDto.getData().get(dto.getAccount_id());
                    PVPDto pvpDto = accountData.getStatistics().getPvp();

                    if(accountData.isHidden_profile()){
                        result.append("用户名").append(accountData.getNickname()).append("\n");
                        result.append("该用户隐藏了战绩");
                        continue;
                    }

                    result.append("用户名 ").append(accountData.getNickname()).append("\n");
                    result.append("战绩更新时间 ").append(UnixTimeUtils.getDateTimeFromUnixTime(accountData.getUpdated_at())).append("\n\n");
                    result.append("最后战斗时间 ").append(UnixTimeUtils.getDateTimeFromUnixTime(accountData.getLast_battle_time())).append("\n");
                    result.append("帐号创建时间 ").append(UnixTimeUtils.getDateTimeFromUnixTime(accountData.getCreated_at())).append("\n");
                    result.append("上次登出游戏 ").append(UnixTimeUtils.getDateTimeFromUnixTime(accountData.getLogout_at())).append("\n");
                    result.append("pvp统计数据:\n");
                    result.append("总计战斗 ").append(pvpDto.getBattles()).append("\n");
                    result.append("胜率 ").append(pvpDto.getBattles().equals(BigDecimal.ZERO)?"-":pvpDto.getWins().divide(pvpDto.getBattles(), 4, BigDecimal.ROUND_HALF_UP));
                    result.append("  存活胜率 ").append(pvpDto.getBattles().equals(BigDecimal.ZERO)?"-":pvpDto.getSurvived_wins().divide(pvpDto.getBattles(), 4, BigDecimal.ROUND_HALF_UP)).append("\n");
                    result.append("场均伤害 ").append(pvpDto.getBattles().equals(BigDecimal.ZERO)?"-":pvpDto.getDamage_dealt().divide(pvpDto.getBattles(), 0, BigDecimal.ROUND_HALF_UP));
                    result.append("  场均经验 ").append(pvpDto.getBattles().equals(BigDecimal.ZERO)?"-":pvpDto.getXp().divide(pvpDto.getBattles(), 0, BigDecimal.ROUND_HALF_UP)).append("\n");
                    result.append("场均击沉 ").append(pvpDto.getBattles().equals(BigDecimal.ZERO)?"-":pvpDto.getFrags().divide(pvpDto.getBattles(), 2, BigDecimal.ROUND_HALF_UP));
                    result.append("  场均潜在 ").append(pvpDto.getBattles().equals(BigDecimal.ZERO)?"-":pvpDto.getArt_agro().divide(pvpDto.getBattles(), 0, BigDecimal.ROUND_HALF_UP)).append("\n");
                    result.append("主炮命中 ").append(pvpDto.getMain_battery().getHits().divide(pvpDto.getMain_battery().getShots(),4,BigDecimal.ROUND_HALF_UP));
                    result.append("  鱼雷命中 ").append(pvpDto.getTorpedoes().getHits().divide(pvpDto.getTorpedoes().getShots(),4,BigDecimal.ROUND_HALF_UP)).append("\n\n");

                }
                result.append("共计");
                result.append(getPlayersReturnDto.getMeta().getCount());
                result.append("条记录");
                System.out.println(result.toString());
//                Core.sendGroupMessages(selfQQ, fromGroup, result.toString(), 0);

                String[] strArr = result.toString().split("\n");
                int image_height = 600; // 每张图片的高度
                int line_height = 30; // 每行或者每个文字的高度
                int every_line = image_height / line_height; // 每张图片有多少行文字
                String filepath = ImageUtils.createImage(strArr, new Font("宋体", Font.PLAIN, 20), 600, image_height,  every_line, line_height,fromGroup);

                byte[] bts = StringUtils.readFile(filepath);//读取文件
                String base64Str = Base64.getEncoder().encodeToString(bts);//字节数组转Base64
                base64Str = "[pic:"+ base64Str + "]";//组装图片的格式
                Core.sendGroupMessagesPicText(selfQQ, fromGroup, base64Str,0);

//                Core.sendGroupMessages(selfQQ, fromGroup, "战绩查询结束", 0);
            }catch (Exception e){
            }
        }
    }
}
