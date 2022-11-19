package com.academy.onliner.rest_api.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Product {
    private int id;
    private String key;
    private String name;
    private String full_name;
}
