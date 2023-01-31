package com.distribuida.servicios;

import com.distribuida.db.Author;
import com.distribuida.repository.AuthorRepository;
import jdk.swing.interop.SwingInterOpUtils;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class AuthorServiceImpl implements AuthorService{

    @Inject
    AuthorRepository authorRepository;

    @Override
    public List<Author> findAll() {
        System.out.println("****************************Hola*****************");
        return authorRepository.findAll().stream().toList();
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    @Transactional
    public void createAuthor(Author author) {
        authorRepository.persist(author);
        System.out.println("****************************Autor creado*****************");
    }

    @Override
    @Transactional
    public void deleteAuthor(long id) {
        // llamamos al autor por medio del Id
        Author author = authorRepository.findById(id);
        if (author != null){ // Verificar si el author existe
            authorRepository.delete(author);
        }else{
            System.out.println("****************************El objeto no existe*****************");
        }
    }

    @Override
    @Transactional
    public void updateAuthor(long id, Author author){
        Author author2 = authorRepository.findById(id);
        if (author != null){
            author2.setFirstName(author.getFirstName());
            author2.setLastName(author2.getLastName());
            authorRepository.persistAndFlush(author2);
        }else {
            System.out.println("****************************El objeto no existe*****************");
        }
    }
}
