package dev.kerim.service.abstracts;

import dev.kerim.entities.BookBorrowing;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookBorrowingServices {
    BookBorrowing save(BookBorrowing bookBorrowing);
    BookBorrowing update(BookBorrowing bookBorrowing);
    BookBorrowing getId(long id);
    Page<BookBorrowing> cursor(int page, int pageSize);
    boolean delete(long id);
}
