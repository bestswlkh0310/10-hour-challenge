package com.bestswlkh0310.album.domain.todo;

import java.util.List;

public interface TodoService {
    public Todo registerTodo(Todo todo);

    public List<Todo> getTodos();

    public void updateTodoChecked(Long idx, Boolean checked);

    public void deleteAll();

    public void saveTodo(Todo todo);
}
