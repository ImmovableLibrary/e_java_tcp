package pers.xiaolz.Dto;

/**
 * File: Aircraft
 * Description:飞机相关记录
 * Date: 2020-11-17 18:00
 *
 * @Author: 毛豪峰
 */
public class Aircraft {
    /** 单次战斗中最多飞机击沉 */
    private int max_frags_battle;
    /** 总击沉数 */
    private long frags;
    /** 单次战斗中最多飞机击沉的船的id */
    private long max_frags_ship_id;

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

    public long getMax_frags_ship_id() {
        return max_frags_ship_id;
    }

    public void setMax_frags_ship_id(long max_frags_ship_id) {
        this.max_frags_ship_id = max_frags_ship_id;
    }
}

