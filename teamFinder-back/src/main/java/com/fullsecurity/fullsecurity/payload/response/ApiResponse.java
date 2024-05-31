package com.fullsecurity.fullsecurity.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ApiResponse {
    private HttpStatus httpStatus;
    private String message;
}
