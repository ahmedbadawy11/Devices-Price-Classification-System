package com.AhmedBadawy.SpringBoot.Project.Entities.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.AhmedBadawy.SpringBoot.Project.Entities.models.Device;
import com.AhmedBadawy.SpringBoot.Project.Entities.services.DeviceService;
import java.util.List;



@RestController
@RequestMapping("/api/predict")
public class PredictController {

    @Autowired //do injection
    private DeviceService deviceService;

    // Predict the price for a device and save the result in the device entity
    @PostMapping("/{deviceId}")
    public ResponseEntity<Device> predictAndSavePrice(@PathVariable String deviceId) {
        Device updatedDevice = deviceService.predictAndSavePrice(deviceId);
        return ResponseEntity.ok(updatedDevice);
    }

}
