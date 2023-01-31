package com.distribuida.servicios;

import com.distribuida.db.Author;
import jdk.dynalink.linker.LinkerServices;

import java.util.List;

public interface AuthorService {

    List<Author> findAll();
    Author findById(Long id);
    void createAuthor(Author author);
    void updateAuthor(long id, Author author) throws Exception;
    void deleteAuthor(long id);
}
