package com.bestswlkh0310.album.domain.todo;

import com.bestswlkh0310.album.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String title;

    @Column(columnDefinition="TEXT")
    private String content;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate deadTime;

    private LocalDate createdTime;

    private boolean done;

    @ManyToOne
    @JoinColumn(name = "user_idx", nullable = false)
    private User user;

    @Column(name = "user_idx")
    private Long userIdx;

    public Todo(String title, String content, LocalDate deadTime) {
        this.title = title;
        this.content = content;
        this.deadTime = deadTime;
        this.createdTime = LocalDate.now();
    }
}