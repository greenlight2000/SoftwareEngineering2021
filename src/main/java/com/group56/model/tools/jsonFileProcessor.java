package com.group56.model.tools;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;

import java.io.*;
import java.util.ArrayList;

@AllArgsConstructor
public class jsonFileProcessor {

    private String path;

    private void createFile(){
        File file = new File(path);
        File fileParent = file.getParentFile();
        if (!fileParent.exists())
            fileParent.mkdirs();
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public StringBuffer read(){
        File file = new File(path);
        if (!file.exists())
            createFile();
        StringBuffer buffer = new StringBuffer();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            while (true){
                String content= reader.readLine();
                if(content!=null)
                    buffer.append(content);
                else
                    break;
            }
            reader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
        }
        return buffer;
    }

    public boolean rewrite(ArrayList content){
        File file = new File(path);
        try {
            FileWriter writer = new FileWriter(file);
            String json = new Gson().toJson(content);
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }



}
