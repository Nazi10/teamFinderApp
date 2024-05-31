package com.fullsecurity.fullsecurity.dto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmailConfigurationDto {

    private String email;

    private Boolean status = true;
}
