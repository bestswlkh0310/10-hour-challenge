package com.bestswlkh0310.album.domain.login;

import com.bestswlkh0310.album.domain.user.User;
import com.bestswlkh0310.album.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    @Override
    public User login(LoginRequest loginRequest) {
        return userRepository.findById(loginRequest.getId())
                .filter(m -> m.getPw().equals(loginRequest.getPw()))
                .orElse(null);
    }

    @Override
    public void signUp(SignUpRequest signUpRequest) {
        userRepository.save(signUpRequest.toEntity());
    }
}
