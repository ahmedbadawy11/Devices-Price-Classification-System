from flask import Flask, request, jsonify
import pickle
import numpy as np
import pandas as pd
# Load the saved static and dynamic pipelines
with open("pipeline_pickle", "rb") as file:
    saved_model_static = pickle.load(file)



# Extract components from the static pipeline
selected_features_static = saved_model_static.named_steps['selected_features']
scaler_static = saved_model_static.named_steps['Scaler']
static_model = saved_model_static.named_steps['classifier']


# Create Flask app
app = Flask(__name__)

@app.route('/predict', methods=['POST'])
def predict():
    # Get the JSON data from the request
    data = request.get_json(force=True)
    print (data)
    df = pd.DataFrame(data, index=[0])
    # Extract the features from the JSON data and select the relevant features
    # print (df)
    new_X_train = df.loc[:, selected_features_static]
    print (new_X_train)
    # features = np.array([data[str(i)] for i in selected_features_static]).reshape(1, -1)
    # print(features)

    
    


    # Scale the selected features using the static pipeline
    feature_names = scaler_static.get_feature_names_out()
    new_X_train.loc[:, feature_names.tolist()] = scaler_static.transform(new_X_train.loc[:, feature_names.tolist()])
    print ("////////////")
    print (new_X_train)
    # scaled_features = scaler_static.transform(features)

    # Make prediction using the static model
    prediction_static = static_model.predict(new_X_train)

    # Convert prediction to human-readable format (e.g., low, medium, high, very high)
    price_range_mapping = {0: 'low cost', 1: 'medium cost', 2: 'high cost', 3: 'very high cost'}
    predicted_price_static = price_range_mapping[prediction_static[0]]

    # Return the predicted price as JSON response
    return jsonify({'predicted_price_static': predicted_price_static})

if __name__ == '__main__':
    app.run(port=5000, debug=True)