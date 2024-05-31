package com.fullsecurity.fullsecurity.payload.request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class SignupRequest {
    private String username;
    private String email;
    private String password;
    private Set<String> role;
}
