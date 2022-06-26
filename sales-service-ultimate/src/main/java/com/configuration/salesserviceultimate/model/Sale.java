package com.configuration.salesserviceultimate.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Sale {
    
    private String name;
    private Integer price;
    private Integer cantity;
    private Integer total;

}
