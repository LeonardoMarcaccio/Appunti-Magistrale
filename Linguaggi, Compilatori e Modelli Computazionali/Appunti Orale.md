# Analisi Lessicale e Sintattica, Intro

## Fasi di un Compilatore

- Scannerizzazione (**Analisi Lessicale**)
- Parsing (**Analisi Sintattica**)
- Type Checking (**Analisi Semantica**)
- Ottimizzazione
- Generazione del Codice

## Analisi Lessicale

Principale attività effettuata dal ***Lexer***, consite nel suddividere il codice ricevuto in **Unità Atomiche del Linguaggio** denominate **Token**.

## Analisi Sintattica

Una volta comprese le **Componenti Atomiche** del codice è necessario capirne la **Struttura**.
Ciò avviene grazie all'uso di un **Diagramma ad Albero**, l'**Abstract Syntaxx Tree**.

## Stuttura di un Compilatore

- **Lexer** :
  - Preso in Input del codice, uno **Stream di Caratteri**, effettua l'**Analisi Lessicale** ritornando uno **Stream di Token**.
- **Parser** :
  - Preso in input lo **Stream di Token** del **Lexer**, effettua l'**Analisi Sintattica** del codice generando un'**AST**.
- **Checker** :
  - Effettua l'**Analisi Semantica** dell'**AST**, aggiungendo informazioni come **Tipo** e **Dichiarazione**.
- **Generatore di Codice**

---

# Come costruire un Lexer

L'obbiettivo principale di un **Lexer** è quello di effettuare l'**Analisi Lessicale** del codice, perciò è necessario che questo sia in grado di:
- Dividere l'input in sottostringhe significative denominate **Lessemi**, ovvero **Token non ancora catalogati**.
- Classificare i **Lessemi** individuati in base al loro **Ruolo**, ovvero trasformarli in **Token**.

In generale, quando si converte un **Lessema** in **Token**, i **Lessemi Whitespace**, vengono "**Abbandonati**".

Inoltre, alcuni **Token** possono possedere degli **Attributi** come:
- Il **Lessema** originale
- La **Linea di Codice** di appartenenza

## Lexer

Per costruire un **Lexer** si utilizza un **Lexer Generator**, ovvero un costruttore che, fornite le **Specifiche Lessicali** del linguaggio (**Lessemi** e **Token**), genera codice in grado di effettuare la **Partizione**.

## Maximal Match Rule

La **Maximal Match Rule** è una regola utilizzata nel contesto dell'**Analisi Lessicale**, questa regola stabilisce che

<center><i>Il <b>Flusso di Caratteri</b> in input deve essere suddiviso in <b>Lessemi</b> che siano il <b>più grandi possibile</b></i></center>

## Lexer Dichiarativi

Sono composti da due parti:

- ***~~~ Il Cosa ~~~***
**Dichiarativa**, descrive ogni **Token** come un **Automa Finito** o, meglio, come un'**Espressione Regolare**, che deve essere fornito per ogni **Lessema**, ciò specifica le **Proprietà Lessicali** del linguaggio di input.

- ***~~~ Il Come ~~~***
**Imperativa**, collega questi automi in un **Automa Lessicale** comune a tutti i **Lessemi**, come una libreria, ed è responsabile della **Meccanica della Scansione**.

## Lexer Interamente Dichiarativi

La distinzione tra un **Lexer Dichiarativo** e uno **Full Dichiarativo** riguarda il grado di automazione e la gestione delle complessità intrinseche dell'analisi lessicale.

La costruzione di un **Lexer Full Dichiarativo** risulta essere molto simile a quella di uno **Dichiarativo**:
- Specificare un **Automa** per ogni **Lessema**
- Unirli nell'**Automa del Lexer**
- Se l'automa ottenuto è un **NFA**, tradurlo in un **DFA**
- Introdurre il concetto di **Maximal Match Rule**

L'introduzione di questo **Look-ahead** è **Unbounded**, ovvero può leggere un qualsiasi numero di caratteri.

## Problematiche dei Lexer

- **Ambiguità** :
  - Il **Lexer** può raggiungere più **Stati Finali** contemporaneamente
  - **Soluzione**: Aggiunta di un Livello di Priorità
- **Errori di Input** :
  - **Lessemi Illegali** causano errori
  - **Soluzione**: Creare un nuovo **Lessema** che accetti qualsiasi stringa e gli venga data **Priorità Mininima**.

## Lexere Generator

Prendono in input un'**Espressione Regolare** che descrive il **Linguaggio**.

Come implementare i DFA in un contesto di programmazione?

