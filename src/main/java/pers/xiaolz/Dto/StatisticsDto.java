package pers.xiaolz.Dto;

/**
 * File: StatisticsDto
 * Description:
 * Date: 2020-11-17 17:02
 *
 * @Author: 毛豪峰
 */
public class StatisticsDto {
    /** 总航行里程 */
    private long distance;

    /** 总战斗数 */
    private long battles;

    /** pvp战斗数据 */
    private PVPDto pvp;

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    public long getBattles() {
        return battles;
    }

    public void setBattles(long battles) {
        this.battles = battles;
    }

    public PVPDto getPvp() {
        return pvp;
    }

    public void setPvp(PVPDto pvp) {
        this.pvp = pvp;
    }
}
