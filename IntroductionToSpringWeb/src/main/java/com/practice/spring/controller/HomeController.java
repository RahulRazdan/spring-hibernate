package com.practice.spring.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.practice.spring.api.Player;
import com.practice.spring.model.MusicBox;
import com.practice.spring.model.ProfilePicture;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	Player player;
	
	@Autowired
	MusicBox musicBox;
	
	@Value("#{37 % 10}")
	Double testSPL;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("PlayerType", player.getPlayerType());
		model.addAttribute("MusicType", musicBox.getType());
		musicBox.getArguementType(100);
		model.addAttribute("testSPL", testSPL);
		model.addAttribute("profilePicture", new ProfilePicture());
		
		return "home";
	}
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String pricessRegistration(@Validated ProfilePicture profilePicture,Model model){
		if(profilePicture.getPicture()!=null && profilePicture.getPicture().getSize() > 0)
			model.addAttribute("fileName", profilePicture.getPicture().getOriginalFilename());
		
		return "home";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(@RequestParam(value="error", required=false) boolean error, HttpServletResponse response,
			ModelMap model) throws IOException {
		if (error) {
			model.addAttribute("error", "Error while authenticating given user.");
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		}
		return "loginpage";
	}
	
}
