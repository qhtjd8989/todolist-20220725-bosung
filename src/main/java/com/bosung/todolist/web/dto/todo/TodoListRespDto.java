package com.bosung.todolist.web.dto.todo;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TodoListRespDto {
	private int todoCode;
	private String todo;
	private boolean todoComplete;
	private boolean importance;
	private int totalCount;
	private int incompleteCount;
	private LocalDateTime create_date;
	private LocalDateTime update_date;
}
