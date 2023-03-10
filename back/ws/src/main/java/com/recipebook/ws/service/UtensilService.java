package com.recipebook.ws.service;

import com.recipebook.ws.entity.Utensil;
import com.recipebook.ws.repository.UtensilRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UtensilService {

    @Autowired
    private final UtensilRepository utensilRepository;

    public List<Utensil> retrieveAllUtensil(){
        log.info("Retrieving all utensils in DB");
        List<Utensil> utensils = utensilRepository.findAll();
        log.info("{} elements retrieved", utensils.size());
        return utensils;
    }

    public Utensil retrieveUtensil(int id){
        log.info("Retrieving one utensil with {} in id", id);
        Utensil utensil = utensilRepository.findById(id);
        log.info("{} retrieved", utensil.getName());
        return utensil;
    }

    public List<Utensil> createUtensils(List<Utensil> utensils) {
        log.info("create utensils in DB");
        return utensilRepository.saveAll(utensils);
    }

    public void deleteUtensilsById(List<Integer> ids) {
        utensilRepository.deleteAllById(ids);
        log.info("Deleting utensil list with {} in id", ids);
    }

    public List<Utensil> updateUtensils(List<Utensil> utensils) {
        log.info("update utensils in DB");
        return utensilRepository.saveAll(utensils);
    }

}
