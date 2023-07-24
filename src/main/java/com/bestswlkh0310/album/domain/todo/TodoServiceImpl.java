package com.bestswlkh0310.album.domain.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{

    private final TodoRepository todoRepository;

    @Override
    public Todo registerTodo(Todo todo) {
        todo.setCreatedTime(LocalDate.now());
        todoRepository.save(todo);
        return todo;
    }

    @Override
    public List<Todo> getTodos() {
        return todoRepository.findAll(Sort.by(Sort.Direction.DESC, "deadTime"));
    }

    @Override
    @Transactional
    public void updateTodoChecked(Long idx, Boolean checked) {
        Todo todo = todoRepository.findById(idx).orElse(null);
        if (todo != null) {
            todo.setDone(checked);
        } else {
            System.out.println("에러");
        }
    }

    @Override
    public void deleteAll() {
        todoRepository.deleteAllInBatch();
    }

    @Override
    public void saveTodo(Todo todo) {
        todoRepository.save(todo);
    }
}
