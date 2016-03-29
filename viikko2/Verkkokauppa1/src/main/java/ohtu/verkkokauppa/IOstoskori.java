/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.verkkokauppa;

/**
 *
 * @author arto
 */
public interface IOstoskori {

    int hinta();

    void lisaa(ITuote t);

    void poista(ITuote t);
    
}
