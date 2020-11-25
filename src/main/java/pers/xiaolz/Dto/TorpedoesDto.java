package pers.xiaolz.Dto;

import java.math.BigDecimal;

/**
 * File: TorpedoesDto
 * Description:鱼雷相关记录
 * Date: 2020-11-17 17:56
 *
 * @Author: 毛豪峰
 */
public class TorpedoesDto {
    /** 单次战斗中最多鱼雷击沉 */
    private int max_frags_battle;
    /** 总击沉数 */
    private BigDecimal frags;
    /** 总命中数 */
    private BigDecimal hits;
    /** 单次战斗中最多鱼雷击沉的船的id */
    private String max_frags_ship_id;
    /** 总射击数 */
    private BigDecimal shots;

    public int getMax_frags_battle() {
        return max_frags_battle;
    }

    public void setMax_frags_battle(int max_frags_battle) {
        this.max_frags_battle = max_frags_battle;
    }

    public BigDecimal getFrags() {
        return frags;
    }

    public void setFrags(BigDecimal frags) {
        this.frags = frags;
    }

    public BigDecimal getHits() {
        return hits;
    }

    public void setHits(BigDecimal hits) {
        this.hits = hits;
    }

    public String getMax_frags_ship_id() {
        return max_frags_ship_id;
    }

    public void setMax_frags_ship_id(String max_frags_ship_id) {
        this.max_frags_ship_id = max_frags_ship_id;
    }

    public BigDecimal getShots() {
        return shots;
    }

    public void setShots(BigDecimal shots) {
        this.shots = shots;
    }
}
