package com.brq.project.banco;

import org.springframework.data.repository.CrudRepository;

public interface ClienteInterface extends CrudRepository<Cliente, String> {

    Cliente findByCpf(String cpf);
}
