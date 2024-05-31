package com.fullsecurity.fullsecurity.dto;

import lombok.Data;

@Data
public class RevenueTypeDto {

    private Long id;

    private String name;

    private Boolean status = true;

    private String icon;
}
