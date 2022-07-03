package com.victorhugo.workshopmongo.services;

import com.victorhugo.workshopmongo.domain.User;
import com.victorhugo.workshopmongo.repository.UserRepository;
import com.victorhugo.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public List<User>findAll(){

        return repo.findAll();
    }
    public User findById(String id){
        Optional <User> obj = repo.findById(id);
            return  obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado"));
    }

}
