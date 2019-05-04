/**
 * 
 */
package com.analytics.badmintion.data;

import org.springframework.data.repository.CrudRepository;

import com.analytics.badmintion.beans.Stroke;

/**
 * @author Arun Ramachandran
 *
 */
public interface StrokeRepository extends CrudRepository<Stroke, Integer> {

}
