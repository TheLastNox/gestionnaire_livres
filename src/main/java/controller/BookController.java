package controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.BookDao;
import model.Book;

@Controller
@RequestMapping(path="/v1/api")
public class BookController {
	@Autowired
	private BookDao bookDao;
	
	@GetMapping(path="/book/all")
	public @ResponseBody Iterable<Book> getAllBooks() {
		return bookDao.findAll();
	}
	
	@GetMapping(value = "/book/id/{id}")
	public Book getBookById(@PathVariable int id) {
		return bookDao.findById(id);
	}
	
	@GetMapping(value = "/book/title/{title}")
	public Iterable<Book> getBooksByTitle(@PathVariable String title) {
		return bookDao.findByTitle(title);
	}
	
	@GetMapping(value = "/book/author/{author}")
	public Iterable<Book> getBooksByAuthor(@PathVariable String author) {
		return bookDao.findByAuthor(author);
	}
	@GetMapping(value = "/book/editor/{editor}")
	public Iterable<Book> getBooksByEditor(@PathVariable String editor) {
		return bookDao.findByEditor(editor);
	}
	
	@GetMapping(value = "/book/relDate/{relDate}")
	public Iterable<Book> getBooksByRelDate(@PathVariable Date relDate) {
		return bookDao.findByRelDate(relDate);
	}
	
	@GetMapping(value = "/book/available/{available}")
	public Iterable<Book> getBooksByAvailable(@PathVariable boolean available) {
		return bookDao.findByAvailable(available);
	}
	
	@PostMapping(path="/book/add")
	public @ResponseBody String addNewBook (@RequestBody Book book) {
		bookDao.save(book);
		return "Ajouté!";
	}
	
	@PutMapping (value = "/book/update")
	public String updateBook(@RequestBody Book book) {
		bookDao.save(book);
		return "Mis à jour!";
	}
	
	@DeleteMapping (value = "/book/{id}")
	public String deleteBookById(@PathVariable int id) {
		bookDao.deleteById(id);
		return "Supprimé!";
	}
}
