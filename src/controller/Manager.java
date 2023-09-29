/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import view.Menu;
import common.Library;
import java.util.ArrayList;
import java.util.Collections;
import model.Country;

/**
 *
 * @author ASUS
 */
public class Manager extends Menu<String>{
    static String[] mc = {"Enter the information for 11 countries in Southeast Asia.", "Display already information.",
        "Search the country according to the entered country's name.",
        "Display the information increasing with the country name.","Exit."};
    
    Library l;
    Country c;
    ArrayList<Country> lc = new ArrayList<>(); 
    public Manager() {
        super("========= Program =========", mc);
        l = new Library();
        c = new Country();
         
    }
    
    public void execute(int n) {
        
        switch (n) {
            case 1: 
                
                InputCountry(lc);
                break;
            case 2: 
                PrintCountry(lc);
                break;
            case 3:
                Search(lc);
                break;
            case 4:
                PrintCountrySorted(lc);
                break;
            case 5: 
                System.out.println("Exit the program successfully!");
                System.exit(0);
                
        }
    } 
    public void InputCountry(ArrayList<Country> lc) {
        System.out.print("Enter code of contry: ");
        String countryCode = l.checkInputString();
        //check code contry exist or not
        if (!checkCountryExist(lc, countryCode)) {
            System.err.println("Country exist.");
            return;
        }
        System.out.print("Enter name of contry: ");
        String countryName = l.checkInputString();
        System.out.print("Enter total area: ");
        double countryArea = l.checkInputDouble();
        System.out.print("Enter terrain of contry: ");
        String countryTerrain = l.checkInputString();
        lc.add(new Country(countryTerrain, countryCode, countryName, countryArea));
        System.err.println("Add successful.");
    }
    
    //display infomation of country
    public void PrintCountry(ArrayList<Country> lc) {
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area",
                "Terrain");
        if (lc!= null){
        for (Country country : lc) {
            country.display(country);
        }
        }else {
            System.out.println("Empty list ");
        }
    }
    
    //allow user search infomation contry by name
    public void Search(ArrayList<Country> lc) {
        System.out.print("Enter the name you want to search for: ");
        String countryName = l.checkInputString();
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area",
                "Terrain");
        for (Country country : lc) {
            if (country.getCountryName().equalsIgnoreCase(countryName)) {
                country.display(country);
            }
        }
    }
    //display infomation sort name in ascending
    public void PrintCountrySorted(ArrayList<Country> lc) {
        Collections.sort(lc);
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area",
                "Terrain");
        for (Country country : lc) {
            country.display(country);
        }
    }

    
    public boolean checkCountryExist(ArrayList<Country> lc, String countryCode) {
        for (Country country : lc) {
            if (country.getCountryCode().equalsIgnoreCase(countryCode)) {
                return false;
            }
        }
        return true;
    }
}
