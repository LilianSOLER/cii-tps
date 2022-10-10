Benjamin Bracquier - Lilian Soler

# TP 1 - Grapher avec Java/Swing

- Le but de ce TP est d'apprendre à programmer une application interactice avec la boîte à outils Swing de Java. Vous
  allez réaliser un visualisateur du graphe d'une fonction. Dans un premier temps vous vous familiariserez avec le
  modèle graphique 2D de Swing. Vous rendrez ensuite le visualisateur interactif en utilisant différentes techniques (
  e.g., widgets, manipulation directe).

---

## Interaction graphique

3. Ajouter une classe Interaction pour permettre l'interaction à la souris avec le graphique (voir les Listeners
   [MouseListener](https://docs.oracle.com/javase/9/docs/api/java/awt/event/MouseListener.html)
   et [MouseMotionListener](https://docs.oracle.com/javase/9/docs/api/java/awt/event/MouseMotionListener.html)
   —éventuellement réalisés
   par [MouseInputAdapter](https://docs.oracle.com/javase/9/docs/api/javax/swing/event/MouseInputAdapter.html) —
   et [MouseWheelListener](https://docs.oracle.com/javase/9/docs/api/java/awt/event/MouseWheelListener.html) :

- le drag, bouton gauche enfoncé, doit permettre de déplacer le repère, avec une petite main à la place du curseur par
  défaut pendant l'interaction (voir la classe Cursor) (TODO)
- le drag, bouton droit enfoncé, doit permettre de sélectionner une zone rectangulaire marquée par un rectangle
  pointillé, pour zoomer sur cette sélection lorsque le bouton est relâché (TODO)
- le clic gauche (resp. droit) permette de zoomer (resp. dézoomer) de 5%, centré sur le curseur (DONE)
- la molette (ou le drag bouton du milieu) doit permettre de zoomer ou dézoomer, centré sur le curseur. (DONE)

---

## Placement

4. Rendez la liste des fonctions visibles dans une bande redimensionnable à gauche de la
   fenêtre ([JSplitPane](https://docs.oracle.com/javase/9/docs/api/javax/swing/JSplitPane.html)
   , [JList](https://docs.oracle.com/javase/9/docs/api/javax/swing/JSplitPane.html)). (DONE)

--- 

## Interaction avec la liste

5. Faites en sorte que les fonctions sélectionnées dans la liste soient affichées en gras sur le graphique. (TODO)
6. Permettez la suppression des fonctions sélectionnées et l'ajout de nouvelles fonctions grâce à une barre de
   boutons ([How to Use Tool Bars](http://java.sun.com/docs/books/tutorial/uiswing/components/toolbar.html)
   et [JToolBar](https://docs.oracle.com/javase/9/docs/api/javax/swing/JToolBar.html)
   , [AbstractAction](https://docs.oracle.com/javase/9/docs/api/javax/swing/AbstractAction.html)
   , [JOptionPane](https://docs.oracle.com/javase/9/docs/api/javax/swing/JOptionPane.html)). (TODO)

- Le programme résultant pourra ressembler à cette capture :

- ![Capture d'écran](http://iihm.imag.fr/blanch/info4/IHM/tps/1-grapher/img-00.png)