/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author Ndricim Rrapi
 */
import java.util.ArrayList;

/**
 *
 * @author Ndricim Rrapi
 */
public class Day {
    private String date;
    private ArrayList<String> lunch;
    private ArrayList<String> dinner;
    private ArrayList<String> secmeli;
    
    public Day(){
        
    }
    
    public Day(String date, ArrayList<String> lunchList,ArrayList<String> dinnerList,ArrayList<String> secmeliList){
        setDate(date);
        setLunch(lunchList);
        setDinner(dinnerList);
        setSecmeli(secmeliList);
    }
    
    public void setAll(String date, ArrayList<String> lunchList,ArrayList<String> dinnerList,ArrayList<String> secmeliList ){
        setDate(date);
        setLunch(lunchList);
        setDinner(dinnerList);
        setSecmeli(secmeliList);
    }
    public void setDate(String str){
        this.date = str;
    }
    
    public String getDate(){
        return date;        
    }

     public void setLunch(ArrayList<String> list){
        this.lunch = list;
    }
    
    public ArrayList<String> getLunch(){
        return lunch;        
    }   
    
     public void setDinner(ArrayList<String> list){
        this.dinner = list;
    }
    
    public ArrayList<String> getDinner(){
        return dinner;        
    }   
    
    public void setSecmeli(ArrayList<String> list){
        this.secmeli = list;
    }
    
    public ArrayList<String> getSecmeli(){
        return secmeli;        
    }   
}

