package com.medibook.repository;
import com.medibook.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{

    Optional<Room> findByName(String name);

}
