package controller;

import java.util.Date;
import java.util.List;

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

import dao.BooksLoanDao;
import model.BooksLoan;

@Controller
@RequestMapping(path="/")
public class BooksLoanController {
	@Autowired
	private BooksLoanDao booksLoanDao;
	
	@GetMapping(path="/booksLoan/all")
	public @ResponseBody Iterable<BooksLoan> getAllBooksLoan() {
		return booksLoanDao.findAll();
	}
	
	@GetMapping(value = "/booksLoan/id/{id}")
	public BooksLoan getBooksLoanById(@PathVariable int id) {
		return booksLoanDao.findById(id);
	}
	
	@GetMapping(value = "/booksLoan/reader/id/{id}")
	public List<BooksLoan> getBooksLoanByReaderId(@PathVariable int id) {
		return booksLoanDao.findByReaderId(id);
	}
	
	@GetMapping(value = "/booksLoan/reader/name/{name}")
	public List<BooksLoan> getBooksLoanByReaderName(@PathVariable String name) {
		return booksLoanDao.findByReaderName(name);
	}
	
	@GetMapping(value = "/booksLoan/reader/email/{email}")
	public List<BooksLoan> getBooksLoanByReaderEmail(@PathVariable String email) {
		return booksLoanDao.findByReaderEmail(email);
	}
	
	@GetMapping(value = "/booksLoan/book/id/{id}")
	public BooksLoan getBooksLoanByBookId(@PathVariable int id) {
		return booksLoanDao.findByBookId(id);
	}
	
	@GetMapping(value = "/booksLoan/book/isbn/{isbn}")
	public BooksLoan getBooksLoanByBookIsbn(@PathVariable String isbn) {
		return booksLoanDao.findByBookIsbn(isbn);
	}
	
	@GetMapping(value = "/booksLoan/book/title/{title}")
	public List<BooksLoan> getBooksLoanByBookTitle(@PathVariable String title) {
		return booksLoanDao.findByBookTitle(title);
	}
	
	@GetMapping(value = "/booksLoan/book/author/{author}")
	public List<BooksLoan> getBooksLoanByBookAuthor(@PathVariable String author) {
		return booksLoanDao.findByBookAuthor(author);
	}
	
	@GetMapping(value = "/booksLoan/book/editor/{editor}")
	public List<BooksLoan> getBooksLoanByBookEditor(@PathVariable String editor) {
		return booksLoanDao.findByBookEditor(editor);
	}
	
	@GetMapping(value = "/booksLoan/book/relDate/{relDate}")
	public List<BooksLoan> getBooksLoanByBookRelDate(@PathVariable Date relDate) {
		return booksLoanDao.findByBookRelDate(relDate);
	}
	
	@PostMapping(path="/booksLoan/add")
	public @ResponseBody String addNewBooksLoan(@RequestBody BooksLoan booksLoan) {
		booksLoanDao.save(booksLoan);
		return "Ajouté!";
	}
	
	@PutMapping(path="/booksLoan/update")
	public @ResponseBody String updateBooksLoan(@RequestBody BooksLoan booksLoan) {
		booksLoanDao.save(booksLoan);
		return "Ajouté!";
	}
	
	@DeleteMapping(value = "/booksLoan/id/{id}")
	public String deleteBooksLoanById(@PathVariable int id) {
		booksLoanDao.deleteById(id);
		return "Supprimé!";
	}
}