Attraverso una matrice dove le colonne rapresentano i possibili **Input**, mentre le righe rappresentano i vari **Stati** dell'automa.

---

# Parser

Il **Parser** svolge principalmente due compiti:
- **Syntax Checking**:
  Verifica se la sequenza di **Token** ricevuta dal **Lexer** è **corretta rispetto alle regole del Linguaggio**.
  Se incontra un errore, rifiuta il programma e fornisce informazioni sul problema riscontrato.
- **Costruzione dell'AST**:
  Organizza i token in una struttura gerarchica chiamata **Parse Tree**, che viene poi solitamente semplificato in un **Abstract Syntax Tree** (**AST**) per le fasi successive.

Gli **Automi a Stati Finiti** usati dai **Lexer** non sono sufficienti per questo compito perché **non possono gestire strutture Ricorsivamente Annidate di profondità arbitraria**.

## Parse Tree VS Abstract Syntax Tree

- ***Parse Tree***
  - Il Parse Tree è una rappresentazione ad albero che illustra la **Struttura Sintattica**, di una frase o di un'espressione.
  - Contiene al suo interno **TUTTI** i **Token**, inclusi quelli utilizzati solo in fase di "**Scoperta**"
  - **Sintassi Concreta**
- ***AST***
  - Rimuove tutti gli elementi non necessari abbassando la **Gerarchia dell'Albero**
  - **Sintassi Astratta**

---

# Parsing Top-down

Questo approccio cerca di costruire l'**Albero** partendo dalla **Radice**, il **Simbolo Iniziale della Grammatica**, verso le **foglie**, i **Token**.

## Recursive Descent Parsing

Il **Recursive Descent Parsing** è una strategia di **Analisi Sintattica Top-Down** che costruisce le derivazioni di una stringa partendo dalla radice dell'albero verso le foglie.

Il parser calcola le **Derivazioni Leftmost** provando ogni **Produzione della Grammatica** in ordine continuando finché la **Stringa Derivata** non corrisponde all'**Input** o finché non si verifica un **Errore di Corrispondenza** (**Mismatch**).

In caso di errore, il parser esegue il **Backtracking**: torna indietro nel flusso di input alla posizione precedente e prova una produzione alternativa per lo stesso simbolo non terminale.

### Problematiche

Questo algoritmo non può gestire **Grammatiche con Ricorsione a Sinistra**, poiché entrerebbe in un **Loop Infinito**, quindi la ricorsione a sinistra deve essere trasformata in **Ricorsione a Destra** prima di implementare il parser.

L'approccio al probleme risulta essere estremamente inefficente.

## Parser Predittivi

I **Parser Predittivi** rappresentano un'**evoluzione dei Parser Recursive Descent** e appartengono alla categoria del **Parsing Top-Down**.

La loro caratteristica distintiva è la capacità di "***Predire***" esattamente quale produzione della grammatica espandere guardando semplicemente i **Token Successivi nell'Input**, eliminando così la necessità del **Backtracking**.

I **Parser Predittivi** usano una classe di grammatiche denominate LL(k):
- ***Left-to-right***: Scansionano l'input da sinistra verso destra.
- ***Leftmost derivation***: Costruiscono una derivazione leftmost.
- ***k***: Indica il numero di **Token di Lookahead** necessari per prendere una decisione.

Per far si che un **Parser** predittivo possa funzionare correttamente, la grammatica deve:
- **Essere non ambigua** (Deve esserci al massimo una produzione valida).
- **Assenza di Ricorsione a Sinistra**.
- **Fattorizzazione a Sinistra (*Left Factoring*)**:
  I prefissi comuni tra le produzioni dello stesso non-terminale devono essere isolati (es. trasformare T→int∣int∗T in T→intY e Y→∗T∣ϵ) per permettere al parser di decidere quale ramo prendere solo quando i prefissi sono terminati.

## LL(1) Parser

Un **Parser LL(1)** è un tipo di parser predittivo che appartiene alla categoria dell'analisi sintattica top-down.

Il **Parser LL(1)** non usa lo **Stack delle Chiamate di Sistema** come il **Recursive Descent**, ma si affida a due strutture esplicite:
- **Tabella di Parsing (2D)**:
  Una matrice dove le **Righe** rappresentano i **Simboli Non-Terminali** e le **Colonne** i **Terminali**.
  Ogni **cella** contiene l'unica produzione da applicare in quel contesto.
- **Stack di Analisi**:
  Viene utilizzato per memorizzare i **Simboli** che il **parser deve ancora elaborare**.
  Inizialmente contiene il **Simbolo Iniziale della Grammatica** seguito dal **Simbolo di Fine Input $**.

