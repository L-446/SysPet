/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Observable;
import view.jfrmAlterarAdocao;
import view.jfrmAlterarCliente;
import view.jfrmAlterarPet;


public class MessageObservable extends Observable {

    public MessageObservable() {
	
        super();
    }
    public void changeData(Object data) {	
        setChanged(); // the two methods of Observable class
        notifyObservers(data);
    }

    public void addObserver(jfrmAlterarCliente editarCliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addObserver(jfrmAlterarPet editarPet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addObserver(jfrmAlterarAdocao editarAdocao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
