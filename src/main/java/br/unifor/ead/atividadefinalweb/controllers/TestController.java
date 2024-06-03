package br.unifor.ead.atividadefinalweb.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
  @GetMapping("/all")
  public String allAccess() {
    return "Conteúdo Público.";
  }

  @GetMapping("/user")
  //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
  public String userAccess() {
    return "Conteúdo do Usuário";
  }

  @GetMapping("/mod")
  //@PreAuthorize("hasRole('MODERATOR')")
  public String moderatorAccess() {
    return "Área do Moderador.";
  }

  @GetMapping("/admin")
  //@PreAuthorize("hasRole('ADMIN')")
  public String adminAccess() {
    return "Área do Administrador.";
  }
}