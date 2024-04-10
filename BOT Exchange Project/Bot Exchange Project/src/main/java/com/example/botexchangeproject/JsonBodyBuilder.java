package com.example.botexchangeproject;

import com.example.botexchangeproject.Models.CurrentOrders;
import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

public class JsonBodyBuilder extends CurrentOrders {

    public static String placeBetsJson() throws JsonIOException {
        JsonObject jSONObject = new JsonObject();
        JsonArray instructionsArray = new JsonArray();
        JsonObject instructionsObject = new JsonObject();
        JsonObject filterObjectLimitOrder = new JsonObject();

        jSONObject.addProperty("marketId", "1.182224857");
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

        return jSONObject.toString();

    }

//    public static String deleteBetJson() {
//
//        JsonObject cancelJsonObject = new JsonObject();
//        JsonObject deleteInstructionObj = new JsonObject();
//        JsonArray deleteInstructionArray = new JsonArray();
//
//
//        //adds marketID and instructions to the main body of JSON
//        cancelJsonObject.addProperty("marketId", "1.182226323");
//        cancelJsonObject.add("instructions", deleteInstructionArray);
//
//        //inserts betID into "instructions"
//        deleteInstructionObj.addProperty("betId", "309624622026");
//
//        //inserts whole "instructions" into array
//        deleteInstructionArray.add(deleteInstructionObj);
//
//        //System.out.println(jsonObject);
//
//        return cancelJsonObject.toString();
//
//    }

}
