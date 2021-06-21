package ru.softlab.REST_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.softlab.REST_demo.domain.Book;
import ru.softlab.REST_demo.domain.BookType;
import ru.softlab.REST_demo.domain.User;
import ru.softlab.REST_demo.repos.BookRepo;
import ru.softlab.REST_demo.repos.UserRepo;

@SpringBootApplication
public class Application extends SpringBootServletInitializer implements CommandLineRunner {

    @Autowired
    BookRepo bookRepo;

    @Autowired
    UserRepo userRepo;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User("reader", "admin");
        user.setFirstName("Иван");
        user.setLastName("Иванов");
        user.setAvatarImageURL("https://kartinki-vernisazh.ru/_ph/154/2/263911896.png");
        user.setEmail("email@example.com");
        user.setAge(23);

        userRepo.save(user);

        Book book1 = new Book("Руслан и Людмила", "А.С. Пушкин", 2000, "https://img.yakaboo.ua/media/catalog/product/cache/1/image/398x565/234c7c011ba026e66d29567e1be1d1f7/3/2/323826_24946636.jpg", BookType.PAPER);
        Book book2 = new Book("Дубровский", "А.С. Пушкин", 2001, "https://img3.labirint.ru/rc/b2a4bf196a6fb12ced1afdd603dea361/220x340/books23/226003/cover.jpg?1563568974", BookType.AUDIO);
        Book book3 = new Book("Мцыри", "М.Ю. Лермонтов", 2002, "https://img3.labirint.ru/rc/af7f34b0f5a1dc4065a933ae28f4748b/220x340/books36/353011/cover.jpg?1345465541", BookType.DIGITAL);
        bookRepo.save(book1);
        bookRepo.save(book2);
        bookRepo.save(book3);

    }

}