package com.example.demo;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {
    private final BookService bookService;

    @Autowired
    public DemoApplication(BookService bookService) {
        this.bookService = bookService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Book book = new Book();
                book.setAuthor("Joseph Heller");
                book.setTitle("Catch-22");
                book.setPrice(BigDecimal.valueOf(4.27));
                book.setCoveIrmage(" ");
                book.setDescription("Known for the logical paradox "
                        + "that arose between mutually exclusive rules");
                book.setIsbn("13: 9780671502331");
                bookService.save(book);
                System.out.println(bookService.findAll());
            }
        };
    }
}
