package dev.kerim.service.impl;

import dev.kerim.service.abstracts.IBookBorrowingServices;
import dev.kerim.core.expection.NotFoundException;
import dev.kerim.core.utilities.Message;
import dev.kerim.dao.BookBorrowingRepository;
import dev.kerim.entities.BookBorrowing;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookBorrowingManager implements IBookBorrowingServices {
    private final BookBorrowingRepository bookBorrowingRepository;
    @Override
    public BookBorrowing save(BookBorrowing bookBorrowing) {
        return bookBorrowingRepository.save(bookBorrowing);
    }

    @Override
    public BookBorrowing update(BookBorrowing bookBorrowing) {
        getId(bookBorrowing.getId());
        return bookBorrowingRepository.save(bookBorrowing);
    }

    @Override
    public BookBorrowing getId(long id) {
        return bookBorrowingRepository.findById(id).orElseThrow(() -> new NotFoundException(Message.NOT_FOUND_MESSAGE));
    }

    @Override
    public Page<BookBorrowing> cursor(int page, int pageSize) {
        return bookBorrowingRepository.findAll(PageRequest.of(page,pageSize));
    }

    @Override
    public boolean delete(long id) {
        bookBorrowingRepository.delete(getId(id));
        return true;
    }
}