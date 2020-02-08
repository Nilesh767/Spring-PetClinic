package com.n3o.springpetclinic.bootstrap;

import com.n3o.springpetclinic.model.Owner;
import com.n3o.springpetclinic.model.Vet;
import com.n3o.springpetclinic.services.OwnerService;
import com.n3o.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;


    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Nilesh");
        owner1.setLastName("Choudhary");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Rubal");
        owner2.setLastName("Choudhary");
        ownerService.save(owner2);

        System.out.println("Owners Loaded");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vetService.save(vet2);

        System.out.println("Vets Loaded");

    }
}
