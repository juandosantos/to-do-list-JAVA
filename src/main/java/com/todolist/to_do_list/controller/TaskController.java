package com.todolist.to_do_list.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.to_do_list.model.Task;
import com.todolist.to_do_list.repository.Taskrepository;


@RestController
@RequestMapping("/tarefas")
public class TaskController {
    
    @Autowired
    private Taskrepository taskrepository;

    @GetMapping
    public List<Task> getAllTasks(){
        return taskrepository.findAll();
    }

    @GetMapping("/{id}")
    public Task getTasksId(@PathVariable Long id){
        return taskrepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
    }

    @PostMapping
    public Task createTask(@RequestBody Task task){
        return taskrepository.save(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task taskDetails){
        Task task = taskrepository.findById(id).orElseThrow();
        task.setNome(taskDetails.getNome());
        task.setCompleto(taskDetails.isCompleto());
        return taskrepository.save(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        Task task = taskrepository.findById(id).orElseThrow();
        taskrepository.delete(task);
    }
}
