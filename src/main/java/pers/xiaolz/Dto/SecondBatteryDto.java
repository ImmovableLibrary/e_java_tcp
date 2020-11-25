package pers.xiaolz.Dto;

/**
 * File: SecondBatteryDto
 * Description:副武器相关记录
 * Date: 2020-11-17 17:54
 *
 * @Author: 毛豪峰
 */
public class SecondBatteryDto {
    /** 单次战斗中最多副炮击沉 */
    private int max_frags_battle;
    /** 总击沉数 */
    private long frags;
    /** 总命中数 */
    private long hits;
    /** 单次战斗中最多副炮击沉的船的id */
    private long max_frags_ship_id;
    /** 总射击数 */
    private long shots;

    public int getMax_frags_battle() {
        return max_frags_battle;
    }

    public void setMax_frags_battle(int max_frags_battle) {
        this.max_frags_battle = max_frags_battle;
    }

    public long getFrags() {
        return frags;
    }

    public void setFrags(long frags) {
        this.frags = frags;
    }

    public long getHits() {
        return hits;
    }

    public void setHits(long hits) {
        this.hits = hits;
    }

    public long getMax_frags_ship_id() {
        return max_frags_ship_id;
    }

    public void setMax_frags_ship_id(long max_frags_ship_id) {
        this.max_frags_ship_id = max_frags_ship_id;
    }

    public long getShots() {
        return shots;
    }

    public void setShots(long shots) {
        this.shots = shots;
    }
}
