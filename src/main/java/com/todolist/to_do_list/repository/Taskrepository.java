package com.todolist.to_do_list.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todolist.to_do_list.model.Task;

public interface Taskrepository extends JpaRepository<Task, Long>{

    
}   
