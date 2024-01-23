package com.example.gestionnairepersonnes;

import com.example.gestionnairepersonnes.models.Categorie;
import com.example.gestionnairepersonnes.models.Personne;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controleur implements Initializable {
    @FXML
    private TextField tfNom;

    @FXML
    private TextField tfAnnee;
    @FXML
    private TextField tfCategorie;

    @FXML
    private ListView lvPersonne;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        StringBinding binding = Bindings.createStringBinding(
                () -> this.computeValue(tfAnnee.getText()),
                tfAnnee.textProperty()
        );

        tfCategorie.textProperty().bind(binding);

        Categorie.chargerFichierTexte("src/main/resources/data/categorie");
        Personne.listObservablePersonne = FXCollections.observableArrayList(new ArrayList<Personne>());
        lvPersonne.setItems(Personne.getListObservablePersonne());

    }

    @FXML
    private void actionEnregistrer(ActionEvent evt) {
        String nom = tfNom.getText();
        String annee = tfAnnee.getText();
        String categorie = tfCategorie.getText();
        Personne.getListObservablePersonne().add(new Personne(nom, annee, categorie));
    }

    /**
     * Renvoie le nom de la catégorie corresondant à l'année prise en argument
     * @param annee de naissance en chaine de caractère
     * @return le libelle de la catégorie correspondante
     */
    private String computeValue(String annee) {
        if (annee != "") {
            int anneeInt = Integer.parseInt(annee);
            return Categorie.getCategorie(anneeInt);
        } else {
            return "";
        }
    }


}