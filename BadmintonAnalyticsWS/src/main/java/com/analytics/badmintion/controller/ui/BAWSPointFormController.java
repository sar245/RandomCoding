/**
 * 
 */
package com.analytics.badmintion.controller.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.analytics.badmintion.beans.PointFormBean;

/**
 * @author Arun Ramachandran
 *
 */
@Controller
@RequestMapping("/baws/ui/point")
public class BAWSPointFormController {

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public @ResponseBody String addPoint(@RequestBody PointFormBean point) {
		System.out.println("Point : " + point);
		return "Saved";
	}

}
