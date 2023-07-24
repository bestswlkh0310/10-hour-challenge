package com.bestswlkh0310.album.web.home;

import com.bestswlkh0310.album.domain.todo.Todo;
import com.bestswlkh0310.album.domain.todo.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeController {

    private final TodoService todoService;

    @GetMapping
    public String getHome(Model model) {

        List<Todo> todos = todoService.getTodos();
        for (Todo todo: todos) {
            System.out.println(todo.toString());
        }
        model.addAttribute("req", new Todo());
        model.addAttribute("todos", todos);

        return "home/home";
    }

    @PostMapping("/register-todo")
    public String registerTodo(@ModelAttribute("req") Todo todo) {
        System.out.println(todo.toString());
        todoService.registerTodo(todo);
        return "redirect:/home";
    }

    @PostMapping("/update-todo-checked/{idx}")
    public String updateTodoCheck(
            @PathVariable("idx") Long idx,
            @RequestParam("checked") Boolean checked
    ) {
        todoService.updateTodoChecked(idx, checked);
        return "redirect:/home";
    }

    @PostMapping("/delete-all")
    public void deleteAll() {
        todoService.deleteAll();
    }

    @PostMapping("/save-todo")
    public String saveTodo(@RequestBody Todo todo) {
        System.out.println(todo);
        todoService.saveTodo(todo);
        return "success";
    }
}