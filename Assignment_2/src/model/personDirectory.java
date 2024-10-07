/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.ArrayList;
/**
 *
 * @author Lenevo
 */
public class personDirectory {
    private ArrayList<person> personList;
    
    public personDirectory() {
        this.personList= new ArrayList<person>() ;
    }

    public ArrayList<person> getpersonList() {
        return personList;
    }

    public void setListPerson(ArrayList<person> ListPerson) {
        this.personList = personList;
    }
    
    public person addPerson() {
        
        person person = new person();
        personList.add(person);
        return person;
        
    }
    
    public void deletePerson(person person) {
        personList.remove(person);
    }
    
    
    public person searchPerson(String searchPerson) {
        for (person person : personList) {
        
            if (person.getHomeAddress().getStreet().contains(searchPerson) ||
                    person.getWorkAddress().getStreet().contains(searchPerson) ||
                    person.getLastName().contains(searchPerson) ||
                    person.getFirstName().contains(searchPerson)) {
            
                return person;
            }
        }
        return null; 
    }

    
        
      
    }

