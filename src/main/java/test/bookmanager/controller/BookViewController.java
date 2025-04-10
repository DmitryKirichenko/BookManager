package test.bookmanager.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import test.bookmanager.dto.BookDto;
import test.bookmanager.dto.BookFilterDto;
import test.bookmanager.service.BookService;

@Controller
@RequestMapping("/ui")
@RequiredArgsConstructor
public class BookViewController {

    private final BookService bookService;

    @GetMapping("/books")
    public String showBooks(Model model, BookFilterDto filter) {
        if (filter == null) {
            filter = new BookFilterDto(null, null, null, 10, 0);
        }

        Page<BookDto> bookPage = bookService.getFilteredBooks(filter);
        model.addAttribute("books", bookPage.getContent());
        model.addAttribute("filter", filter);
        model.addAttribute("currentPage", bookPage.getNumber());
        model.addAttribute("totalPages", bookPage.getTotalPages());

        return "books.html";
    }


}



