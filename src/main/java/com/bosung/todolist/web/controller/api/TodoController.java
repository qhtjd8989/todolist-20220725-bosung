package com.bosung.todolist.web.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bosung.todolist.service.todo.TodoService;
import com.bosung.todolist.web.dto.CMRespDto;
import com.bosung.todolist.web.dto.todo.CreateTodoReqDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/todolist")
@RequiredArgsConstructor
public class TodoController {
	
	private final TodoService todoService;
	
	@PostMapping("/todo")
	public ResponseEntity<?> addContent(@RequestBody CreateTodoReqDto createTodoReqDto) {
		try {
			todoService.createTodo(createTodoReqDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "Adding todo failed", createTodoReqDto));
		}
		return ResponseEntity.ok().body(new CMRespDto<>(1, "success", createTodoReqDto));
	}
}
