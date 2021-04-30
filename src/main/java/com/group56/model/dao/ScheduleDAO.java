package com.group56.model.dao;


import com.group56.model.entity.Schedule;

import java.io.FileNotFoundException;

/**
 * @Description: The data access object layer interface of the file Schedule.json
 *               is used to provide a method for adding, deleting, and modifying
 *               the file.
 * @author Yang Junhan
 * @version V1.0
 * @date 2021/4/5
 */

public interface ScheduleDAO {

    /**
     * @Description: Insert a new schedule record into file.
     * @param schedule: The schedule will be inserted into file.
     * @return boolean: If the operation executed successful, return true.
     *                  if the operation fails, return false.
     */
    public boolean insert(Schedule schedule);

    /**
     * @Description: Delete a schedule.
     * @param scheduleID: The scheduleID of the schedule will be delete.
     * @return boolean: If the operation executed successful, return true.
     *                  if the operation fails, return false.
     */
    public boolean delete(String scheduleID);

    /**
     * @Description: Update a new schedule record into file.
     * @param schedule: The new schedule.
     * @param scheduleID: The id of old schedule.
     * @return boolean: If the operation executed successful, return true.
     *                  if the operation fails, return false.
     */
    public boolean update(Schedule schedule, String scheduleID);

    /**
     * @Description: Select a schedule.
     * @param scheduleID: The scheduleID of schedule will be selected.
     * @return Schedule: Schedule selected by ID.
     */
    public Schedule selectByID(String scheduleID) throws FileNotFoundException;

}
