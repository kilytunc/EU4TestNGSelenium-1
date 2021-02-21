package com.cybertek.tests.reviews;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProviderReview {

    @DataProvider
    public Object [][] movieData(){
        String [][] data = {
                {"Chernobyl","9"},
                {"See","8"},
                {"Dark","9"},
                {"Akbar Show","10"},
                {"OOP with OZZY","10"}
        };


        return data;
    }


    @Test(dataProvider = "movieData")
    public void test01(String tvShow,String rating){

        System.out.println("Tv show: "+tvShow + "rating: "+rating);

    }
}
