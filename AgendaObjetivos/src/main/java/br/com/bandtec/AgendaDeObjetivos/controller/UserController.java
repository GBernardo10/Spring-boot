package br.com.bandtec.AgendaDeObjetivos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bandtec.AgendaDeObjetivos.model.User;
import br.com.bandtec.AgendaDeObjetivos.repository.AllUser;;


/**
 * UserController
 */

@RestController
public class UserController {

    private AllUser allUser;
    
    @Autowired
    public UserController(AllUser allUser) {
        this.allUser = allUser;
    }

    @PostMapping("/usuarios")
    public ResponseEntity<User> cadastrarUsuario(@RequestBody User user) {
        return ResponseEntity.ok(allUser.save(user));
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<User>> buscarUsuarios() {
        return ResponseEntity.ok(allUser.findAll());
    }
    
    
    @GetMapping("/usuarios/nome/{nome}")
    public ResponseEntity<List<User>> findByOneUser(@PathVariable("nome")String nome){
    	List<User>users = allUser.findByName(nome);
    	if(users.isEmpty()) {
    		return ResponseEntity.noContent().build();
    	}
        return ResponseEntity.ok(users);
    }
    
}