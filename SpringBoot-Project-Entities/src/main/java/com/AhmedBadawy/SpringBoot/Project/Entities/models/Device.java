package com.AhmedBadawy.SpringBoot.Project.Entities.models;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Document (collection = "Devices")
public class Device {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

//    @Column(name = "battery_power")
    private int battery_power ;

//    @Column(name="blue")
    private int blue ;

//    @Column(name = "clock_speed")
    private double clock_speed ;

//    @Column(name = "dual_sim")
    private int dual_sim ;

//    @Column(name = "fc")
    private int fc ;

//    @Column(name = "four_g")
    private int four_g ;

//    @Column(name = "int_memory")
    private int int_memory ;

//    @Column(name = "m_dep")
    private double m_dep ;

//    @Column(name = "mobile_wt")
    private int mobile_wt ;

//    @Column(name = "n_cores")
    private int n_cores ;

//    @Column(name = "pc")
    private int pc ;

//    @Column(name = "px_height")
    private int px_height ;

//    @Column(name = "px_width")
    private int px_width ;

//    @Column(name = "ram")
    private int ram ;

//    @Column(name = "sc_h")
    private int sc_h ;

//    @Column(name = "sc_w")
    private int sc_w ;

//    @Column(name = "talk_time")
    private int talk_time ;

//    @Column(name = "three_g")
    private int three_g ;

//    @Column(name = "touch_screen")
    private int touch_screen ;

//    @Column(name = "wifi")
    private int wifi ;

//    @Column(name = "price_range")
    private int price_range ;

    public Device()
    {

    }
    public Device(String id, int battery_power, int blue, int dual_sim) {
        this.id = id;
        this.battery_power = battery_power;
        this.blue = blue;
        this.dual_sim = dual_sim;
    }




    // Getters and setters
     // Getters and setters for all fields


    public void setId(String id) {
        this.id = id;
    }

    public void setBattery_power(int battery_power) {
        this.battery_power = battery_power;
    }

    public void setClock_speed(double clock_speed) {
        this.clock_speed = clock_speed;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public void setDual_sim(int dual_sim) {
        this.dual_sim = dual_sim;
    }

    public void setFc(int fc) {
        this.fc = fc;
    }

    public void setFour_g(int four_g) {
        this.four_g = four_g;
    }

    public void setInt_memory(int int_memory) {
        this.int_memory = int_memory;
    }

    public void setM_dep(double m_dep) {
        this.m_dep = m_dep;
    }

    public void setMobile_wt(int mobile_wt) {
        this.mobile_wt = mobile_wt;
    }

    public void setN_cores(int n_cores) {
        this.n_cores = n_cores;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public void setPx_height(int px_height) {
        this.px_height = px_height;
    }

    public void setPx_width(int px_width) {
        this.px_width = px_width;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setSc_h(int sc_h) {
        this.sc_h = sc_h;
    }

    public void setSc_w(int sc_w) {
        this.sc_w = sc_w;
    }

    public void setTalk_time(int talk_time) {
        this.talk_time = talk_time;
    }

    public void setTouch_screen(int touch_screen) {
        this.touch_screen = touch_screen;
    }

    public void setThree_g(int three_g) {
        this.three_g = three_g;
    }

    public void setWifi(int wifi) {
        this.wifi = wifi;
    }

    public void setPrice_range(int price_range) {
        this.price_range = price_range;
    }

    // Getter


    public String getId() {
        return id;
    }

    public int getBattery_power() {
        return battery_power;
    }

    public int getBlue() {
        return blue;
    }

    public double getClock_speed() {
        return clock_speed;
    }

    public int getDual_sim() {
        return dual_sim;
    }

    public int getFour_g() {
        return four_g;
    }

    public int getFc() {
        return fc;
    }

    public int getInt_memory() {
        return int_memory;
    }

    public double getM_dep() {
        return m_dep;
    }

    public int getN_cores() {
        return n_cores;
    }

    public int getMobile_wt() {
        return mobile_wt;
    }

    public int getPc() {
        return pc;
    }

    public int getPx_height() {
        return px_height;
    }

    public int getPx_width() {
        return px_width;
    }

    public int getRam() {
        return ram;
    }

    public int getSc_h() {
        return sc_h;
    }

    public int getSc_w() {
        return sc_w;
    }

    public int getTalk_time() {
        return talk_time;
    }

    public int getThree_g() {
        return three_g;
    }

    public int getTouch_screen() {
        return touch_screen;
    }

    public int getWifi() {
        return wifi;
    }

    public int getPrice_range() {
        return price_range;
    }
}