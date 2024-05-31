package com.fullsecurity.fullsecurity.dto;

import lombok.Data;

@Data
public class ExpenditureTypeDto {

    private Long id;

    private String name;

    private Boolean status = true;

    private String icon;
}
