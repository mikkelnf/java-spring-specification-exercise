package org.example.repository;

import org.example.model.Author;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long>, JpaSpecificationExecutor<Author> {

    @Query(value = "SELECT * FROM author LIMIT ?1 OFFSET ?2", nativeQuery = true)
    List<Author> findAllNative(Integer limit, Integer offset);
}
