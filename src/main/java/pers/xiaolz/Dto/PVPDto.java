package pers.xiaolz.Dto;

import java.math.BigDecimal;

/**
 * File: PVPDto
 * Description:
 * Date: 2020-11-17 17:04
 *
 * @Author: 毛豪峰
 */
public class PVPDto {
    /** 总计战斗数 */
    private BigDecimal battles;
    /** 胜利数 */
    private BigDecimal wins;
    /** 失败数 */
    private BigDecimal losses;
    /** 平局数 */
    private BigDecimal draws;
    /** 存活的战斗数 */
    private BigDecimal survived_battles;
    /** 存活胜利数 */
    private BigDecimal survived_wins;

    /** 总计伤害 */
    private BigDecimal damage_dealt;
    /** 最高伤害 */
    private BigDecimal max_damage_dealt;
    /** 最高伤害的船的id */
    private String max_damage_dealt_ship_id;

    /** 总计经验 */
    private BigDecimal xp;
    /** 最高经验 */
    private BigDecimal max_xp;
    /** 最高经验的船的id */
    private String max_xp_ship_id;

    /** 总计击沉 */
    private BigDecimal frags;
    /** 最多击沉 */
    private BigDecimal max_frags_battle;
    /** 最多击沉的船的id */
    private String max_frags_ship_id;

    /** 总计潜在伤害 */
    private BigDecimal art_agro;
    /** 总计鱼雷潜在伤害 */
    private BigDecimal torpedo_agro;
    /** 最高潜在伤害 */
    private BigDecimal max_total_agro;
    /** 最高潜在的船的id */
    private String max_total_agro_ship_id;

    /** 总计侦查伤害 */
    private BigDecimal damage_scouting;
    /** 最高侦查伤害 */
    private BigDecimal max_damage_scouting;
    /** 最高侦查伤害的船的id */
    private String max_scouting_damage_ship_id;

    /** 总计飞机击落 */
    private BigDecimal planes_killed;
    /** 最多飞机击落 */
    private BigDecimal max_planes_killed;
    /** 最多飞机击落的船的id */
    private String max_planes_killed_ship_id;

    /** 总计点亮 */
    private BigDecimal ships_spotted;
    /** 最多点亮 */
    private BigDecimal max_ships_spotted;
    /** 最多点亮的船的id */
    private String max_ships_spotted_ship_id;

    //意义不明统计
    /** 总计占领点数 */
    private long control_captured_points;
    /** 总计防御点数 */
    private long dropped_capture_points;
    /**  */
    private long capture_points;
    /**  */
    private long team_capture_points;
    /** 防御基地点数 */
    private long control_dropped_points;
    /**  */
    private long team_dropped_capture_points;

    //堡垒模式专属统计
    /** 总计对建筑造成的伤害 */
    private long damage_to_buildings;
    /** 最高对建筑造成的伤害 */
    private long max_damage_dealt_to_buildings;
    /** 对建筑造成了最多伤害的船的id */
    private long max_damage_dealt_to_buildings_ship_id;
    /** 总计压制据点数 */
    private long suppressions_count;
    /** 最多压制据点数 */
    private long max_suppressions_count;
    /** 最多压制据点的船的id */
    private long max_suppressions_ship_id;



    private MainBatteryDto main_battery;
    private SecondBatteryDto second_battery;
    private TorpedoesDto torpedoes;
    private Aircraft aircraft;
    private Ramming ramming;


    /** 0.5.10以后的战斗数 */
    private long battles_since_510;
    /** 0.5.12以后的战斗数 */
    private long battles_since_512;

    public BigDecimal getBattles() {
        return battles;
    }

    public void setBattles(BigDecimal battles) {
        this.battles = battles;
    }

    public BigDecimal getWins() {
        return wins;
    }

    public void setWins(BigDecimal wins) {
        this.wins = wins;
    }

    public BigDecimal getLosses() {
        return losses;
    }

    public void setLosses(BigDecimal losses) {
        this.losses = losses;
    }

    public BigDecimal getDraws() {
        return draws;
    }

    public void setDraws(BigDecimal draws) {
        this.draws = draws;
    }

    public BigDecimal getSurvived_battles() {
        return survived_battles;
    }

    public void setSurvived_battles(BigDecimal survived_battles) {
        this.survived_battles = survived_battles;
    }

