package bookstore;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
public class BookController{

    BookAccess bookAccess = new BookAccess();

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public ResponseEntity<List<Book>> getBooks(){
        List<Book> bookList = bookAccess.getAllBooks();
        if(bookList.isEmpty()) return new ResponseEntity<List<Book>>(bookList, HttpStatus.NO_CONTENT);
        else return new ResponseEntity<List<Book>>(bookList, HttpStatus.OK);
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    public ResponseEntity<Book> getBook(@PathVariable(value="id") int id){
        return new ResponseEntity<Book>(bookAccess.getBook(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public ResponseEntity<Response> addBook(@Valid @RequestBody Book book){
        int response = bookAccess.addBook(book);
        if(response == 1) return new ResponseEntity<Response>(new Response("success", "Book added"), HttpStatus.OK);
        return new ResponseEntity<Response>(new Response("failure", "Book already exists"), HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Response> updateBook(@PathVariable(value="id") int oid,
                                               @Valid @RequestBody Book book){
        int response = bookAccess.updateBook(oid, book);
        if(response == 1) return new ResponseEntity<Response>(new Response("success", "Book updated"), HttpStatus.OK);
        return new ResponseEntity<Response>(new Response("failure", "Could not find book"), HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Response> deleteBook(@PathVariable(value="id") int id){
        int response = bookAccess.deleteBook(id);
        if(response == 1) return new ResponseEntity<Response>(new Response("success", "Book deleted"), HttpStatus.OK);
        return new ResponseEntity<Response>(new Response("failure", "Could not find book"), HttpStatus.BAD_REQUEST);
    }
}
