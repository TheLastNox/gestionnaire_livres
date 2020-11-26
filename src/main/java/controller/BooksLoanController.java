package controller;

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
