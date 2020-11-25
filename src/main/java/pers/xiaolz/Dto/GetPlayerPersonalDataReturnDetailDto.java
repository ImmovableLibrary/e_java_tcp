package pers.xiaolz.Dto;

/**
 * File: GetPlayerPersonalDataReturnDetailDto
 * Description:
 * Date: 2020-11-17 15:29
 *
 * @Author: 毛豪峰
 */
public class GetPlayerPersonalDataReturnDetailDto {
    /** 账户id */
    private String account_id;

    /** 账户名 */
    private String nickname;

    /** 最后一次战斗时间 */
    private String last_battle_time;

    /** 帐号创建时间 */
    private String created_at;

    /** 数据更新时间 */
    private String updated_at;

    /** 数据更新时间 */
    private String stats_updated_at;

    /** 上次登出游戏 */
    private String logout_at;

    /** 帐号等级 */
    private int leveling_tier;

    /** 帐号经验 */
    private int leveling_points;

    /** 是否隐藏战绩 */
    private boolean hidden_profile;

//    private long private;
//    /** 业力 */
//    private long karma;

    /** 统计数据 */
    private StatisticsDto statistics;

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getLast_battle_time() {
        return last_battle_time;
    }

    public void setLast_battle_time(String last_battle_time) {
        this.last_battle_time = last_battle_time;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getStats_updated_at() {
        return stats_updated_at;
    }

    public void setStats_updated_at(String stats_updated_at) {
        this.stats_updated_at = stats_updated_at;
    }

    public String getLogout_at() {
        return logout_at;
    }

    public void setLogout_at(String logout_at) {
        this.logout_at = logout_at;
    }

    public int getLeveling_tier() {
        return leveling_tier;
    }

    public void setLeveling_tier(int leveling_tier) {
        this.leveling_tier = leveling_tier;
    }

    public int getLeveling_points() {
        return leveling_points;
    }

    public void setLeveling_points(int leveling_points) {
        this.leveling_points = leveling_points;
    }

    public boolean isHidden_profile() {
        return hidden_profile;
    }

    public void setHidden_profile(boolean hidden_profile) {
        this.hidden_profile = hidden_profile;
    }

    public StatisticsDto getStatistics() {
        return statistics;
    }

    public void setStatistics(StatisticsDto statistics) {
        this.statistics = statistics;
    }
}
