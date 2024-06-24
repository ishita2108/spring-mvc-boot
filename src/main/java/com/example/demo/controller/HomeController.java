package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Alien;
import com.example.demo.repository.AlienRepo;

@Controller
public class HomeController {
	
	@Autowired
	AlienRepo repo;

	@RequestMapping("/")
	public String home() {
		System.out.println("Home Page Requested...");
		return "index";
	}

//	@RequestMapping("/add")
//	public String add(HttpServletRequest req) {
//		int i = Integer.parseInt(req.getParameter("num1"));
//		int j = Integer.parseInt(req.getParameter("num2"));
//		
//		int result = i+j;
//		
//		HttpSession session = req.getSession();
//		session.setAttribute("result", result);
//		return "result.jsp";
//	}

//	@RequestMapping("/add")
//	public String add(@RequestParam("num1") int i, @RequestParam("num2") int j, HttpSession session) {
//		int result = i + j;
//		session.setAttribute("result", result);
//		return "result.jsp";
//	}
	
//	@RequestMapping("/add")
//	public ModelAndView add(@RequestParam("num1") int i, @RequestParam("num2") int j) {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("result");
//		
//		int result = i + j;
//		mv.addObject("result", result);
//		
//		return mv;
//	}
	
	@RequestMapping("/add")
	public String add(@RequestParam("num1") int i, @RequestParam("num2") int j, ModelMap m) {
		
		int result = i + j;
		m.addAttribute("result", result);
		
		return "result";
	}
	
//	@RequestMapping("/add")
//	public String add(@RequestParam("num1") int i, @RequestParam("num2") int j, Model m) {
//		
//		int result = i + j;
//		m.addAttribute("result", result);
//		
//		return "result";
//	}
	
//	@RequestMapping("/addAlien")
//	public String addAlien(@RequestParam("aid") int id, @RequestParam("aname") String name , ModelMap m) {
//
//		Alien a = new Alien();
//		a.setAid(id);
//		a.setAname(name);
//		m.addAttribute("alien", a);
//		return "result";
//	}
	
//	@RequestMapping("/addAlien")
//	public String addAlien(@ModelAttribute("a1") Alien a) {
//		return "result";
//	}
	
//	@RequestMapping(value = "/addAlien", method=RequestMethod.POST)
//	public String addAlien(@ModelAttribute Alien a) {
//		return "result";
//	}
//	
//	@GetMapping( "/getAliens")
//	public String getAliens(Model m) {
//		List<Alien> aliens = Arrays.asList(new Alien(101,"Naveen"), new Alien(102,"Rose"));
//		m.addAttribute("aliens", aliens);
//		return "showAliens";
//	}
//	
//	@GetMapping( "/getAlien")
//	public String getAlien(Model m) {
//		List<Alien> aliens = Arrays.asList(new Alien(101,"Naveen"), new Alien(102,"Rose"));
//		m.addAttribute("aliens", aliens);
//		return "showAliens";
//	}
//	
//	@ModelAttribute
//	public void modelData(Model model) {
//		model.addAttribute("name","Aliens");
//	}
	
	
	@RequestMapping(value = "/addAlien", method=RequestMethod.POST)
	public String addAlien(@ModelAttribute Alien a) {
		repo.save(a);
		return "result";
	}
	
	@GetMapping( "/getAliens")
	public String getAliens(Model m) {
		List<Alien> aliens = repo.findAll();
		m.addAttribute("aliens", aliens);
		return "showAliens";
	}
	
	@GetMapping( "/getAlien")
	public String getAlien(@RequestParam int aid, Model m) {
		Alien alien = repo.findById(aid).get();
		m.addAttribute("aliens", alien);
		return "showAliens";
	}
	@GetMapping( "/getAlienByName")
	public String getAlienByName(@RequestParam String aname, Model m) {
		List<Alien> alien = repo.findByAname(aname);
		m.addAttribute("aliens", alien);
		return "showAliens";
	}
	
	@ModelAttribute
	public void modelData(Model model) {
		model.addAttribute("name","Aliens");
	}
	
	

}
