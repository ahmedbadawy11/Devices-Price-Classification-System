package com.AhmedBadawy.SpringBoot.Project.Entities.Loading;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import com.AhmedBadawy.SpringBoot.Project.Entities.models.Device;
import com.AhmedBadawy.SpringBoot.Project.Entities.services.DeviceService;

@Component
public class CSVDataLoader {
    private final DeviceService deviceService;

    @Autowired
    public CSVDataLoader(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @PostConstruct
    public void loadDevicesFromCSV() {
        try {
            InputStream inputStream = getClass().getResourceAsStream("test - test.csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            List<Device> devices = reader.lines()
                    .skip(1) // Skip header line
                    .map(this::mapToDevice)
                    .collect(Collectors.toList());

            deviceService.addAllDevices(devices);
            System.out.println("Devices loaded from CSV and saved to database successfully.");
        } catch (Exception e) {
            System.err.println("Error loading devices from CSV: " + e.getMessage());
        }
    }

    private Device mapToDevice(String line) {
        String[] parts = line.split(",");
        // Assuming CSV columns are in the same order as Device fields
        Device device = new Device();
        device.setBatteryPower(Integer.parseInt(parts[1]));
        device.setHasBluetooth(Boolean.parseBoolean(parts[2]));
        // Map other fields accordingly
        device.setPriceRange(Integer.parseInt(parts[20]));
        return device;
    }
}