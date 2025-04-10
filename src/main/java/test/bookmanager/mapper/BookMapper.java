package test.bookmanager.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import test.bookmanager.dto.BookDto;
import test.bookmanager.entity.Book;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookMapper {

    Book toEntity(BookDto dto);

    BookDto toDto(Book entity);

    List<BookDto> toDtos(List<Book> entities);
}
