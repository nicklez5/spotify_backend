package com.spotify66_times.repo;




import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.spotify66_times.entity.Library;



@Repository
public interface LibraryRepo extends JpaRepository<Library,Integer> {
    
    
}
