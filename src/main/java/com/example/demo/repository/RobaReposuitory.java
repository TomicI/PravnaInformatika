package com.example.demo.repository;

import com.example.demo.model.Roba;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RobaReposuitory extends JpaRepository<Roba, Long>  {
    List<Roba> findByVlasnikId(Long vlasnikId);
    List<Roba> findByVlasnikIdAndRobaProdata(Long vlasnikId, Boolean robaProdata);
    List<Roba> findByNazivContainingAndRobaProdata(String naziv, Boolean robaProdata);
}
