# Running the Devices Price Classification System API

## Introduction
This guide provides instructions on how to run and interact with the Devices Price Classification System API. The API is built using Flask and is designed to predict the price range of mobile devices based on their specifications.

## Prerequisites
Before running the application, ensure that you have the following installed:
- Python (version 3.x)
- Flask
- pickle
- numpy
- pandas
- Postman (optional, for API testing)

## Steps to Run the Application

1. **Clone the Repository**

2. **Run main.py**

## Testing with Postman (Optional)
- Open Postman and create a new request.
- Set the request type to POST and enter the URL http://localhost:5000/predict.
- Set the request headers if required (e.g., Content-Type: application/json).
- Input the device specifications in JSON format in the request body.
- Click on Send to receive the predicted price response.

## Example Request Body (JSON format)
{
  "battery_power": 2000,
  "blue": 1,
  "clock_speed": 2.5,
  "dual_sim": 1,
  "fc": 8,
  "four_g": 1,
  "int_memory": 16,
  "m_dep": 0.5,
  "mobile_wt": 150,
  "n_cores": 4,
  "pc": 12,
  "px_height": 1280,
  "px_width": 720,
  "ram": 4096,
  "sc_h": 15,
  "sc_w": 10,
  "talk_time": 12,
  "three_g": 1,
  "touch_screen": 1,
  "wifi": 1
}
## Example Response
{
  "predicted_price_static": "medium cost"
}


# Device API Documentation Spring Boot

This document provides information about the Device API endpoints and how to test them using Postman.

## Base URL

The base URL for all API endpoints is: `http://localhost:8080/api`

## Endpoints

### 1. Get All Devices

- **URL:** `/devices`
- **Method:** `GET`
- **Description:** Retrieves a list of all devices.
- **Example:** `http://localhost:8080/api/devices`

### 2. Get Device by ID

- **URL:** `/devices/{id}`
- **Method:** `GET`
- **Description:** Retrieves details of a specific device by ID.
- **Example:** `http://localhost:8080/api/devices/66414a85bd4905f66d5c1130`

### 3. Add a New Device

- **URL:** `/devices`
- **Method:** `POST`
- **Description:** Adds a new device to the database.
- **Example Request Body:**
  ```json
  {
    "battery_power": 2000,
    "blue": 1,
    "clock_speed": 2.5,
    "dual_sim": 1,
    "fc": 8,
    "four_g": 1,
    "int_memory": 16,
    "m_dep": 0.5,
    "mobile_wt": 150,
    "n_cores": 4,
    "pc": 12,
    "px_height": 1280,
    "px_width": 720,
    "ram": 4096,
    "sc_h": 15,
    "sc_w": 10,
    "talk_time": 12,
    "three_g": 1,
    "touch_screen": 1,
    "wifi": 1
  }
