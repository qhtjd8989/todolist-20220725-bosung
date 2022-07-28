package com.bosung.todolist.service.todo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.bosung.todolist.domain.todo.Todo;
import com.bosung.todolist.domain.todo.TodoRepository;
import com.bosung.todolist.web.dto.todo.CreateTodoReqDto;
import com.bosung.todolist.web.dto.todo.TodoListRespDto;
import com.bosung.todolist.web.dto.todo.UpdateTodoReqDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoServieImpl implements TodoService {
	
	private final TodoRepository todoRepository;

//	---------------------------------------------------------------------------------------------------------
	
	@Override
	public boolean createTodo(CreateTodoReqDto createTodoReqDto) throws Exception {
		Todo todoEntity = createTodoReqDto.toEntity();
		return todoRepository.save(todoEntity) > 0;
//		String content = todoEntity.getTodo_content();
//		for(int i = 100; i < 200; i++) {
//			todoEntity.setTodo_content(content + "_" + (i + 1));
//			if(i % 2 == 0) { 
//				todoEntity.setImportance_flag(1);
//			}else {
//				todoEntity.setImportance_flag(0);
//			}
//			todoRepository.save(todoEntity);
//		}
//		return true;
		
	}
	
//	---------------------------------------------------------------------------------------------------------

	@Override
	public List<TodoListRespDto> getTodoList(String type, int page, int contentCount) throws Exception {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("index", (page - 1) * contentCount);
//		map.put("count", contentCount);
//		List<TodoListRespDto> todoListRespDtos = new ArrayList<TodoListRespDto>();
//		todoList.forEach(todo -> {
//			todoListRespDtos.add(todo.toListDto());
//		});
//		중복코드
		
		List<Todo> todoList = todoRepository.getTodoList(createGetTodoListMap(type, page, contentCount));
		return createTodoListRespDtos(todoList);
	}
	
//	---------------------------------------------------------------------------------------------------------
//	위 메소드로 통일시킴
//	@Override
//	public List<TodoListRespDto> getImportanceList(int page, int contentCount) throws Exception {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("index", (page - 1) * contentCount);
//		map.put("count", contentCount);
//		List<TodoListRespDto> todoListRespDtos = new ArrayList<TodoListRespDto>();
//		todoList.forEach(todo -> {
//			todoListRespDtos.add(todo.toListDto());
//		});
//		중복코드
		
//		List<Todo> todoList = todoRepository.getImportanceTodoListOfIndex(createGetTodoListMap(page, contentCount));
//		return createTodoListRespDtos(todoList);
//	}
	
//	---------------------------------------------------------------------------------------------------------
	
	// 중복코드 캡슐화
	private Map<String, Object> createGetTodoListMap(String type, int page, int contentCount) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", type);
		map.put("index", (page - 1) * contentCount);
		map.put("count", contentCount);
		return map;
	}
	
	private List<TodoListRespDto> createTodoListRespDtos(List<Todo> todoList) {
		List<TodoListRespDto> todoListRespDtos = new ArrayList<TodoListRespDto>();
		todoList.forEach(todo -> {
			todoListRespDtos.add(todo.toListDto());
		});
		return todoListRespDtos; 
	}
	
//	---------------------------------------------------------------------------------------------------------

	@Override
	public boolean updateTodoComplete(int todoCode) throws Exception {
		return todoRepository.updateTodoComplete(todoCode) > 0;
	}
	
//	---------------------------------------------------------------------------------------------------------

	@Override
	public boolean updateTodoImportance(int todoCode) throws Exception {
		return todoRepository.updateTodoImportance(todoCode) > 0;
	}
	
//	---------------------------------------------------------------------------------------------------------

	@Override
	public boolean updateTodo(UpdateTodoReqDto updateTodoReqDto) throws Exception {
		return todoRepository.updateTodoByTodoCode(updateTodoReqDto.toEntity()) > 0;
	}
	
//	---------------------------------------------------------------------------------------------------------
	
	@Override
	public boolean removeTodo(int todoCode) throws Exception {
		return todoRepository.remove(todoCode) > 0;
	}
}















