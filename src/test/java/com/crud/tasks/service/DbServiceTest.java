package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DbServiceTest {

    @InjectMocks
    private DbService dbService;

    @Mock
    private TaskRepository taskRepository;

    @Test
    public void getAllTasksTest() {

        //Given
        Task task = new Task(1L, "test title", "test content");
        Task task2 = new Task(2L, "test title2", "test content2");
        Task task3 = new Task(3L, "test title3", "test content3");

        List<Task> taskList = new ArrayList<>();
        taskList.add(task);
        taskList.add(task2);
        taskList.add(task3);

        when(taskRepository.findAll()).thenReturn(taskList);

        //When
        List<Task> result = dbService.getAllTasks();

        //Then
        assertEquals(3, result.size());
    }

    @Test
    public void getTaskByIdTest() {

        //Given
        Task task = new Task(1L, "test title", "test content");
        when(taskRepository.findById(task.getId())).thenReturn(Optional.of(task));

        //When
        Optional<Task> result = dbService.getTaskById(task.getId());

        //Then
        assertEquals(1L, result.get().getId());
    }

    @Test
    public void saveTaskTest() {

        //Given
        Task task = new Task(1L, "test title", "test content");
        when(taskRepository.save(task)).thenReturn(task);

        //When
        Task result = dbService.saveTask(task);

        //Then
        assertEquals(1L, result.getId());
        assertEquals("test title", result.getTitle());
        assertEquals("test content", result.getContent());
    }

    @Test
    public void deleteTaskTest() {

        //Given
        Task task = new Task(1L, "test title", "test content");
        dbService.saveTask(task);

        //When
        dbService.deleteTask(task.getId());

        //Then
        assertFalse(dbService.getTaskById(task.getId()).isPresent());
    }
}
