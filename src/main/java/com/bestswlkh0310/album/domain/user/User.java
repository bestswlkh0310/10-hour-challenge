package com.bestswlkh0310.album.domain.user;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long idx;

    private String name;

    private String id;

    private String pw;

    @Enumerated(EnumType.STRING)
    private Role role;
}
