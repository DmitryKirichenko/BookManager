package test.bookmanager.specification;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import test.bookmanager.dto.BookFilterDto;
import test.bookmanager.entity.Book;

import java.util.ArrayList;
import java.util.List;


public class BookSpecification {

    public static Specification<Book> withFilter(BookFilterDto filter) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter.title() != null && !filter.title().isBlank()) {
                predicates.add(cb.like(cb.lower(root.get("title")), "%" + filter.title().toLowerCase() + "%"));
            }

            if (filter.brand() != null && !filter.brand().isBlank()) {
                predicates.add(cb.equal(cb.lower(root.get("brand")), filter.brand().toLowerCase()));
            }

            if (filter.year() != null) {
                predicates.add(cb.equal(root.get("year"), filter.year()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
