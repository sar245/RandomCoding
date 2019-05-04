/**
 * 
 */
package com.analytics.badmintion.controller.ui;


import javax.ws.rs.core.Response;

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
	public @ResponseBody Response addPoint(@RequestBody PointFormBean point) {
		System.out.println("Point : " + point);
		 return Response
		            .status(Response.Status.OK)
		            .header("Access-Control-Allow-Origin", "*")
		            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
		            .header("Access-Control-Allow-Credentials", "true")
		            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
		            .header("Access-Control-Max-Age", "1209600")
		            .entity("Saved")
		            .build();
	}

}
