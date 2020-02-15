package com.n3o.springpetclinic.repositories;

import com.n3o.springpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository  extends CrudRepository<Vet, Long> {
}
