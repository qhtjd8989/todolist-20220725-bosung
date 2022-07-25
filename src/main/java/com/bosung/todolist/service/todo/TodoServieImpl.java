package com.bosung.todolist.service.todo;

import org.springframework.stereotype.Service;

import com.bosung.todolist.domain.todo.Todo;
import com.bosung.todolist.domain.todo.TodoRepository;
import com.bosung.todolist.web.dto.todo.CreateTodoReqDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoServieImpl implements TodoService {
	
	private final TodoRepository todoRepository;

	@Override
	public boolean createTodo(CreateTodoReqDto createTodoReqDto) throws Exception {
		Todo todoEntity = createTodoReqDto.toEntity();
		return todoRepository.save(todoEntity) > 0;
	}

}
