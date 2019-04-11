/**
 * 
 */
package com.analytics.badmintion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.analytics.badmintion.beans.Point;
import com.analytics.badmintion.data.PointRepository;

/**
 * @author Arun Ramachandran
 *
 */
@Controller
@RequestMapping("/baws/point")
public class BAWSPointController {

	@Autowired
	private PointRepository pointRepository;

	/**
	 * @return the pointRepository
	 */
	public PointRepository getPointRepository() {
		return pointRepository;
	}

	/**
	 * @param pointRepository
	 *            the pointRepository to set
	 */
	public void setPointRepository(PointRepository pointRepository) {
		this.pointRepository = pointRepository;
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public @ResponseBody Point getPoint(@PathVariable("id") int id) {
		return pointRepository.findOne(id);
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public @ResponseBody String addPoint(@RequestBody Point point) {
		System.out.println("Player : " + pointRepository);
		pointRepository.save(point);
		return "Saved";
	}
}
