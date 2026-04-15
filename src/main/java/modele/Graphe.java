package modele;

import java.util.*;

import org.javatuples.Pair;

public class Graphe {
    private String fichier;
    private Map<Integer, Set<Integer>> sommets;

    /**
     * Constructeur de Graphe qui prend en paramètre un fichier, et un ensemble contenant les sommet et leurs voisins.
     * @param file Un objet de type String, qui est le nom du fichier à utiliser
     * @param nodes Un objet de type Map, contenant les sommets en clés et l'ensemble de leurs voisins en valeurs.
     */
    public Graphe (String file, Map <Integer, Set<Integer>> nodes){
        this.fichier = file;
        this.sommets = nodes;
    }


    public Map<Integer, Set<Integer>> getSommets() {
        return sommets;
    }

    /**
     * Retourne le nombre de sommet du graphes, l'odre
     * @return int
     */
    public int ordre(){
        return sommets.size();
    }

    /**
     * Retourne le nombre de voisin du sommet entré en paramètre, son degré
     * @param sommet
     * @return int
     */
    public int degre( int sommet){
        return sommets.get(sommet).size();
    }

    /**
     * Retourne la taille du graphe this
     * @return int
     */
    public int taille(){
        int somme_degre = 0;
        for (int s : sommets.keySet()){
            somme_degre+= sommets.get(s).size();
        }

        return somme_degre/2;
    }
    /**
     * Methode retournanr un tuple contenant le degré minimum et maximum du graphe
     * @return un objet de type Pair
     */
    public Pair degreMinDegreMax(){
        int min = sommets.get(0).size(); // On initialise la taille min
        for(int s : sommets.keySet()){
            if (sommets.get(s).size()<min) min = sommets.get(s).size();
        }

        int max = sommets.get(0).size();
        for(int s : sommets.keySet()){
            if (sommets.get(s).size()>max) max = sommets.get(s).size();
        }

        return new Pair<Integer, Integer>(min,max);
    }

    public static Graphe grapheComplet(int n){
        TreeMap<Integer, Set<Integer>> l_voisins =  new TreeMap<Integer, Set<Integer>>();

        for(int i = 0 ; i<n ; i++) l_voisins.put(i, new TreeSet<Integer>());

        for(int i = 0 ; i<n ; i++){
            for (int j = 0 ; j<n ;j++ ){
                if (j != i) l_voisins.get(i).add(j);
            }
        }

        return new Graphe("Graphe Complet d'odre "+n,l_voisins);
    }

    public static Graphe cycle(int n){
        TreeMap<Integer, Set<Integer>> l_voisins =  new TreeMap<Integer, Set<Integer>>();

        for(int i = 0 ; i<n ; i++) l_voisins.put(i, new TreeSet<Integer>());

        for(int i = 0 ; i<n ; i++){
                if (i == 0) {
                    l_voisins.get(i).add(n-1);
                    l_voisins.get(i).add(i+1);
                } else if (i == n-1) {
                    l_voisins.get(i).add(i-1);
                    l_voisins.get(i).add(0);
                }
                else {l_voisins.get(i).add(i-1); l_voisins.get(i).add(i+1);}
        }

        return new Graphe("Cycle d'ordre : "+n,l_voisins);

    }

    public TreeMap<Integer,Pair<Integer,Integer>> parcoursEnLargeur(int depart){

        TreeMap<Integer,Pair<Integer,Integer>> predecesseurs = new TreeMap<Integer, Pair<Integer, Integer>>();
        predecesseurs.put(depart,new Pair(-1,0));

        //La file d'attente des sommets à examiner
        ArrayList <Integer> fileAttentes = new ArrayList();
        fileAttentes.add(depart);

        while (!fileAttentes.isEmpty()){
            int courant = fileAttentes.remove(0);
            for(Integer voisin : sommets.get(courant)){
                if(! predecesseurs.containsKey(voisin)){
                    predecesseurs.put(voisin,
                            new Pair(courant,predecesseurs.get(courant).getValue1()+1));

                    fileAttentes.add(voisin);

                }
            }
        }

        return predecesseurs;

    }

    /**
     * Affiche le conteny de la Map dans un string
     * @return String
     */
    public String toString() {
        String affichage ="";
        String ordre = "Ordre "+ordre();
        String degres = "Degré min : "+degreMinDegreMax().getValue(0) +" -- Degré max : "+degreMinDegreMax().getValue(1);
        String taille = "Taille "+taille();

        affichage += "Fichier : "+fichier+"\n"+ordre+" - "+taille+"\n"+degres+"\n";

        for (int s : sommets.keySet()){
            String ligne = "Sommet "+s+" — degré "+degre(s)+", voisins : "+sommets.get(s)+"\n";
            affichage += ligne;
        }

        return affichage;

    }


}
