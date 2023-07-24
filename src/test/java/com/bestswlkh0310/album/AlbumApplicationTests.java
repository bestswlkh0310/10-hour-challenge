package com.bestswlkh0310.album;

import com.bestswlkh0310.album.domain.login.AuthService;
import com.bestswlkh0310.album.domain.login.LoginRequest;
import com.bestswlkh0310.album.domain.login.SignUpRequest;
import com.bestswlkh0310.album.domain.todo.Todo;
import com.bestswlkh0310.album.domain.todo.TodoRepository;
import com.bestswlkh0310.album.domain.todo.TodoService;
import com.bestswlkh0310.album.domain.user.User;
import com.bestswlkh0310.album.domain.user.UserRepository;
import com.bestswlkh0310.album.web.home.HomeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class AlbumApplicationTests {

    // 조심하세요 테스트 DB를 쓰지 않습니다

    @Autowired
    private AuthService authService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TodoService todoService;

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private HomeController homeController;

    void signUp() {
        userRepository.deleteAllInBatch();
        authService.signUp(new SignUpRequest(
                "a",
                "a",
                "a"
        ));
    }

    void signIn() {
        signUp();
        User user = authService.login(new LoginRequest(
                "a",
                "a"
        ));
        System.out.println(user.toString());


    }

    void registerTodo() {
        todoRepository.deleteAllInBatch();

        Todo todo = todoService.registerTodo(new Todo(
                "ad",
                "asdsa",
                LocalDate.now()
        ));
        System.out.println(todo.toString());
    }

    void updateTodoChecked() {
        todoService.updateTodoChecked(4L, false);
        Todo todo = todoRepository.findById(4L).orElse(null);
        System.out.println(todo.toString());

    }

    void saveTodo() {
        todoService.saveTodo(new Todo(
                "asd",
                "asda",
                LocalDate.now()
        ));
    }
}
