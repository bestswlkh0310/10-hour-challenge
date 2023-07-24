package com.bestswlkh0310.album.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername member.username = {}" + username);
        Optional<User> findMember = userRepository.findById(username);
        if (findMember.isEmpty()) throw new UsernameNotFoundException("존재하지 않는 username 입니다.");
        System.out.println(findMember.get());

        return new UserDetail(findMember.get());
    }
}
