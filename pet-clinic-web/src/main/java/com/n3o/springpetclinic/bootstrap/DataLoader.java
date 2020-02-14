package com.n3o.springpetclinic.bootstrap;

import com.n3o.springpetclinic.model.*;
import com.n3o.springpetclinic.services.OwnerService;
import com.n3o.springpetclinic.services.PetTypeService;
import com.n3o.springpetclinic.services.SpecialityService;
import com.n3o.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialityService specialityService)
    {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if(count==0){
            loadData();
        }
    }

    private void loadData() {
//PetType
        //Dog
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);
        //cat
        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);
        //load
        System.out.println("PetType Loaded");

//Speciality
        //radiology
        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);
        //surgery
        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);
        //dentistry
        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);
        //load
        System.out.println("Speciality Loaded");

//owner
        //object
        Owner owner1 = new Owner();
        owner1.setFirstName("Nilesh");
        owner1.setLastName("Choudhary");
        owner1.setAddress("xyz");
        owner1.setCity("pilani");
        owner1.setTelephone("1212121212");
        //setting pet for object
        Pet nileshPet = new Pet();
        nileshPet.setId(1L);
        nileshPet.setName("Rex");
        nileshPet.setPetType(savedDogType);
        nileshPet.setOwner(owner1);
        nileshPet.setBirthDate(LocalDate.now());
        owner1.getPets().add(nileshPet);
        //save
        ownerService.save(owner1);
        //more object
        Owner owner2 = new Owner();
        owner2.setFirstName("Rubal");
        owner2.setLastName("Choudhary");
        owner2.setAddress("xyz");
        owner2.setCity("pilani");
        owner2.setTelephone("1212121212");
        //setting pet for object
        Pet rubalPet = new Pet();
        rubalPet.setId(1L);
        rubalPet.setName("Rex");
        rubalPet.setPetType(savedDogType);
        rubalPet.setBirthDate(LocalDate.now());
        rubalPet.setOwner(owner1);
        owner1.getPets().add(rubalPet);
        //save
        ownerService.save(owner2);
        //load
        System.out.println("Owners Loaded");

//Vet
        //object
        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);
        //more object
        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);
        //load
        System.out.println("Vets Loaded");
    }
}
