/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttictactoe;

import java.util.Scanner;

/**
 *
 * @author darin
 */
public class TICTACTOE {
   private char[][] tableau;
    private char joueur;

    public TICTACTOE() { //init de tab//init de joueur actu(x ou o)//constructeur
        tableau = new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        joueur = 'X';
    }

    public char[][] getTableau() {
        return tableau;
    }

    public void setTableau(char[][] tableau) {
        this.tableau = tableau;
    }

    public char getJoueur() {
        return joueur;
    }

    public void setJoueur(char joueur) {
        this.joueur = joueur;
    }

    public static void main(String[] args) {
        TICTACTOE jeu = new TICTACTOE(); //instance

        for (int tour = 0; tour < 9; tour++) {
            jeu.affichertableau();  // Afficher l'état actuel de tab
            jeu.jouerTour();        // Permet au joueur actuel de joue un tour
            //verification si le joueur gagné
            if (jeu.estgagnant()) {
                System.out.println("Le joueur " + jeu.getJoueur() + " a gagné !");
                break;
            }
             //verification si le jeu null
            if (jeu.estmatchnul()) {
                jeu.affichertableau();
                System.out.println("Match nul !");
                break;
            }
            jeu.setJoueur((jeu.getJoueur() == 'X') ? 'O' : 'X'); //condition de jouer //Passer à l'autre joueur pour le prochain tour
        }
    }

    public void affichertableau() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tableau[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---------");
            }
        }
    }

    public void jouerTour() {//permet au joueur de fait tour
        Scanner nb = new Scanner(System.in);
        int ligne, colonne;

        do {
            System.out.print("Joueur " + joueur + ", entrez la ligne (0-2) : ");
            ligne = nb.nextInt();
            System.out.print("Joueur " + joueur + ", entrez la colonne (0-2) : ");
            colonne = nb.nextInt();
        } while (tableau[ligne][colonne] != ' ');
//Met a jour le tab avec le tour de joueur
        tableau[ligne][colonne] = joueur;
    }
//verification si le joueur gagné
    public boolean estgagnant() {
        for (int i = 0; i < 3; i++) {
            if ((tableau[i][0] == joueur && tableau[i][1] == joueur && tableau[i][2] == joueur) ||
                    (tableau[0][i] == joueur && tableau[1][i] == joueur && tableau[2][i] == joueur)) {     //le diagonales
                return true;
            }
        }

        return (tableau[0][0] == joueur && tableau[1][1] == joueur && tableau[2][2] == joueur) ||
                (tableau[0][2] == joueur && tableau[1][1] == joueur && tableau[2][0] == joueur);
    }
//verification si le jeu null
    public boolean estmatchnul() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tableau[i][j] == ' ') {        //si il y'a une case vide le match est null
                    return false;
                }
            }
        }
        return true;
    }
}

