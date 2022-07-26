package com.bosung.todolist.service.todo;

import java.util.List;

import com.bosung.todolist.web.dto.todo.CreateTodoReqDto;
import com.bosung.todolist.web.dto.todo.TodoListRespDto;

public interface TodoService {
	//추가
	public boolean createTodo(CreateTodoReqDto createTodoReqDto) throws Exception; 
	//수정
	//삭제
	//조회
	public List<TodoListRespDto> getTodoList(int page, int contentCount) throws Exception;
}
