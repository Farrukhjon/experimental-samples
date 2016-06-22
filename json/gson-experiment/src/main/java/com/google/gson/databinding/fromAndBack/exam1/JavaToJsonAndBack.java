/**
 * 
 */
package com.google.gson.databinding.fromAndBack.exam1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Farrukhjon SATTOROV, Dec 9, 2014
 *
 */
public class JavaToJsonAndBack {
	
	public static void main(String[] args) {
        Albums albums = new Albums();
        albums.title = "Free Music Archive - Albums";
        albums.message = "";
        albums.total = "11259";
        albums.total_pages = 2252;
        albums.page = 1;
        albums.limit = "5";
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        System.out.println(gson.toJson(albums));
         
    }
}
