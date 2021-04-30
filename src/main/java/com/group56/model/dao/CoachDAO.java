package com.group56.model.dao;


import com.group56.model.entity.Coach;

/**
 * @Description: The data access object layer interface of the file Coach.json
 *               is used to provide a method for adding, deleting, and modifying
 *               the file.
 * @author Yang Junhan
 * @version V1.0
 * @date 2021/4/5
 */

public interface CoachDAO {
    /**
     * @Description: Insert a new coach record into file.
     * @param coach: The coach will be inserted into file.
     * @return boolean: If the operation executed successful, return true.
     *                  if the operation fails, return false.
     */
    public boolean insert(Coach coach);

    /**
     * @Description: Delete a coach.
     * @param coachID: The coachID of the coach will be delete.
     * @return boolean: If the operation executed successful, return true.
     *                  if the operation fails, return false.
     */
    public boolean delete(String coachID);

    /**
     * @Description: Update a new coach record into file.
     * @param coach: The new content of the coach .
     * @param coachID: The id of coach will be updated.
     * @return boolean: If the operation executed successful, return true.
     *                  if the operation fails, return false.
     */
    public boolean update(Coach coach, String coachID);

    /**
     * @Description: Select a coach.
     * @param coachID: The coachID of coach will be selected.
     * @return The coach selected by ID.
     */
    public Coach selectByID(String coachID);

}
