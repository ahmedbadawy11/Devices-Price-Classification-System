package com.AhmedBadawy.SpringBoot.Project.Entities.models;

import javax.persistence.*;

@Entity
@Table(name = "devices")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "battery_power")
    private int batteryPower;

    @Column(name="blue")
    private boolean blue;

    @Column(name = "clock_speed")
    private double clockSpeed;

    @Column(name = "dual_sim")
    private boolean dualSim;

    @Column(name = "fc")
    private int fc;

    @Column(name = "four_g")
    private boolean fourG;

    @Column(name = "int_memory")
    private int intMemory;

    @Column(name = "m_dep")
    private double mobileDepth;

    @Column(name = "mobile_wt")
    private int mobileWeight;

    @Column(name = "n_cores")
    private int nCores;

    @Column(name = "pc")
    private int pc;

    @Column(name = "px_height")
    private int pixelHeight;

    @Column(name = "px_width")
    private int pixelWidth;

    @Column(name = "ram")
    private int ram;

    @Column(name = "sc_h")
    private int screenHeight;

    @Column(name = "sc_w")
    private int screenWidth;

    @Column(name = "talk_time")
    private int talkTime;

    @Column(name = "three_g")
    private boolean threeG;

    @Column(name = "touch_screen")
    private boolean touchScreen;

    @Column(name = "wifi")
    private boolean wifi;

    @Column(name = "price_range")
    private int priceRange;

    // Getters and setters
     // Getters and setters for all fields
     public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(Integer batteryPower) {
        this.batteryPower = batteryPower;
    }

    public Boolean getHasBluetooth() {
        return blue;
    }

    public void setHasBluetooth(Boolean hasBluetooth) {
        this.blue = hasBluetooth;
    }

    // Include getters and setters for other fields
    public Integer getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(Integer priceRange) {
        this.priceRange = priceRange;
    }

}