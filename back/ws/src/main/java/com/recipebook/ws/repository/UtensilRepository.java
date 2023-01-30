package com.recipebook.ws.repository;

import com.recipebook.ws.entity.Utensil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtensilRepository extends JpaRepository<Utensil, Integer> {
    Utensil findById(int id);
}