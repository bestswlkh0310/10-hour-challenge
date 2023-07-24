package com.bestswlkh0310.album.domain.login;

import com.bestswlkh0310.album.domain.user.Role;
import com.bestswlkh0310.album.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest {
    public String name;
    public String id;
    public String pw;

    public User toEntity() {
        return new User(
                null,
                this.getName(),
                this.getId(),
                this.getPw(),
                Role.ROLE_USER
        );
    }
}
