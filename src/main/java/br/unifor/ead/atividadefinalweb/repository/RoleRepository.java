package br.unifor.ead.atividadefinalweb.repository;

import br.unifor.ead.atividadefinalweb.models.ERole;
import br.unifor.ead.atividadefinalweb.models.Role;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {
  Optional<Role> findByName(ERole name);
}