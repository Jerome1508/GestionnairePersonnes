/*
 * Application Gestionnaire de Personnes                                                              23/01/2024
 * TP Java Avancé : Rattrapage
 * 3il Ingenieur Rodez
 */
package com.example.gestionnairepersonnes.models;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe permet de mémoriser les différentes catégories d'âge
 * @author Jerôme CHIROL
 * @version 1.0.0
 */
public class Categorie {
    private int ageMini;
    private int ageMaxi;
    private String libelle;



    private static ArrayList<Categorie> listCategorie;

    /**
     * @param ageMini age minimum de la catégorie
     * @param ageMaxi age maximum de la catégorie
     * @param libelle nom de la catégorie
     */
    public Categorie(int ageMini, int ageMaxi, String libelle) {
        this.ageMini = ageMini;
        this.ageMaxi = ageMaxi;
        this.libelle = libelle;
    }

    /**
     * Renvoie true si l'age pris en argument est compris entre agemini et ageMaxi
     * @param age à tester
     * @return le seuil inférieur de l'applicaion du taux
     */
    public boolean correspond (int age) {
        return age >= ageMini && age <= ageMaxi;
    }

    /**
     * @return le libelle de la categorie
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * @return la liste des catégories
     */
    public static ArrayList<Categorie> getListCategorie() {
        return listCategorie;
    }


    @Override
    public String toString() {
        return this.libelle;
    }

    /**
     * Calcul l'âge en fonction de l'année courrante
     * et renvoie le libelle de la categorie correspondante
     * @param anneeNaissance de naissance
     * @return l'age en fonction de l'annee courrante
     * @throws IllegalArgumentException si l'annee de naissance ne correspond a aucune categorie
     */
    public static String getCategorie(int anneeNaissance) {
        LocalDateTime ldt = LocalDateTime.now();
        int anneeCourrante = ldt.getYear();
        int age = anneeCourrante - anneeNaissance;
        Categorie aReturn = null;
        for (Categorie c : listCategorie) {
            if (c.correspond(age)) {
                aReturn = c;
            }
        }
        if (aReturn != null) {
            return aReturn.getLibelle();
        } else {
            throw new IllegalArgumentException("Cette annee de naissance ne correspond a aucune categorie");
        }
    }

    /**
     * Lit un fichier texte contenant des catégories
     * et crée un Objet Categorie pour chaque ligne du fichier
     * puis les ajoute dans la liste static
     * @param nomFichier contenant les catégories
     */
    public static void chargerFichierTexte (String nomFichier) {
        // on creer la liste si elle n'est pas déjà crée
        if (listCategorie == null) {
            listCategorie = new ArrayList<Categorie>();
        }
        // On récupère les données du fichier
        try {
            BufferedReader lecteur = new BufferedReader(new FileReader(nomFichier));
            String ligne;
            while ((ligne = lecteur.readLine()) != null) {
                int ageMini = Integer.parseInt(ligne.split(" ")[0]);
                int ageMaxi = Integer.parseInt(ligne.split(" ")[1]);
                String libelle = ligne.split(" ")[2];
                listCategorie.add(new Categorie(ageMini, ageMaxi, libelle));
            }
            lecteur.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        // On affiche la liste sur la console
        System.out.println("taille liste : " + listCategorie.size());
        System.out.println(listCategorie.toString());
    }
}
