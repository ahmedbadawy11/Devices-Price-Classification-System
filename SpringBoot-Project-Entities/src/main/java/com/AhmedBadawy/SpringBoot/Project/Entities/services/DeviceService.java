package com.AhmedBadawy.SpringBoot.Project.Entities.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.AhmedBadawy.SpringBoot.Project.Entities.models.Device;
import com.AhmedBadawy.SpringBoot.Project.Entities.repository.DeviceRepository;
import java.util.List;

@Service
public class DeviceService {
    private final DeviceRepository deviceRepository;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Transactional
    public Device addDevice(Device device) {
        return deviceRepository.save(device);
    }

    public Device getDeviceById(Long id) {
        return deviceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Device not found with ID: " + id));
    }



    @Transactional
    public void addAllDevices(List<Device> devices) {
        deviceRepository.saveAll(devices);
    }

    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }


    @Transactional
    public Device updateDevice(Device device) {
        return deviceRepository.save(device);
    }
    // Other methods as needed
}