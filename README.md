An diesem Projekt haben gearbeitet:
- Abel
- Bergmaier
- Bruder


# Bonusaufgabe App-Programmierung SS21

## Aufgabe
Erstellen Sie eine Notizapp/TodoApp.
Der Nutzer soll darin neue Notizen erstellen, ansehen und löschen können.
Das Bestehen der Aufgabe gewährt einen Bonus von 20% auf die Klausur.
Sie dürfen die Aufgabe in einer Gruppe von bis zu drei Studierenden lösen.
Schicken Sie Ihre Abgabe an adrian.woerle@hs-karlsruhe.de und alexandros.koufatzis@hs-
karlsruhe.de in Form einer zip-Datei oder als Link zu Ihrem Github-Repo.
Schreiben Sie außerdem die Matrikelnummern und Namen aller Gruppenteilnehmer in der Email dazu.
Sie können innerhalb der Gruppe Ihre App bis zu zweimal abgeben. Wenn sie beim ersten Mal die
Kriterien nicht erfüllt, teilen wir Ihnen das mit und Sie haben einen zweiten Versuch.
Sie müssen das Projekt nur abgeben, nicht präsentieren.
Letzte Abgabemöglichkeit ist der Tag vor der Klausur.

## Funktionalität
•  Ansicht 1: Eine Liste von Notizüberschriften
o  Jedes Listenelement enthält eine Notizüberschrift
o  Sortierung nach Erstellungsdatum absteigend
o  Add-Icon in AppBar, um neue Notiz hinzuzufügen
▪  Zeige dann Ansicht 2
•  Ansicht 2: Erstellen eines neuen Eintrags
o  Ein Dialog über Ansicht 1 (oder reines Fragment)
o  Kann darin Titel und Inhalt eingeben und die Notiz abspeichern
•  Ansicht 3: Detailansicht einer Notiz
o  Titel
o  Inhalt
o  Delete-Icon in AppBar, um Notiz zu löschen
▪  Navigieren dann zu Ansicht 1 zurück
•  Die Notizen sollen in einer Datenbank gespeichert sein.
•  Es reicht, wenn die App für Smartphones konzipiert ist. Es muss keine Layoutanpassung für
Tablets gemacht werden.

### Kriterien zum Bestehen
•  Benutzen sie Kotlin als Programmiersprache
•  Benutzen Sie nur eine Activity.
•  Realisieren Sie die einzelnen Ansichten mit Fragments.
•  Für die Navigation können Sie entweder den FragmentManager oder das Navigation-
### Framework benutzen.
•  Nutzen Sie das MVVM-Architekturmodell (ViewModel und LiveData).
•  Nutzen Sie Room als Datenpersistenz.
•  Nutzen Sie Coroutines zwischen ViewModel und Room
•  Die App muss funktionieren
