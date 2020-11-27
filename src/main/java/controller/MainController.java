package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.ReaderDao;
import model.Reader;

@Controller
public class MainController {
	@Autowired
	private ReaderDao readerDao;
	
	@RequestMapping(path={"/", "/signin"})
	public String getSignIn() {
		return "signIn";
	}
	
	@RequestMapping(path="/signup")
	public String getSignUp() {
		return "signUp";
	}
	
	@RequestMapping(path="/retrieve-member-id")
	public String retrievetMemberId() {
		return "retrieveMemberId";
	}
	
	@RequestMapping(path="/retrieve-email")
	public String retrieveEmail() {
		return "retrieveEmail";
	}
	
	@RequestMapping(path="/addBook")
	public String addBook() {
		return "addBook";
	}
	
	@GetMapping(value="/redirect-signup/{memberId}")
	public String redirectSignup(@PathVariable String memberId, Model model) {
		model.addAttribute("memberId", memberId);
		return "redirectSignup";
	}
	
	@GetMapping(path="/signin/{memberId}/{email}")
	@Validated
	public String signin(@PathVariable String memberId, @PathVariable String email) {
		Reader reader = readerDao.findByMemberId(memberId);
		if(reader.getEmail() == email) {
			return "retrieveEmail";
		}
		return "redirectFailedSignin";
	}
}
