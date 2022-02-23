package com.schulzmarcos.bookservice.domain.repositories;

import com.schulzmarcos.bookservice.domain.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
