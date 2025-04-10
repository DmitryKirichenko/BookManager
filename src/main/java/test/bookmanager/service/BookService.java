package test.bookmanager.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import test.bookmanager.dto.BookDto;
import test.bookmanager.dto.BookFilterDto;
import test.bookmanager.entity.Book;
import test.bookmanager.exceptions.NotFoundException;
import test.bookmanager.mapper.BookMapper;
import test.bookmanager.repository.BookRepository;
import test.bookmanager.specification.BookSpecification;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookDto createBook(BookDto book) {
        Book createdBook = bookRepository.save(bookMapper.toEntity(book));
        return bookMapper.toDto(createdBook);
    }

    public void deleteBook(Long bookId) {
        throwIfBookNotFound(bookId);

        bookRepository.deleteById(bookId);
    }

    public BookDto updateBook(Long bookId, BookDto bookDto) {
        throwIfBookNotFound(bookId);

        Book book = bookMapper.toEntity(bookDto);
        book.setId(bookId);

        bookRepository.save(book);

        return bookDto.toBuilder()
                .id(bookId)
                .build();
    }

    public List<BookDto> getAllBooks() {
        return bookMapper.toDtos(bookRepository.findAll());
    }

    public Page<BookDto> getBooksPage(BookFilterDto filter) {
        Specification<Book> spec = BookSpecification.withFilter(filter);

        Pageable pageable = PageRequest.of(
                filter.pageNumber() != null ? filter.pageNumber() : 0,
                filter.quantity() != null ? filter.quantity() : 10,
                Sort.by("id")
        );

        return bookRepository.findAll(spec, pageable)
                .map(bookMapper::toDto);
    }


    private void throwIfBookNotFound(Long bookId) {
        if (bookRepository.existsById(bookId)) {
            throw new NotFoundException(String.format("Book with ID %d not found", bookId));
        }
    }

}
