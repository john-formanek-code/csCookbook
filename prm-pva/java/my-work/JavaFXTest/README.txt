JAVA FX POČÍTADLO (+, −, RESET)
==============================

Připraveno pro tvůj existující projekt "JavaFXTest" v Eclipse.

OBSAH:
  src/app/Main.java              - spouští JavaFX okno
  src/app/CounterController.java - logika tlačítek
  src/app/counter.fxml           - vzhled okna
  src/module-info.java           - nastavení JavaFX modulů

JAK POUŽÍT:
1. Rozbal ZIP.
2. V Eclipse otevři svůj existující projekt "JavaFXTest".
3. Do jeho složky "src" zkopíruj obsah složky "src" z archivu.
   Stávající Main.java a counter.fxml přepiš, CounterController.java přidej.
4. Pokud už máš upravený module-info.java, není nutné ho nahrazovat.
   Jen zkontroluj, že obsahuje:
      requires javafx.controls;
      requires javafx.fxml;
      opens app to javafx.fxml;
   Pokud původní modul používá jiné jméno, zachovej ho.
5. V Eclipse dej pravým na projekt > Refresh (F5).
6. Spusť app.Main jako Java Application (stejně jako dřív).

VYŽADUJE:
Java 17+ a JavaFX, které už máš ve svém běžícím Eclipse projektu nastavené.
Archiv neobsahuje JavaFX knihovny; používá nastavení tvého projektu.
