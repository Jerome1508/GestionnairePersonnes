/*
 * Application Gestionnaire de Personnes                                                              23/01/2024
 * TP Java Avancé : Rattrapage
 * 3il Ingenieur Rodez
 */
package com.example.gestionnairepersonnes.models;

import javafx.beans.Observable;
import javafx.collections.ObservableList;

/**
 * Cette classe permet de mémoriser les personnes avec leur nom, leur année de naissance
 * et leur catégorie
 * @author Jerôme CHIROL
 * @version 1.0.0
 */
public class Personne {
    private String annee;
    private String nom;
    private String categorie;
    private ObservableList<Personne> listObservablePersonne;

    public Personne(String nom, String annee, String categorie) {
        this.annee = annee;
        this.nom = nom.toUpperCase();
        this.categorie = categorie;

    }

    @Override
    public String toString() {
        return this.nom + " " + this.annee + " " + this.categorie;
    }


}
