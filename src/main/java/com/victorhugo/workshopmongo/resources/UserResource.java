package com.victorhugo.workshopmongo.resources;

import com.victorhugo.workshopmongo.domain.User;
import com.victorhugo.workshopmongo.dto.UserDTO;
import com.victorhugo.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/users")
public class UserResource {
   @Autowired
   private UserService service;
    @RequestMapping(method = RequestMethod.GET)
       public ResponseEntity <List<UserDTO>> findAll(){
       List<User> list = service.findAll();
       List <UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
       return ResponseEntity.ok().body(listDto);
   }


}
