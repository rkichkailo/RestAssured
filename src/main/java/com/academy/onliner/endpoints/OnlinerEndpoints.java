package com.academy.Ruslana_Kichkailo.endpoints;

import com.academy.Ruslana_Kichkailo.framework.PropertiesReader;

public class OnlinerEndpoints {
    public static String getSearchProductEndPoint() {
        return PropertiesReader.getEndpointProperty("products");
    }
}
