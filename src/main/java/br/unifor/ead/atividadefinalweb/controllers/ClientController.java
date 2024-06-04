package br.unifor.ead.atividadefinalweb.controllers;

import br.unifor.ead.atividadefinalweb.models.User;
import br.unifor.ead.atividadefinalweb.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final UserRepository userRepository;

    public ClientController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getUser() {
        return userRepository.findAll();
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable String username) {
        return userRepository.findByUsername(username).orElseThrow(RuntimeException::new);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User user) {
        User currentUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        currentUser.setUsername(user.getUsername());
        currentUser.setEmail(user.getEmail());
        currentUser = userRepository.save(currentUser);

        return ResponseEntity.ok(currentUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            userRepository.delete(userOptional.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
