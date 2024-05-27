package dev.kerim.service.impl;


import dev.kerim.service.abstracts.IAuthorServices;
import dev.kerim.dao.AuthorRepository;
import dev.kerim.entities.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorManager implements IAuthorServices {
    private final AuthorRepository authorRepository;


    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author update(Author author) {
        getId(author.getId());
        return authorRepository.save(author);
    }

    ///////////////////////////////////////////////////////////
    @Override
    public Author getId(long id) {
        return null;
    }

    @Override
    public Page<Author> cursor(int page, int pageSize) {
        return authorRepository.findAll(PageRequest.of(page,pageSize));
    }

    @Override
    public boolean delete(long id) {
        authorRepository.delete(getId(id));
        return true;
    }
}
