package com.AhmedBadawy.SpringBoot.Project.Entities.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.AhmedBadawy.SpringBoot.Project.Entities.models.Device;
import com.AhmedBadawy.SpringBoot.Project.Entities.services.DeviceService;
import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {
    private final DeviceService deviceService;

    @Autowired
    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }


     // Retrieve a list of all devices
    @GetMapping
    public ResponseEntity<List<Device>> getAllDevices() {
        List<Device> devices = deviceService.getAllDevices();
        return ResponseEntity.ok(devices);
    }


    // Retrieve details of a specific device by ID
    @GetMapping("/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable Long id) {
        Device device = deviceService.getDeviceById(id);
        return ResponseEntity.ok(device);
    }

  
    // Add a new device
    @PostMapping
    public ResponseEntity<Device> addDevice(@RequestBody Device device) {
        Device savedDevice = deviceService.addDevice(device);
        return new ResponseEntity<>(savedDevice, HttpStatus.CREATED);
    }
 

     // Predict the price for a device and save the result in the device entity
     @PostMapping("/predict/{deviceId}")
     public ResponseEntity<Device> predictAndSavePrice(@PathVariable Long deviceId) {
         Device device = deviceService.getDeviceById(deviceId);
         // Call Python API to predict price and update device entity
         // Implement your logic here to integrate with Python API
 
         // For demo purposes, let's assume the price prediction is successful
         device.setPriceRange(1); // Set a dummy price range as an example
 
         Device updatedDevice = deviceService.updateDevice(device);
         return ResponseEntity.ok(updatedDevice);
     }

    // Other endpoints as needed
}