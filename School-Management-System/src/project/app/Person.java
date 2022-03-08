/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.app;

import java.util.ArrayList;
import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author Lenovo
 */
public abstract class Person {
 
private int id ;
private String name;
private int age;

public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
public Person(){}
   abstract public void Add() ;
   abstract public ArrayList Display() ;
   abstract public void Edit() ;
   abstract public void Remove() ;

}
