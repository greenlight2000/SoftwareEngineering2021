package com.group56.model.dao;

import com.group56.model.entity.Video;

import java.util.ArrayList;

/**
 * @Description: The data access object layer interface of the file Video.json
 *               is used to provide a method for adding, deleting, and modifying
 *               the file.
 * @author Yang Junhan
 * @version V1.0
 * @date 2021/4/3
 */

public interface VideoDAO {

    /**
     * @Description: Insert a record about a video.
     * @param video :The video will be inserted into record.
     * @return boolean: If the operation executed successful, return true.
     *                  if the operation fails, return false.
     */
    public boolean insert(Video video);

    /**
     * @Description: Delete a record about a video.
     * @param name: The name of the video will be delete.
     * @return boolean: If the operation executed successful, return true.
     *                  if the operation fails, return false.
     */
    public boolean delete(String name);

    /**
     * @Description: Update a record about a video.
     * @param video: The new video record.
     * @param name: The name of old schedule.
     * @return boolean: If the operation executed successful, return true.
     *                  if the operation fails, return false.
     */
    public boolean update(Video video, String name);

    /**
     * @Description: Select a video by its name.
     * @param name: The name of schedule will be selected.
     * @return Video: Video selected by name.
     */
    public Video selectByName(String name);

    public int length();
    public ArrayList<Video> Total();

}