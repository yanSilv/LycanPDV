/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Visao.TelaPdv;

/**
 *
 * @author jaguar
 */
public class ConDataHora implements Runnable {
    TelaPdv tela;
    ConUtil util;
    
    public ConDataHora (TelaPdv tela) {
        this.tela = tela;
    }
    
    public void run () {
        util = new ConUtil();
        
        while(true){
            this.tela.setjLData(util.getDateTime(0));
            this.tela.setjLHora(util.getDateTime(1));
        }
    }
    
}
