package bookstore;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController{

    BookAccess bookAccess = new BookAccess();

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> getBooks(){
        return bookAccess.getAllBooks();
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    public Book getBook(@PathVariable(value="id") int id){
        return bookAccess.getBook(id);
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public Response addBook(@RequestParam(value="id") int id,
                            @RequestParam(value="author") String author,
                            @RequestParam(value="name") String name,
                            @RequestParam(value="genre") String genre){
        Book book = new Book(id, author, name, genre);
        int response = bookAccess.addBook(book);
        if(response == 1) return new Response("success", "Book added");
        return new Response("failure", "Book already exists");
    }

    @RequestMapping(value = "/books", method = RequestMethod.PUT)
    public Response updateBook(@RequestParam(value="oid") int oid,
                               @RequestParam(value="id") int id,
                               @RequestParam(value="author") String author,
                               @RequestParam(value="name") String name,
                               @RequestParam(value="genre") String genre){
        Book book = new Book(id, author, name, genre);
        int response = bookAccess.updateBook(oid, book);
        if(response == 1) return new Response("success", "Book updated");
        return new Response("failure", "Couldn't find book");
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
    public Response deleteBook(@PathVariable(value="id") int id){
        int response = bookAccess.deleteBook(id);
        if(response == 1) return new Response("success", "Book deleted");
        return new Response("failure", "Couldn't find book");
    }
}