package com.dlph.post_management.controller;

import com.dlph.post_management.dto.PostDTO;
import com.dlph.post_management.service.PostManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/post")
public class PostController {

    @Autowired
    private PostManagementService postManagementService;

    @GetMapping(value = "/greet")
    public String greet(){
        return "hello";
    }

    @GetMapping(value = "/list")
    public ResponseEntity list(){
        return new ResponseEntity(postManagementService.list(), HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity add(@RequestBody PostDTO postDTO){
        Boolean response = postManagementService.add(postDTO);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}/update")
    public ResponseEntity edit(@PathVariable(value = "id") String id, @RequestBody PostDTO post){
        return new ResponseEntity(postManagementService.edit(id, post), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}/delete")
    public ResponseEntity delete(@PathVariable(value = "id") String id){
        return new ResponseEntity(postManagementService.delete(id), HttpStatus.OK);
    }
}
