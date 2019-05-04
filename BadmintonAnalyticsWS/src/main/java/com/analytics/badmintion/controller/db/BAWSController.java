/**
 * 
 */
package com.analytics.badmintion.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sars
 *
 */
@Controller
@RequestMapping("/baws")
public class BAWSController {

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody int sayHello(
			@RequestParam(value = "name", required = false, defaultValue = "Stranger") String name) {
	if ("mark".equalsIgnoreCase(name)) {
		return 1;
	}
		return 0;
	}
}
