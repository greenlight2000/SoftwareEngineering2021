package com.group56.model.dao.Impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.group56.model.dao.VideoDAO;
import com.group56.model.entity.Video;
import com.group56.model.tools.jsonFileProcessor;

import java.util.ArrayList;

public class VideoDAOImpl implements VideoDAO {

    public boolean insert(Video video) {
        jsonFileProcessor file = new jsonFileProcessor("/Users/wangyunkun/学校/大三下/Software Engineering/Course Work/records/Video.json");
        StringBuffer buffer = file.read();
        ArrayList<Video> records = new ArrayList<Video>();
        if (!buffer.toString().equals("")) {
            records = new Gson().fromJson(buffer.toString(), new TypeToken<ArrayList<Video>>() {}.getType());
        }
        records.add(video);
        return file.rewrite(records);
    }

    public boolean delete(String name) {
        jsonFileProcessor file = new jsonFileProcessor("/Users/wangyunkun/学校/大三下/Software Engineering/Course Work/records/Video.json");
        StringBuffer buffer = file.read();
        if (!buffer.toString().equals("")) {
            ArrayList<Video> records = new Gson().fromJson(buffer.toString(), new TypeToken<ArrayList<Video>>(){}.getType());
            for (Video v : records)
                if (v.getName().equals(name)){
                    records.remove(v);
                    return file.rewrite(records);
                }
        }
        return false;
    }

    public boolean update(Video video, String name) {
        if (delete(name))
            return insert(video);
        return false;
    }

    public Video selectByName(String name) {
        StringBuffer buffer = new jsonFileProcessor("/Users/wangyunkun/学校/大三下/Software Engineering/Course Work/records/Video.json").read();
        if (!buffer.toString().equals("")) {
            ArrayList<Video> records = new Gson().fromJson(buffer.toString(), new TypeToken<ArrayList<Video>>(){}.getType());
            for (Video v : records)
                if (v.getName().equals(name))
                    return v;
        }
        return null;
    }
    public int length(){
        StringBuffer buffer = new jsonFileProcessor("/Users/wangyunkun/学校/大三下/Software Engineering/Course Work/records/Video.json").read();
        ArrayList<Video> records = null;
        if (!buffer.toString().equals("")) {
            records = new Gson().fromJson(buffer.toString(), new TypeToken<ArrayList<Video>>() {
            }.getType());
        }
        if (records != null)
            return records.size();
        else
            return 0;
    }
    public ArrayList<Video> Total(){
        StringBuffer buffer = new jsonFileProcessor("/Users/wangyunkun/学校/大三下/Software Engineering/Course Work/records/Video.json").read();
        ArrayList<Video> records = null;
        if (!buffer.toString().equals("")) {
            records = new Gson().fromJson(buffer.toString(), new TypeToken<ArrayList<Video>>() {
            }.getType());
        }
        return records;
    }
}
