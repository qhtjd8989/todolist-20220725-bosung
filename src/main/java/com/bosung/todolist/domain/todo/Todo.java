package com.bosung.todolist.domain.todo;

import java.time.LocalDateTime;

import com.bosung.todolist.web.dto.todo.TodoListRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Todo {
//	Entity 클래스
	private int todo_code;
	private String todo_content;
	private int todo_complete;
	private int importance_flag;
	private int total_count;
	private LocalDateTime create_date;
	private LocalDateTime update_date;
	
	public TodoListRespDto toListDto() {
		return TodoListRespDto.builder()
				.todoCode(todo_code)
				.todo(todo_content)
				.todoComplete(todo_complete)
				.importance(importance_flag == 1)
				.totalCount(total_count)
				.create_date(create_date)
				.update_date(update_date)
				.build();
	}
	
}
