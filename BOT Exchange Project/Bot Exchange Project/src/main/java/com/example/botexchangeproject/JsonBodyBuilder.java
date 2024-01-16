package com.example.botexchangeproject;

import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

public class JsonBodyBuilder {

    public static String placeBetsJson() throws JsonIOException {
        JsonObject jSONObject = new JsonObject();
        JsonArray instructionsArray = new JsonArray();
        JsonObject instructionsObject = new JsonObject();
        JsonObject filterObjectLimitOrder = new JsonObject();

        jSONObject.addProperty("marketId", "1.182226323");
        jSONObject.add("instructions", instructionsArray);

        instructionsObject.addProperty("selectionId", "4708352");
        instructionsObject.addProperty("handicap", "0.5");
        instructionsObject.addProperty("side", "LAY");
        instructionsObject.addProperty("orderType", "LIMIT");
        instructionsObject.add("limitOrder", filterObjectLimitOrder);

        instructionsArray.add(instructionsObject);

        filterObjectLimitOrder.addProperty("size", "0.50");
        filterObjectLimitOrder.addProperty("price", "3");
        filterObjectLimitOrder.addProperty("persistenceType", "LAPSE");

        //System.out.println(filterObject);

        return jSONObject.toString();



    }

}