    public BigDecimal getSurvived_wins() {
        return survived_wins;
    }

    public void setSurvived_wins(BigDecimal survived_wins) {
        this.survived_wins = survived_wins;
    }

    public BigDecimal getDamage_dealt() {
        return damage_dealt;
    }

    public void setDamage_dealt(BigDecimal damage_dealt) {
        this.damage_dealt = damage_dealt;
    }

    public BigDecimal getMax_damage_dealt() {
        return max_damage_dealt;
    }

    public void setMax_damage_dealt(BigDecimal max_damage_dealt) {
        this.max_damage_dealt = max_damage_dealt;
    }

    public String getMax_damage_dealt_ship_id() {
        return max_damage_dealt_ship_id;
    }

    public void setMax_damage_dealt_ship_id(String max_damage_dealt_ship_id) {
        this.max_damage_dealt_ship_id = max_damage_dealt_ship_id;
    }

    public BigDecimal getXp() {
        return xp;
    }

    public void setXp(BigDecimal xp) {
        this.xp = xp;
    }

    public BigDecimal getMax_xp() {
        return max_xp;
    }

    public void setMax_xp(BigDecimal max_xp) {
        this.max_xp = max_xp;
    }

    public String getMax_xp_ship_id() {
        return max_xp_ship_id;
    }

    public void setMax_xp_ship_id(String max_xp_ship_id) {
        this.max_xp_ship_id = max_xp_ship_id;
    }

    public BigDecimal getFrags() {
        return frags;
    }

    public void setFrags(BigDecimal frags) {
        this.frags = frags;
    }

    public BigDecimal getMax_frags_battle() {
        return max_frags_battle;
    }

    public void setMax_frags_battle(BigDecimal max_frags_battle) {
        this.max_frags_battle = max_frags_battle;
    }

    public String getMax_frags_ship_id() {
        return max_frags_ship_id;
    }

    public void setMax_frags_ship_id(String max_frags_ship_id) {
        this.max_frags_ship_id = max_frags_ship_id;
    }

    public BigDecimal getArt_agro() {
        return art_agro;
    }

    public void setArt_agro(BigDecimal art_agro) {
        this.art_agro = art_agro;
    }

    public BigDecimal getTorpedo_agro() {
        return torpedo_agro;
    }

    public void setTorpedo_agro(BigDecimal torpedo_agro) {
        this.torpedo_agro = torpedo_agro;
    }

    public BigDecimal getMax_total_agro() {
        return max_total_agro;
    }

    public void setMax_total_agro(BigDecimal max_total_agro) {
        this.max_total_agro = max_total_agro;
    }

    public String getMax_total_agro_ship_id() {
        return max_total_agro_ship_id;
    }

    public void setMax_total_agro_ship_id(String max_total_agro_ship_id) {
        this.max_total_agro_ship_id = max_total_agro_ship_id;
    }

    public BigDecimal getDamage_scouting() {
        return damage_scouting;
    }

    public void setDamage_scouting(BigDecimal damage_scouting) {
        this.damage_scouting = damage_scouting;
    }

    public BigDecimal getMax_damage_scouting() {
        return max_damage_scouting;
    }

    public void setMax_damage_scouting(BigDecimal max_damage_scouting) {
        this.max_damage_scouting = max_damage_scouting;
    }

    public String getMax_scouting_damage_ship_id() {
        return max_scouting_damage_ship_id;
    }

    public void setMax_scouting_damage_ship_id(String max_scouting_damage_ship_id) {
        this.max_scouting_damage_ship_id = max_scouting_damage_ship_id;
    }

    public BigDecimal getPlanes_killed() {
        return planes_killed;
    }

    public void setPlanes_killed(BigDecimal planes_killed) {
        this.planes_killed = planes_killed;
    }

    public BigDecimal getMax_planes_killed() {
        return max_planes_killed;
    }

    public void setMax_planes_killed(BigDecimal max_planes_killed) {
        this.max_planes_killed = max_planes_killed;
    }

    public String getMax_planes_killed_ship_id() {
        return max_planes_killed_ship_id;
    }

    public void setMax_planes_killed_ship_id(String max_planes_killed_ship_id) {
        this.max_planes_killed_ship_id = max_planes_killed_ship_id;
    }

    public BigDecimal getShips_spotted() {
        return ships_spotted;
    }

