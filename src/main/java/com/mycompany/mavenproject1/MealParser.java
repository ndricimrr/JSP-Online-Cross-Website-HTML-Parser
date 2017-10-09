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

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MealParser {
    public static Document doc ;
    static Day Monday,Tuesday, Wednesday,Thursday,Friday ,Saturday, Sunday;
   
    public MealParser() throws IOException{
        fixAll();   
    }
//    public JavaApplication1() throws IOException{
//       
//    }
  public static void main(String[] args) throws IOException{
      fixAll();    
  }
    public static void fixAll() throws IOException{
        doc = Jsoup.connect("http://kafemud.bilkent.edu.tr/monu_eng.html").get();
        ArrayList<String> dateList = getAllWeekDays();
        ArrayList<String> lunchList = returnLunch();
        ArrayList<String> dinnerList = returnDinner();
        ArrayList<String> secmeliList = returnSecmeli();
        Monday    = new Day();
        Tuesday   = new Day();
        Wednesday = new Day();
        Thursday  = new Day();
        Friday    = new Day();
        Saturday  = new Day();
        Sunday    = new Day();
        
        long startTime = System.nanoTime();
       
        System.out.println("before------------");
      
        for (int i = 0; i < dinnerList.size(); i++){
            // ArrayList<String> date = .get(i));
            ArrayList<String> lunch =  returnDay(lunchList.get(i));
            ArrayList<String> dinner =  returnDay(dinnerList.get(i));
            ArrayList<String> secmeli =  returnDay(secmeliList.get(i));
            
            ArrayList<String> tMondayLunch= new ArrayList<>(), tTuesdayLunch, tWednesdayLunch, tThursdayLunch, tFridayLunch, tSaturdayLunch, tSundayLunch = new ArrayList<>();
            ArrayList<String> tMondayDinner= new ArrayList<>(), tTuesdayDinner, tWednesdayDinner, tThursdayDinner, tFridayDinner, tSaturdayDinner, tSundayDinner = new ArrayList<>();
            ArrayList<String> tMondaySecmeli= new ArrayList<>(), tTuesdaySecmeli, tWednesdaySecmeli, tThursdaySecmeli, tFridaySecmeli, tSaturdaySecmeli, tSundaySecmeli = new ArrayList<>();

           for(int k = 1; k < lunch.size(); k++){//lunch
                String temp ="Not Available";
//               if(lunch.get(k).contains("ejetaryen"))
//                   temp = lunch.get(k).substring(0,lunch.get(k).indexOf("veya / or"));//.substring(0,lunch.get(k).indexOf("/")-1) ;
//               else
                   temp = lunch.get(k);
              //  System.out.println(temp); 
                tMondayLunch.add(temp);
            }
         
            for(int k =1; k < dinner.size(); k++){//dinner
                 String temp ="";//= dinner.get(k).substring(0,dinner.get(k).indexOf("/") );
//                 if(dinner.get(k).contains("ejetaryen")){
//                   temp = dinner.get(k).substring(0,dinner.get(k).indexOf("veya / or"));//.substring(0,lunch.get(k).indexOf("/")-1) ;
//                   //  System.out.println("_"+temp+"_");
//            }
//               else
          
                   temp = dinner.get(k).trim();
               // System.out.println(temp); 
                tMondayDinner.add(temp);
            }
           
            for(int k = 0; k < secmeli.size(); k++){//secmeli
                String temp = secmeli.get(k);
                //System.out.println(temp); 
                tMondaySecmeli.add(temp);
            }
        
            //System.out.println(dateList.get(i));
            String thisDate = dateList.get(i).substring(0,10 );
            if(i == 0){
                Monday.setDate(thisDate);
                Monday.setLunch(tMondayLunch);
                Monday.setDinner(tMondayDinner);
                Monday.setSecmeli(tMondaySecmeli);
            }
            if(i == 1){
                Tuesday.setDate(thisDate);
                Tuesday.setLunch(tMondayLunch);
                Tuesday.setDinner(tMondayDinner);
                Tuesday.setSecmeli(tMondaySecmeli);
            
            }
            if(i == 2){
                Wednesday.setDate(thisDate);
                Wednesday.setLunch(tMondayLunch);
                Wednesday.setDinner(tMondayDinner);
                Wednesday.setSecmeli(tMondaySecmeli);
            }
            if(i == 3){
                Thursday.setDate(thisDate);
                Thursday.setLunch(tMondayLunch);
                Thursday.setDinner(tMondayDinner);
                Thursday.setSecmeli(tMondaySecmeli);
            }
            if(i == 4){
                Friday.setDate(thisDate);
                Friday.setLunch(tMondayLunch);
                Friday.setDinner(tMondayDinner);
                Friday.setSecmeli(tMondaySecmeli);
            }
            if(i == 5){
                Saturday.setDate(thisDate);
                Saturday.setLunch(tMondayLunch);
                Saturday.setDinner(tMondayDinner);
                Saturday.setSecmeli(tMondaySecmeli);
            }
            if(i == 6){
                Sunday.setDate(thisDate);
                Sunday.setLunch(tMondayLunch);
                Sunday.setDinner(tMondayDinner);
                Sunday.setSecmeli(tMondaySecmeli);
            }

        }
         System.out.println("after------------");
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("time is " + duration);

    }
    public ArrayList<String> returnDays(){
        ArrayList<String> temp = new ArrayList<>();
        Day mon = returnMonday();
        Day tue = returnTuesday();
        Day wed = returnWednesday();
        Day thu = returnThursday();
        Day fri = returnFriday();
        Day sat = returnSaturday();
        Day sun = returnSunday();
        // adding monday        
        temp.add("Monday|"+mon.getDate());
            for(int i = 0; i < mon.getLunch().size();i++)
               temp.add(mon.getLunch().get(i));
            temp.add("____________________");
            for(int i = 0; i < mon.getDinner().size();i++)
               temp.add(mon.getDinner().get(i));
            temp.add("____________________");
            for(int i = 0; i < mon.getSecmeli().size();i++)
               temp.add(mon.getSecmeli().get(i));
        temp.add("");
        
        // adding tuesday
        temp.add("Tusday|" +tue.getDate());
            for(int i = 0; i < tue.getLunch().size();i++)
               temp.add(tue.getLunch().get(i));
            temp.add("____________________");
            for(int i = 0; i < tue.getDinner().size();i++)
               temp.add(tue.getDinner().get(i));
            temp.add("____________________");
            for(int i = 0; i < tue.getSecmeli().size();i++)
               temp.add(tue.getSecmeli().get(i));
            temp.add("");
        
        // adding wednesday
        temp.add("Wednesday|" +wed.getDate());
            for(int i = 0; i < wed.getLunch().size();i++)
               temp.add(wed.getLunch().get(i));
            temp.add("____________________");
            for(int i = 0; i < wed.getDinner().size();i++)
               temp.add(wed.getDinner().get(i));
            temp.add("____________________");
            for(int i = 0; i < wed.getSecmeli().size();i++)
               temp.add(wed.getSecmeli().get(i));
            temp.add("");
            
        // adding thursday
        temp.add("Thursday|"+thu.getDate());
            for(int i = 0; i < thu.getLunch().size();i++)
               temp.add(thu.getLunch().get(i));
            temp.add("____________________");
            for(int i = 0; i < thu.getDinner().size();i++)
               temp.add(thu.getDinner().get(i));
            temp.add("____________________");
            for(int i = 0; i < thu.getSecmeli().size();i++)
               temp.add(thu.getSecmeli().get(i));
            temp.add("");
        
        // adding friday
        temp.add("Friday|"+fri.getDate());
            for(int i = 0; i < fri.getLunch().size();i++)
               temp.add(fri.getLunch().get(i));
            temp.add("____________________");
            for(int i = 0; i < fri.getDinner().size();i++)
               temp.add(fri.getDinner().get(i));
            temp.add("____________________");
            for(int i = 0; i < fri.getSecmeli().size();i++)
               temp.add(fri.getSecmeli().get(i));
            temp.add("");
        
        // adding saturday
        temp.add("Saturday|"+sat.getDate());
            for(int i = 0; i < sat.getLunch().size();i++)
               temp.add(sat.getLunch().get(i));
            temp.add("____________________");
            for(int i = 0; i < sat.getDinner().size();i++)
               temp.add(sat.getDinner().get(i));
            temp.add("____________________");
            for(int i = 0; i < sat.getSecmeli().size();i++)
               temp.add(sat.getSecmeli().get(i));
            temp.add("");
        
        // adding sunday
        temp.add("Sunday|"+sun.getDate());
            for(int i = 0; i < sun.getLunch().size();i++)
               temp.add(sun.getLunch().get(i));
            temp.add("____________________");
            for(int i = 0; i < sun.getDinner().size();i++)
               temp.add(sun.getDinner().get(i));
            temp.add("____________________");
            for(int i = 0; i < sun.getSecmeli().size();i++)
               temp.add(sun.getSecmeli().get(i));
            temp.add("");
        
        
        return temp;
    }
   
    public  Day returnMonday(){
        return Monday;
    }
    
    public Day returnTuesday(){
        return Tuesday;
    }
    
    public Day returnWednesday(){
        return Wednesday;
    }
    
    public Day returnThursday(){
        return Thursday;
    }
    
    public Day returnFriday(){
        return Friday;
    }
    
    public Day returnSaturday(){
        return Saturday;
    }
    
    public Day returnSunday(){
        return Sunday;
    }
    
    public static String removeExtraSpaces(String input){
        String temp = input;
        for (int i = input.length()-1; i >0; i--){
            if(input.charAt(i)==' '){
                temp = input.substring(0,i);
            }
            else 
                break;
        }
        return temp;
    }
    
    public static String removeBrackets(String input){
        String temp = input;
        for (int i =0 ; i < input.length(); i++){
            if(input.charAt(i)==')'){
                temp = input.substring(i+1,input.length());
            }
            else 
                break;
        }
        return temp;
    }
    
    
    public static ArrayList<String> returnDay(String str){
        String base = str;
        int start = 0;
        ArrayList<String> list = new ArrayList<>();
        boolean check = true;
        while(check){
            int temp =  base.indexOf("\n", start);
            if(temp < 0 ){
                 check = false;
                break;
            }
            
            if(removeExtraSpaces(base.substring(start, temp)).length()>2)
            list.add(removeExtraSpaces(base.substring(start, temp)));
          //  System.out.println("["+ removeExtraSpaces(base.substring(start, temp))+"]");
            start = temp+2;
        }
        return list;
    }
      
    public static ArrayList<String> getAllWeekDays(){
        Elements element = doc.select("table");
        Elements rows = element.get(0).select("tr");
        ArrayList<String> list = new ArrayList<>();
        for (Element row: rows){
            if(row.select("td").size() == 3 && !row.select("td").text().contains("DAYS"))
                list.add(row.select("td").get(0).text());
             
           }
        return list;
    }
    
    public static ArrayList<String> returnLunch(){
        Elements element = doc.select("table");
        Elements rows = element.get(0).select("tr");
        ArrayList<String> list = new ArrayList<>();
        for (Element row: rows){
             if(row.select("td").size() == 3 && !row.select("td").text().contains("DISHES") ){//lunch
                Element elm = row.select("td").get(1);
                String str =  Jsoup.parse(elm.toString().replaceAll("(?i)<br[^>]*>", "br2n")).text();   
                String str2 = str.replaceAll("br2n", "\n");
                  if(str2.contains("veya") && str2.contains("rian)")){
                    str2 = str2.substring(0,str2.indexOf("veya"))+ str2.substring(str2.indexOf("rian)")+5,str2.length());
                      System.out.println("_____" +str2 + "____");
                 }
                  else if(str2.contains("veya") && !str2.contains("rian)")){
                         str2 = str2.substring(0,str2.indexOf("veya"))+ str2.substring(str2.indexOf("rian")+4,str2.length());
                  }
                list.add(str2 + "\n");
                
            }         
        }
           //printArrayList(list);
        return list;
    }
   public static String trimEnd( String myString ) {

    for ( int i = myString.length() - 1; i >= 0; --i ) {
        if ( myString.charAt(i) == ' ' ) {
            continue;
        } else {
            myString = myString.substring( 0, ( i + 1 ) );
            break;
        }
    }
    return myString;
}
    public static ArrayList<String> returnDinner(){
        Elements element = doc.select("table");
        Elements rows = element.get(0).select("tr");
        ArrayList<String> list = new ArrayList<>();
        for (Element row: rows){
            if(row.select("td").size() == 2  && row.select("td").text().contains("inner")  ){//dinner
                Element elm =row.select("td").get(0);
                String str =  Jsoup.parse(elm.toString().replaceAll("(?i)<br[^>]*>", "br2n")).text();   
                String str2 = str.replaceAll("br2n", "\n");
                if(str2.contains("veya")){
                    // System.out.println("_______"+str2+"______");
                    // String p1 = str2.substring(0,str2.indexOf("veya"));
                     //String p2 = str2.substring(str2.indexOf("rian)")+5,str2.length()).trim();
                     // System.out.println("|s-------"+trimEnd(p1)+"-------e|");
                     //  System.out.println("-------"+p2+"-------");
                    str2 = str2.substring(0,str2.indexOf("veya"))+ removeBrackets(str2.substring(str2.indexOf("arian")+5,str2.length()));
                   
                }
                //    System.out.println("here =" + str2 +"__");
               
                    list.add(str2.trim() + "\n");
              //  System.out.println(str);
            }
        }
                  // printArrayList(list);
        return list;
    }
    
    public static ArrayList<String> returnSecmeli(){
        Elements element = doc.select("table");
        Elements rows = element.get(0).select("tr");
        ArrayList<String> list = new ArrayList<>();
        for (Element row: rows){              
            if(row.select("td").size() == 2 && !row.select("td").text().contains("Karbonhidrat") &&  !row.select("td").text().contains("DISHES")){
                Element elm = row.select("td").get(1);
                String str =  Jsoup.parse(elm.toString().replaceAll("(?i)<br[^>]*>", "br2n")).text();   
                String str2 = str.replaceAll("br2n", "\n");
                list.add(str2 + "\n");
            }
        }
               //    printArrayList(list);
        return list;
    }
    
    public static ArrayList<String> returnEnergy(){
        Elements element = doc.select("table");
        Elements rows = element.get(0).select("tr");
        ArrayList<String> list = new ArrayList<>();
        for (Element row: rows){
            if(row.select("td").size() == 3 ){
                list.add(row.select("td").get(2).text());
            }
           }
        return list;
    }
    
    public static ArrayList<String> returnTest(){
        Elements element = doc.select("table");
        Elements rows = element.get(0).select("tr");
        ArrayList<String> list = new ArrayList<>();
        for (Element row: rows){
//            if(row.select("td").size() == 3 ){
//                list.add(row.select("td").get(0).text());
//            }
             if(row.select("td").size() == 3 && !row.select("td").text().contains("DISHES")){//lunch
                Element elm = row.select("td").get(1);
                String str =  Jsoup.parse(elm.toString().replaceAll("(?i)<br[^>]*>", "br2n")).text();   
                String str2 = str.replaceAll("br2n", "\n");
                list.add(str2 + "\n");
            }
             
              if(row.select("td").size() == 2 && row.select("td").text().contains("am Yem")){//dinner
                  //list.add(row.select("td").get(0).text());
                Element elm =row.select("td").get(0);
                String str =  Jsoup.parse(elm.toString().replaceAll("(?i)<br[^>]*>", "br2n")).text();   
                String str2 = str.replaceAll("br2n", "\n");
                list.add(str2 + "\n");
              }
              
              if(row.select("td").size() == 2 && !row.select("td").text().contains("Karbonhidrat")){
                Element elm = row.select("td").get(1);
                String str =  Jsoup.parse(elm.toString().replaceAll("(?i)<br[^>]*>", "br2n")).text();   
                String str2 = str.replaceAll("br2n", "\n");
                list.add(str2 + "\n");
                
            }
            }
            return list;
        }  
      
    public static void printArrayList(ArrayList<String> list){
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
    }
}   

