package com.wahyu.latihan3;

import org.json.JSONException;
import org.json.JSONObject;

public class User {

    String Id;
    String Name;
    String Pass;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    User(JSONObject obj){
        try {
            String Id = obj.getString("id");
            String Name = obj.getString("user");
            String Pass = obj.getString("pass");

            this.Id = Id;
            this.Name = Name;
            this.Pass = Pass;

            /*Id = Ids;
            Name = Names;
            Pass = Passs;*/

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

}
