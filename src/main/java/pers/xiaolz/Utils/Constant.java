package pers.xiaolz.Utils;

/**
 * File: Constant
 * Description:常量类
 * Date: 2020-04-03 10:13
 *
 * @Author: 毛豪峰
 */
public class Constant {

    public static final String SEARCH_NOT_SPECIFIED = "402";
    public static final String NOT_ENOUGH_SEARCH_LENGTH = "407";
    public static final String SEARCH_LIST_LIMIT_EXCEEDED = "407";


    public static final class wargamingUrl{

        public static final String application_id = "3996cf3b41a44b597315e9d771ad022e";
        /**
         * 获取帐号相关信息，url中间需要拼接服务器代码eu、ru、na、asia
         **/
        public static final String GET_PLAYERS_START = "http://api.worldofwarships.";
        public static final String GET_PLAYERS_END = "/wows/account/list/";

        /**
         * 获取个人数据，url中间需要拼接服务器代码eu、ru、na、asia
         */
        public static final String GET_PLAYER_PERSONAL_DATA_START = "https://api.worldofwarships.";
        public static final String GET_PLAYER_PERSONAL_DATA_END = "/wows/account/info/";

    }

}
