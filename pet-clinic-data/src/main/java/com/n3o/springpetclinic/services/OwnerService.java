package com.n3o.springpetclinic.services;

import com.n3o.springpetclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
