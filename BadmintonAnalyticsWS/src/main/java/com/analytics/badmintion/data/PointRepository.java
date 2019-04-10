/**
 * 
 */
package com.analytics.badmintion.data;

import org.springframework.data.repository.CrudRepository;

import com.analytics.badmintion.beans.Point;

/**
 * @author Arun Ramachandran
 *
 */
public interface PointRepository extends CrudRepository<Point, Integer> {

}
