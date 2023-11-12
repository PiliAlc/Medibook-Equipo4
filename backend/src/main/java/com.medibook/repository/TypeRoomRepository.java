package com.medibook.repository;

import com.medibook.entities.Typeroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TypeRoomRepository extends JpaRepository<Typeroom,Long> {

    @Query("select r from Typeroom r where id =:id")
    Optional<Typeroom> findId(Long id);
}

