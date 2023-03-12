package Projet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentInfoSearch extends JFrame implements ActionListener {
    private final JTextField nm_apg_Field;
    private final JTextField nom_etudiant_Field;
    private final JTextArea result_area;
    private final JButton Recherche_button;

    private final Map<String, Map<String, String>> Etudiants;

    public StudentInfoSearch() {
        super("Recherche d'informations sur les étudiants ");

        // Charger les informations sur les élèves du fichier 
        Etudiants = new HashMap<>();
        try {
            File file = new File("Projet/student_grades.txt");
            Scanner fileInput = new Scanner(file);
            while (fileInput.hasNextLine()) {
                String line = fileInput.nextLine();
                String[] tokens = line.split(",");
                String nm_apg = tokens[0];
                String name = tokens[1];
                Map<String, String> MatiereNotes= new HashMap<>();
                for (int i = 2; i < tokens.length; i++) {
                    String[] subjectGradeTokens = tokens[i].split(":");
                    String subjectName = subjectGradeTokens[0];
                    String grade = subjectGradeTokens[1];
                    MatiereNotes.put(subjectName, grade);
                }
                Etudiants.put(nm_apg, new HashMap<String, String>() {{
                    put("name", name);
                    put("Matiere_Note", MatiereNotes.toString());
                }});
            }
            fileInput.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
        JLabel apgLabel = new JLabel("Entrer numéro d'apogée d'étudiant : ");
        nm_apg_Field = new JTextField(10);
        JLabel nameLabel = new JLabel("Entrer le prenom d'etudiant : ");
        nom_etudiant_Field = new JTextField(20);
        Recherche_button = new JButton("Rechercher");
        Recherche_button.addActionListener(this);
        result_area = new JTextArea(10, 40);
        result_area.setEditable(false);

        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(apgLabel);
        inputPanel.add(nm_apg_Field);
        inputPanel.add(nameLabel);
        inputPanel.add(nom_etudiant_Field);
        inputPanel.add(Recherche_button);

        JScrollPane scrollPane = new JScrollPane(result_area);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(inputPanel, BorderLayout.NORTH);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Recherche_button) {
            String nmd_apg_àtrouver = nm_apg_Field.getText();
            String name_àtrouver = nom_etudiant_Field.getText();
            if (nmd_apg_àtrouver.isEmpty() && name_àtrouver.isEmpty()) {
                result_area.setText("Vous devez saisir un numero d'appogee ou un nom.");
                return;
            }
            boolean trouvé = false;
            for (Map.Entry<String, Map<String, String>> entry : Etudiants.entrySet()) {
                String n_apg = entry.getKey();
                Map<String, String> Info_Etudiant = entry.getValue();
                String name = Info_Etudiant.get("name");
                if (!nmd_apg_àtrouver.isEmpty() && n_apg.equals(nmd_apg_àtrouver) ||
                        !name_àtrouver.isEmpty() && name.equalsIgnoreCase(name_àtrouver)) {
                    String Matiere_Note = Info_Etudiant.get("Matiere_Note");
                    result_area.setText("Numero d'appoge : " + n_apg + "\n" +
                            "Name: " + name + "\n" + "Matieres Notes : " + Matiere_Note);
                            trouvé = true;
                            break;
                        }
                    }
                    if (!trouvé) {
                        result_area.setText("Étudiant introuvable.");
                    }
                }
            }
        
            public static void main(String[] args) {
                new StudentInfoSearch();
            }
        }
        
