/**
 * 
 */
package com.analytics.badmintion.data;

import org.springframework.data.repository.CrudRepository;

import com.analytics.badmintion.beans.Player;

/**
 * @author Arun Ramachandran
 *
 */
public interface PlayerRepository extends CrudRepository<Player, Integer> {

}