    public void setShips_spotted(BigDecimal ships_spotted) {
        this.ships_spotted = ships_spotted;
    }

    public BigDecimal getMax_ships_spotted() {
        return max_ships_spotted;
    }

    public void setMax_ships_spotted(BigDecimal max_ships_spotted) {
        this.max_ships_spotted = max_ships_spotted;
    }

    public String getMax_ships_spotted_ship_id() {
        return max_ships_spotted_ship_id;
    }

    public void setMax_ships_spotted_ship_id(String max_ships_spotted_ship_id) {
        this.max_ships_spotted_ship_id = max_ships_spotted_ship_id;
    }

    public long getControl_captured_points() {
        return control_captured_points;
    }

    public void setControl_captured_points(long control_captured_points) {
        this.control_captured_points = control_captured_points;
    }

    public long getDropped_capture_points() {
        return dropped_capture_points;
    }

    public void setDropped_capture_points(long dropped_capture_points) {
        this.dropped_capture_points = dropped_capture_points;
    }

    public long getCapture_points() {
        return capture_points;
    }

    public void setCapture_points(long capture_points) {
        this.capture_points = capture_points;
    }

    public long getTeam_capture_points() {
        return team_capture_points;
    }

    public void setTeam_capture_points(long team_capture_points) {
        this.team_capture_points = team_capture_points;
    }

    public long getControl_dropped_points() {
        return control_dropped_points;
    }

    public void setControl_dropped_points(long control_dropped_points) {
        this.control_dropped_points = control_dropped_points;
    }

    public long getTeam_dropped_capture_points() {
        return team_dropped_capture_points;
    }

    public void setTeam_dropped_capture_points(long team_dropped_capture_points) {
        this.team_dropped_capture_points = team_dropped_capture_points;
    }

    public long getDamage_to_buildings() {
        return damage_to_buildings;
    }

    public void setDamage_to_buildings(long damage_to_buildings) {
        this.damage_to_buildings = damage_to_buildings;
    }

    public long getMax_damage_dealt_to_buildings() {
        return max_damage_dealt_to_buildings;
    }

    public void setMax_damage_dealt_to_buildings(long max_damage_dealt_to_buildings) {
        this.max_damage_dealt_to_buildings = max_damage_dealt_to_buildings;
    }

    public long getMax_damage_dealt_to_buildings_ship_id() {
        return max_damage_dealt_to_buildings_ship_id;
    }

    public void setMax_damage_dealt_to_buildings_ship_id(long max_damage_dealt_to_buildings_ship_id) {
        this.max_damage_dealt_to_buildings_ship_id = max_damage_dealt_to_buildings_ship_id;
    }

    public long getSuppressions_count() {
        return suppressions_count;
    }

    public void setSuppressions_count(long suppressions_count) {
        this.suppressions_count = suppressions_count;
    }

    public long getMax_suppressions_count() {
        return max_suppressions_count;
    }

    public void setMax_suppressions_count(long max_suppressions_count) {
        this.max_suppressions_count = max_suppressions_count;
    }

    public long getMax_suppressions_ship_id() {
        return max_suppressions_ship_id;
    }

    public void setMax_suppressions_ship_id(long max_suppressions_ship_id) {
        this.max_suppressions_ship_id = max_suppressions_ship_id;
    }

    public MainBatteryDto getMain_battery() {
        return main_battery;
    }

    public long getBattles_since_510() {
        return battles_since_510;
    }

    public void setBattles_since_510(long battles_since_510) {
        this.battles_since_510 = battles_since_510;
    }

    public long getBattles_since_512() {
        return battles_since_512;
    }

    public void setBattles_since_512(long battles_since_512) {
        this.battles_since_512 = battles_since_512;
    }

    public void setMain_battery(MainBatteryDto main_battery) {
        this.main_battery = main_battery;
    }

    public SecondBatteryDto getSecond_battery() {
        return second_battery;
    }

    public void setSecond_battery(SecondBatteryDto second_battery) {
        this.second_battery = second_battery;
    }

    public TorpedoesDto getTorpedoes() {
        return torpedoes;
    }

    public void setTorpedoes(TorpedoesDto torpedoes) {
        this.torpedoes = torpedoes;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public Ramming getRamming() {
        return ramming;
    }

    public void setRamming(Ramming ramming) {
        this.ramming = ramming;
    }
}
