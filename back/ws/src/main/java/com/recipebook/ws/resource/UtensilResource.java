package com.recipebook.ws.resource;

import com.recipebook.ws.consts.ResourceUrlConst;
import com.recipebook.ws.entity.Stock;
import com.recipebook.ws.entity.User;
import com.recipebook.ws.entity.Utensil;
import com.recipebook.ws.service.UtensilService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(ResourceUrlConst.UTENSIL_URI)
@RestController
@RequiredArgsConstructor
@Slf4j
public class UtensilResource {

    private final UtensilService utensilService;

    @GetMapping
    public List<Utensil> retrieveAllUtensils(){
        log.info("WS called");
        return utensilService.retrieveAllUtensil();
    }
    @GetMapping("/{id}")
    public Utensil retrieveUtensil(@PathVariable int id){
        return utensilService.retrieveUtensil(id);
    }

    @PostMapping
    public List<Utensil> newUtensil(@RequestBody List<Utensil> utensil){
        log.info("WS called");
        return utensilService.createUtensil(utensil);
    }

    @DeleteMapping
    public void deleteUtensil(@RequestBody List<Integer> id) {
        utensilService.deleteUtensilById(id);
    }

    @PatchMapping
    public List<Utensil> updateUtensil(@RequestBody List<Utensil> utensil) {
        return utensilService.updateUtensil(utensil);
    }

}
