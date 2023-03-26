# Recherche-Relev-Note-tudiant
Recherche Relevé Note Étudiant
Projet IHM : relevé de note d'un étudiant après une

recherche par le nom de l'étudiant ou son numéro

d'apogée de note d'un étudiant

*réalisé par :* Mohammed fadli
              * Hajar Benkhadra  
  
**Présentation de projet

Ce projet sera faciliter le travail des enseignants lors de la la pose
des notes finaux car il implémente une application qui permet de
faire une recherche sur les notes d'étudiant , et pour pour faciliter
l'utilisation de cette application on a utilisée la bibliothèque Swing
pour la création d'une interface graphique facile à comprendre.

tous d'abord pour que l'utilisateur peut faire la recherche il faut
entrer le nom et numéro d'apogée de l'étudiant et cliquer sur
Rechercher après ça il sera afficher une tableau qui contient les
matières et ces notes. le projet permet aussi de sauvegarder les
informations du l'étudiant au début dans un fichier qui sont le
numéro d' apogée, le nom ,le nombre de matières pour que après
l'utilisateur peut rechercher sur un étudiant a travers ces
informations. Et si le nom et le numéro d'apogée que l'utilisateur
a entrée pour la recherche n'existent pas dans le fichier il sera
afficher que cet étudiant est indisponible.

# Présentation de l'interface graphique

![image](https://user-images.githubusercontent.com/120965149/227809980-3938056a-7012-426e-976f-f9801197a9a9.png)
  
on est divisée l'interface en deux partie chaque partie contient un
panneau JPanel . la premier est appelé inputPanel , dans lequel
on a deux Labels qui contiennent Informations importantes pour
guider l'utilisateur et deux champs de texte pour entrer le nom et
le numéro d'apogée pour la recherche , un bouton rechercher
pour la recherche , ces composants sont répartis par gestionnaire
de répartition FlowLayout .
La deuxième est appelé crollPane de type JScrollPane contient
un TextArea pour l'affichage de resultat. ces panneaux sont
répartis par gestionnaire de répartition BorderLayout .  
  
Explication du code source
Ce code est écrite en langage de programmation Java avec
Swing pour faciliter la Compréhension chez utilisateur.
.
Nous avons créé deux classes ,la premier est appelé
StudentGrades a travers laquelle on entre tous les informations
d'étudiant se forme console et on les stocke dans un fichier qui est
appelé "Projet/student_grades.txt" .

La deuxième est appelé StudentInfoSearch a travers laquelle on
récupère les informations correspondant à celui saisi par
l'utilisateur et on les affiche .

pour les méthodes on utilise une seul méthode " actionPerformed "
de l’interface écouteur " ActionListener " et on le redéfinit .
