package dev.kerim.service.impl;

import dev.kerim.service.abstracts.IBookServices;
import dev.kerim.dao.BookRepository;
import dev.kerim.entities.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookManager implements IBookServices {
    private final BookRepository bookRepository;
    @Override
    public Book save(Book Book) {
        return null;
    }

    @Override
    public Book update(Book Book) {
        return null;
    }

    @Override
    public Book getId(long id) {
        return null;
    }

    @Override
    public Page<Book> cursor(int page, int pageSize) {
        return null;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}