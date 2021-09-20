package com.programming.techie.springredditclone.controller;

import com.programming.techie.springredditclone.model.Task;
import com.programming.techie.springredditclone.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTask(@PathVariable Long id, @RequestBody com.programming.techie.springredditclone.dto.Task taskDTO){
        if(id == null){
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid update request");
        }
        Optional<Task> taskById = taskRepository.findById(id);
        if(taskById.isPresent()){
            Task task = taskById.get();
            task.setDescription(taskDTO.getDescription());
            task.setPriority(taskDTO.getPriority());
            Task save = taskRepository.save(task);
            return ResponseEntity.status(HttpStatus.OK).body(save);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No task found");
        }
    }
}
