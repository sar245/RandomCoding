/**
 * 
 */
package com.analytics.badmintion.controller.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.analytics.badmintion.beans.Point;
import com.analytics.badmintion.beans.Stroke;
import com.analytics.badmintion.data.PointRepository;
import com.analytics.badmintion.data.StrokeRepository;

/**
 * @author Arun Ramachandran
 *
 */
@Controller
@RequestMapping("/baws/point")
public class BAWSPointController {

	@Autowired
	private PointRepository pointRepository;

	@Autowired
	private StrokeRepository strokeRepository;

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

	/**
	 * @return the strokeRepository
	 */
	public StrokeRepository getStrokeRepository() {
		return strokeRepository;
	}

	/**
	 * @param strokeRepository
	 *            the strokeRepository to set
	 */
	public void setStrokeRepository(StrokeRepository strokeRepository) {
		this.strokeRepository = strokeRepository;
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public @ResponseBody Point getPoint(@PathVariable("id") int id) {
		return pointRepository.findOne(id);
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public @ResponseBody String addPoint(@RequestBody Point point) {
		System.out.println("point : " + point);
		pointRepository.save(point);

		for (Stroke stroke : point.getStrokes()) {
			stroke.setPointId(point.getPointId());
			System.out.println("Stroke : " + stroke);
		}
		strokeRepository.save(point.getStrokes());
		return "Saved";
	}
}
