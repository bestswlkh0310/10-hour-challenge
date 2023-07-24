package com.bestswlkh0310.album.domain.login;


import com.bestswlkh0310.album.domain.user.User;

public interface AuthService {
    public User login(LoginRequest loginRequest);

    public void signUp(SignUpRequest signUpRequest);
}