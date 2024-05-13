package com.AhmedBadawy.SpringBoot.Project.Entities.services;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser; // Import JsonParser from com.google.gson

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import com.AhmedBadawy.SpringBoot.Project.Entities.models.Device;
import com.AhmedBadawy.SpringBoot.Project.Entities.repository.DeviceRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DeviceService {

    @Autowired
    private  DeviceRepository deviceRepository;




    // Get All Devices
    public List<Device> findAll() {
        return deviceRepository.findAll();
    }

    public Device getById(String id) {

            return deviceRepository.findById(id).get();
    }


    @Transactional
    public Device CreatDevice(Device device) {

        return deviceRepository.insert(device);

    }

    // Map string price range to its corresponding integer value
    private int mapPriceRange(String priceRange) {
        switch (priceRange) {
            case "low cost":
                return 0;
            case "medium cost":
                return 1;
            case "high cost":
                return 2;
            case "very high cost":
                return 3;
            default:
                return -1; // Handle unknown price ranges
        }
    }



    @Transactional
    public Device predictAndSavePrice(String deviceId) {
        // Get the device by ID
        Device device = deviceRepository.findById(deviceId)
                .orElseThrow(() -> new RuntimeException("Device not found with ID: " + deviceId));

        // Call Python API to predict price
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "http://localhost:5000/predict";
        String predictedPriceResponse = restTemplate.postForObject(apiUrl, device, String.class);

        // Extract the predicted price range from the response
        String predictedPriceRange = extractPredictedPriceRange(predictedPriceResponse);

        // Map the predicted price range to its corresponding integer value
        int mappedPriceRange = mapPriceRange(predictedPriceRange);
        device.setPrice_range(mappedPriceRange);

        return deviceRepository.save(device);
    }

    // Helper method to extract predicted price range from JSON response
    private String extractPredictedPriceRange(String jsonResponse) {
        // Parse the JSON response to extract predicted price range
        JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
        return jsonObject.get("predicted_price_static").getAsString();
    }


}