### L'Algoritmo di Parsing
Il parser segue questi passaggi ripetitivamente finché lo stack non è vuoto:
- **Confronto in cima allo stack**:
  - Se in cima allo stack c'è un **Terminale**, il parser verifica se corrisponde al **Token corrente nell'Input**.
  Se coincidono, rimuove il terminale dallo stack e avanza nell'input, altrimenti segnala un errore.
  - Se in cima allo stack c'è un **non-terminale**, il parser consulta la **Tabella di Parsing**.
- **Azione sulla tabella**:
  - Se trova una **Produzione**, la rimuove dallo stack e lo sostituisce con la sequenza Y1​…Yn​.
  - Se la **Cella è Vuota**, significa che la stringa in input non è sintatticamente corretta.
- **Successo**: L'input è accettato se lo stack viene svuotato completamente e il parser ha raggiunto la fine della stringa di token.

## Dichiarazione Associativa

Una **Dichiarazione Associativa** è un meccanismo utilizzato nei **Generatori di Parser** per risolvere le **Ambiguità Sintattiche** di una grammatica senza doverla riscrivere interamente.

L'**Associatività** stabilisce la **Direzione** in cui un operatore deve essere raggruppato quando compare più volte consecutivamente in un'espressione.

---

# Parsing Bottom-Up

Il **Bottom-Up Parsing** è una strategia di **Analisi Sintattica** che costruisce l'albero di analisi partendo dalle foglie, i **Token dell'Input**, verso la radice, il **Simbolo Iniziale della Grammatica**.

## Chaotic Bottom-Up Parser

L'algoritmo segue questi **passaggi in modo non strutturato**:
- **Osservazione**:
  Si guarda l'intera **Stringa di Input** $s$, potendo analizzare qualsiasi punto della stessa.
- **Ricerca**:
  Si cerca all'interno della stringa una **sottostringa** $r$ che corrisponda alla **Parte Destra di una Produzione della Grammatica**.
- **Riduzione**:
  Si riduce la **sottostringa** trovata sostituendola con il suo **non-terminale** $N$.
- **Verifica**:
  Se l'intera **stringa** è stata ridotta al **simbolo iniziale della grammatica**, l'analisi è completata con successo e si è ottenuto il parse tree, altrimenti si ricomincia dal punto 1.

### Il Problema della "Fortuna"

Il limite principale di questo approccio è che **non garantisce il Successo anche se la Stringa è Corretta**, infatti il risultato dipende interamente dalla "fortuna" nel **scegliere la sequenza corretta di riduzioni**.

## Non-Deterministic Chaotic Parser

Per superare il problema della scelta, l'algoritmo viene reso non-deterministico:
- Invece di scegliere una riduzione, il parser individua tutte le riduzioni possibili in quel momento.
- Crea una copia di se stesso (un'istanza) per ogni possibile riduzione applicabile.
- L'analisi ha successo se almeno un'istanza riesce a ridurre la stringa al simbolo iniziale.

### Problematiche del Non-Deterministic Chaotic Parser

- **Esplosione di Complessità a livello Esponenziale**
- Più istanze possono realizzare il giusto parse tree, sprecando risorse.

## Non-Deterministic LR Parser

Il **Non-Deterministic LR Parser** è un'evoluzione del modello di parsing "caotico" che introduce **regole rigide** per limitare l'esplosione delle istanze e rendere l'analisi più strutturata.

### Regole di Restrizione

Per funzionare, questo parser impone due limitazioni fondamentali:
- **Divisione dell'input**:
  L'input viene diviso in due parti:
    - **Parte Destra** non ancora esaminata
    - **Parte Sinistra** che è già stata processata dal parser.
- **Riduzioni Localizzate**:
  Le **Riduzioni** sono permesse solo sulla parte adiacente destra alla divisione.
  Questo significa che la **Parte Sinistra** della stringa può essere gestita efficientemente tramite uno **stack**, dove le riduzioni avvengono esclusivamente sulla **cima** dello stesso.

### Azioni del Parser

Il parser opera scegliendo in modo non deterministico tra due azioni principali:
- **Shift**:
  Sposta il punto di divisione verso destra, muovendo un nuovo token dall'input sulla cima dello stack. Questa azione può potenzialmente abilitare nuove riduzioni.
- **Reduce**:
  Sostituisce una sequenza di simboli sulla cima dello stack con il corrispondente simbolo non terminale, proprio come avviene nel parser caotico ma con il vincolo della posizione.


