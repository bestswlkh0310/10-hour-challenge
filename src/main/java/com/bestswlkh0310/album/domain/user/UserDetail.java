package com.bestswlkh0310.album.domain.user;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

@Getter
@Setter
public class UserDetail extends User {

    private com.bestswlkh0310.album.domain.user.User user;
    public UserDetail(com.bestswlkh0310.album.domain.user.User user) {
        super(user.getId(), user.getPw(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user = user;
    }
}