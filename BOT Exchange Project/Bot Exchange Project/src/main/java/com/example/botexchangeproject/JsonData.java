package com.example.botexchangeproject;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Map;

public class JsonData {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String eventTypeIds;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String competitionIds;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String eventIds;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String marketTypeCodes;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String size;

    private List<String> filter;


    /*public JsonData(String eventTypeIds, String eventIds, String competitionIds, String marketTypeCodes, Map<String, Object> filter) {
        this.eventTypeIds = eventTypeIds;
        this.eventIds = eventIds;
        this.competitionIds = competitionIds;
        this.marketTypeCodes = marketTypeCodes;
        this.filter = filter;
    }*/

    public JsonData() {

    }

    public String getEventTypeIds() {
        return eventTypeIds;
    }

    public void setEventTypeIds(String eventTypeIds) {
        this.eventTypeIds = eventTypeIds;
    }

    public String getCompetitionIds() {
        return competitionIds;
    }

    public void setCompetitionIds(String competitionIds) {
        this.competitionIds = competitionIds;
    }

    public String getEventIds() {
        return eventIds;
    }

    public void setEventIds(String eventIds) {
        this.eventIds = eventIds;
    }

    public String getMarketTypeCodes() {
        return marketTypeCodes;
    }

    public void setMarketTypeCodes(String marketTypeCodes) {
        this.marketTypeCodes = marketTypeCodes;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public List<String> getFilter() {
        return filter;
    }

    public void setFilter(List<String> filter) {
        this.filter = filter;
    }
}

