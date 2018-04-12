package com.example.jonmid.tareasasincronas.Parser;

import com.example.jonmid.tareasasincronas.Models.Post;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonmid on 12/04/18.
 */

public class Json {

    public static List<Post> getData(String content) throws JSONException {

        JSONArray jsonArray = new JSONArray(content);
        List<Post> postList = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++){

            JSONObject item = jsonArray.getJSONObject(i);

            Post post = new Post();
            post.setId(item.getInt("id"));
            post.setTitle(item.getString("title"));
            post.setBody(item.getString("body"));

            postList.add(post);

        }

        return postList;
    }

}
