package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TaskMapperTest {

    private final TaskMapper taskMapper = new TaskMapper();

    @Test
    public void mapToTaskTest() {

        //Given
        TaskDto taskDto = new TaskDto(1L, "test title", "test content");

        //When
        Task task = taskMapper.mapToTask(taskDto);

        //Then
        assertEquals(1L, task.getId());
        assertEquals("test title", task.getTitle());
        assertEquals("test content", task.getContent());
    }

    @Test
    public void mapToTaskDtoTest() {

        //Given
        Task task = new Task(1L, "test title", "test content");

        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);

        //Then
        assertEquals(1L, taskDto.getId());
        assertEquals("test title", taskDto.getTitle());
        assertEquals("test content", taskDto.getContent());
    }

    @Test
    public void mapToTaskDtoListTest() {

        //Given
        Task task = new Task(1L, "test title", "test content");
        Task task2 = new Task(2L, "test title2", "test content2");
        Task task3 = new Task(3L, "test title3", "test content3");
        List<Task> taskList = new ArrayList<>();
        taskList.add(task);
        taskList.add(task2);
        taskList.add(task3);

        //When
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(taskList);

        //Then
        assertEquals(3, taskDtoList.size());
    }
}
