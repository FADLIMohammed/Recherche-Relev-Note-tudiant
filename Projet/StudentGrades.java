package Projet;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Paramétré pour stocker les numéros d'appogee uniques
        Set<String> student_Nm_apgs = new HashSet<>();

        // Demander à l'utilisateur le nombre d'étudiants
        System.out.print("Entrez le nombre d'étudiants : ");
        int numStudents = Integer.parseInt(input.nextLine());

        // Parcourez chaque élève et demandez des informations
        for (int s = 1; s <= numStudents; s++) {
            String Nm_Apg;
            do {
                System.out.print("Entrez le numéro d' appogee de l'étudiant: ");
                Nm_Apg = input.nextLine();
            } while (student_Nm_apgs.contains(Nm_Apg)); // Vérifier si nm_apg existe déjà
            student_Nm_apgs.add(Nm_Apg); 

            System.out.print("Entrer le nom d'etudiant : ");
            String name = input.nextLine();

            // Demander à l'utilisateur des notes dans n matières
            System.out.print("Entrez le nombre de matieres : ");
            int numMatieres= Integer.parseInt(input.nextLine());

            Map<String, Double> Matieres_Notes = new HashMap<>();
            for (int i = 0; i < numMatieres; i++) {
                System.out.print("Entrez le nom du matiere " + (i+1) + ": ");
                String matiere_name = input.nextLine();
                System.out.print("Entrez la note pour " + matiere_name + ": ");
                double note= Double.parseDouble(input.nextLine());
                Matieres_Notes.put(matiere_name, note);
            }

            // Enregistrer les informations et les notes des étudiants dans un fichier
            try {
                FileWriter writer = new FileWriter("Projet/student_grades.txt", true);
                writer.write(Nm_Apg + "," + name + ",");
                for (String subjectName : Matieres_Notes.keySet()) {
                    double note= Matieres_Notes.get(subjectName);
                    writer.write(subjectName + ":" + note + ",");
                }
                writer.write("\n"); // Ajouter une nouvelle ligne pour la prochaine entrée
                writer.close();
                System.out.println("Informations sur les étudiants et notes enregistrées dans un fichier.");
            } catch (IOException e) {
                System.out.println("Une erreur s'est produite lors de l'écriture dans le fichier.");
                e.printStackTrace();
            }
        }

        input.close();
    }
}
