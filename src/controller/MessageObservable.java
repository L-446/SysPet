/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Observable;


public class MessageObservable extends Observable {

    public MessageObservable() {
	
        super();
    }
    public void changeData(Object data) {	
        setChanged(); // the two methods of Observable class
        notifyObservers(data);
    }
}
