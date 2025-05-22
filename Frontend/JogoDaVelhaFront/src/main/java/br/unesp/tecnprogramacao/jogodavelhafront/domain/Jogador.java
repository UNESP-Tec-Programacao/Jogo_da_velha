/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unesp.tecnprogramacao.jogodavelhafront.domain;

import java.util.UUID;

/**
 *
 * @author Eduks
 */
public class Jogador {
    
    private UUID id;
    private String user;
    private Boolean jogaAgora;
    private String caractere;
    
    public Jogador(){
        
    }
    
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Boolean getJogaAgora() {
        return jogaAgora;
    }

    public void setJogaAgora(Boolean jogaAgora) {
        this.jogaAgora = jogaAgora;
    }

    public String getCaractere() {
        return caractere;
    }

    public void setCaractere(String caractere) {
        this.caractere = caractere;
    }

    public Jogador(UUID id, String user, Boolean jogaAgora, String caractere) {
        this.id = id;
        this.user = user;
        this.jogaAgora = jogaAgora;
        this.caractere = caractere;
    }

    
}
