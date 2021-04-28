package guru.springframework.webapp.bootstrap;

import guru.springframework.webapp.domain.Author;
import guru.springframework.webapp.domain.Book;
import guru.springframework.webapp.domain.Publisher;
import guru.springframework.webapp.repositories.AuthorRepository;
import guru.springframework.webapp.repositories.BookRepository;
import guru.springframework.webapp.repositories.PublishRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublishRepository publishRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublishRepository publishRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publishRepository = publishRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        Publisher disney = new Publisher("Disney", "Middelstraat 3", "Gent", "9000");
        publishRepository.save(disney);

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(disney);
        disney.getBooks().add(ddd);


        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");
        Publisher bonnier = new Publisher("Bonnier", "Drottninggatan 10", "Stockholm", "600 30");
        publishRepository.save(bonnier);

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(disney);
        disney.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publishRepository.save(disney);


        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Publishers: " + publishRepository.count());
        System.out.println("Books under Disney: " + disney.getBooks().size());
    }
}
