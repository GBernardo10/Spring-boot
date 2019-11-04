// package br.com.bandtec.AgendaDeObjetivos.old;

// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;

// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RestController;

// import br.com.bandtec.AgendaDeObjetivos.model.User;

// @RestController
// public class UserController {
// 	private List<User> users;

// 	public UserController() {
// 		this.users = getAllUser();
// 	}

// 	@GetMapping("/user/name/{username}")
// 	// metodo que retorna um objeto de usuario(JSON)
// 	public ResponseEntity<User> getByName(@PathVariable("username") String name) {
// 		for (User u : users) {
// 			if (u.getName().equals(name)) {
// 				return ResponseEntity.ok(u);
// 			}
// 		}
// 		return ResponseEntity.noContent().build();
// 	}

// 	@GetMapping("/user/name/allName/{username}")
// 	// metodo que retorna um objeto de varios usuario(JSON)
// 	public ResponseEntity<List<User>> getAllUser(@PathVariable("username") String name) {
// 		List<User> userByName = new ArrayList<User>();
// 		for (User u : users) {
// 			if (u.getName().equals(name)) {
// 				userByName.add(u);
// 			}
// 		}
// 		if (userByName.isEmpty()) {
// 			return ResponseEntity.noContent().build();
// 		}
// 		return ResponseEntity.ok(userByName);
// 	}
	
// 	@GetMapping("/user/age/name/{age}")
// 	// metodo que retorna um objeto de varios usuario(JSON)
// 	public ResponseEntity<List<User>> getNameByAge(@PathVariable("age") Integer age) {
// 		List<User> getAllUserByAge = new ArrayList<User>();
// 		for (User u : users) {
// 			if (u.getAge().equals(age)) {
// 				getAllUserByAge.add(u);
// 			}
// 		}
// 		if (getAllUserByAge.isEmpty()) {
// 			return ResponseEntity.noContent().build();
// 		}
// 		return ResponseEntity.ok(getAllUserByAge);
// 	}

// 	private List<User> getAllUser() {
// 		return Arrays.asList(new User("Guilherme", 22), new User("Bernardo", 20), new User("Muniz", 18),
// 				new User("Jesus", 24), new User("Jesus", 24));
// 	}
// }
