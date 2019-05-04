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

import com.analytics.badmintion.beans.Player;
import com.analytics.badmintion.data.PlayerRepository;

/**
 * @author asubramanian
 *
 */
@Controller
@RequestMapping("/baws/player")
public class BAWSPlayerController {

	@Autowired
	private PlayerRepository playerRepository;

	/**
	 * @return the playerRepository
	 */
	public PlayerRepository getPlayerRepository() {
		return playerRepository;
	}

	/**
	 * @param playerRepository
	 *            the playerRepository to set
	 */
	public void setPlayerRepository(PlayerRepository playerRepository) {
		this.playerRepository = playerRepository;
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public @ResponseBody Player getPlayer(@PathVariable("id") int id) {
		return playerRepository.findOne(id);
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public @ResponseBody String addPlayer(@RequestBody Player player) {
		System.out.println("Player : " + player);
		playerRepository.save(player);
		return "Saved";
	}
}
