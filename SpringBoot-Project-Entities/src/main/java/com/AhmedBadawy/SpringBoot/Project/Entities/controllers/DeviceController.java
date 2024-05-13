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

    @Autowired //do injection
    private DeviceService deviceService;

// Test Spring
    @RequestMapping(value ={"test",""} )
    public  String  Greeting(){

        return "Hello Welcome to  spring";

    }

     // Retrieve a list of all devices
    @GetMapping(value ={"/",""})
    public ResponseEntity<List<Device>> getAllDevices() {

        List<Device> Result=deviceService.findAll();
        return   new ResponseEntity<>(Result,HttpStatus.OK);
    }


    // Retrieve details of a specific device by ID
    @GetMapping("/{id}")
    public ResponseEntity<Device> getDevice_by_ID(@PathVariable String id) {

        Device Result=deviceService.getById(id);

        return new ResponseEntity<>(Result,HttpStatus.OK);
    }

    // Add a new device
    @PostMapping(value ={"","/"})
    public ResponseEntity<Device>  addDevice(@RequestBody Device device) {

        Device add=deviceService.CreatDevice(device);
         return new ResponseEntity<>(add,HttpStatus.CREATED);

    }








}