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

## SLR

**SLR** (o **Simple LR**) è una versione semplificata del **Parsing LR** regolata da una **Tabella di Parsing** e che utilizza **Informazioni di Lookahead** per decidere in modo **deterministico** tra le azioni di ***Shift*** e ***Reduce***.

### Struttura

1. L'**Automa SLR** (DFA):
Il cuore dell'algoritmo è un automa a stati finiti deterministico (DFA) chiamato automa SLR.
Questo automa:
  - Indica quali sono le configurazioni dello stack corrette.
  - Detta quando eseguire le azioni di shift e reduce.
  - Viene costruito utilizzando i cosiddetti SLR Items.
2. **SLR Items** e **Operazione di Chiusura**
Un **SLR Item** è una **Produzione Grammaticale** con un punto (∙) in una posizione specifica della parte destra, nella forma **$X→α∙β$**.
Il **punto** indica quanto della produzione è **già stato analizzato e si trova in cima allo Stack**.
L'operazione di **Closure** viene usata per estendere il contesto di uno stato **aggiungendo tutte le possibili produzioni che potrebbero seguire il punto**.
3. Azioni del Parser
Basandosi sullo stato corrente del DFA e sul token di input, il parser SLR decide tra quattro azioni:
  - **Shift**:
  Se c'è una **transizione uscente su un terminale**, il token viene spostato **dall'input allo stack** e **il parser cambia stato**.
  - **Reduce**:
  Se il punto è alla fine di una regola (**$X→α∙$**), il parser **sostituisce la sequenza** **$α$** in cima allo stack **con il non-terminale** **$X$**.
  - **Goto**:
  **Transizioni basate su variabili non-terminali** che avvengono dopo una riduzione.
  - **Accept**:
  L'**input viene accettato** quando viene **ridotta la produzione iniziale speciale** (**$E^′→E$**).

### Risoluzione dei Conflitti con il Lookahead

La caratteristica "Simple" di SLR risiede nel modo in cui **gestisce i Conflitti**, ovvero situazioni in cui l'automa permetterebbe sia uno shift che una riduzione.

Un **Parser SLR(1)** esegue una riduzione **$X→α$** solo se il **Token corrente nell'Input**, ovvero il **Lookahead** appartiene all'insieme dei **Follow della Variabile** (Follow($X$)).

L'insieme **Follow($X$)** contiene tutti i **terminali che possono apparire immediatamente dopo** **$X$** **in una Derivazione Valida**.

Se ogni cella della tabella di parsing risultante contiene al massimo un'azione, la grammatica è definita **SLR(1)**.

### Rappresentazione Tabellare

Per efficienza, il DFA viene solitamente implementato come una tabella 2D dove le **righe** sono gli **Stati** e le **colonne** sono divise in **Terminali** (**Tabella delle Azioni**) e **Non-Terminali** (**Tabella Goto**).

---

# Analisi Semantica

L'**Analisi Semantica** è l'ultima fase del front-end di un compilatore ed ha il compito di **individuare tutti gli errori che non possono essere rilevati dall'Analisi Lessicale o Sintattica**.

## Tipici Errori Semantici

I **tipici Errori Semantici** riscontrati nei programmi includono:
- **Dichiarazioni Multiple**:
  Si verifica quando una **Variabile** viene **dichiarata più di una volta all'interno dello stesso Scope**.
  I linguaggi di programmazione impongono solitamente che **ogni Nome sia Univoco nel proprio Contesto**.
- **Variabili non dichiarate**:
  Questo errore avviene quando il codice tenta di **utilizzare una Variabile che non è stata ancora Definita**.
  Mentre alcuni elementi (come i nomi dei metodi in Java) possono apparire prima della loro definizione, **le Variabili devono solitamente essere Dichiarate prima del loro Utilizzo**.
- **Incompatibilità di tipo** (**Type mismatch**):
  È uno degli errori più comuni e si manifesta quando **il Tipo di un'Espressione non corrisponde a quello richiesto dal Contesto**. Un esempio classico è l'assegnamento in cui il tipo della parte sinistra non coincide con quello della parte destra.
- **Numero o Tipo Errato di Argomenti**:
  Avviene quando un metodo o una funzione viene chiamata passando un numero di parametri diverso da quello previsto, oppure quando i tipi degli argomenti passati non corrispondono alla firma del metodo.

## Simple Semantic Analyzer

Il **Sistema di Analisi Semantica** utilizza solitamente un **Analizzatore** che opera in due fasi principali visitando l'**Abstract Syntax Tree (AST) creato dal parser**:

1. **Generazione dell'AST Arricchito** (Top-down)
Questa fase viene eseguita con una visita dall'alto verso il basso per ogni **Scope** del programma.
Gli obiettivi principali sono:
  - **Elaborazione delle Dichiarazioni**:
  Per ogni **Dichiarazione di Variabile o Metodo**, l'analizzatore aggiunge una nuova voce nella **Symbol Table** e viene **Segnalato ogni Errore Semantico di Dichiarazione Multipla**.
  - **Elaborazione delle Istruzioni**:
  L'analizzatore **Identifica gli Usi delle Variabili** e **Verifica che non siano Variabili Non Dichiarate**.
  - **Arricchimento dell'AST**:
  nei **nodi "ID"** dell'albero, che **rappresentano l'Uso di un Identificatore**, viene aggiunto un **Puntatore alla Voce Corrispondente nella Symbol Table**.
  Una volta collegati tutti gli usi alle rispettive dichiarazioni, i nomi testuali possono essere "dimenticati" poiché le informazioni necessarie sono ora contenute nei puntatori alle voci della tabella.

2. Seconda Fase: Type Checking (Bottom-up)
Una volta arricchito l'albero, l'analizzatore esegue una seconda visita, questa volta dal basso verso l'alto.
- **Determinazione dei Tipi**:
Utilizzando le informazioni precedentemente provenienti dalla **Symbol Table**, l'analizzatore **determina il Tipo di ogni singola Espressione**.
- **Verifica degli Errori di Tipo**:
L'analizzatore controlla che **le Operazioni siano valide per i Tipi Coinvolti**.

## Symbol Table

La **Symbol Table** è una struttura dati fondamentale utilizzata dal compilatore per tenere traccia di tutti i nomi dichiarati all'interno di un programma.

Può essere vista come una **Mappa che associa ogni Nome a una voce specifica contenente le sue Caratteristiche**.

I **Nomi** possono far riferimento a:
- **Variabili**
- **Classi**
- **Campi**
- **Metodi**

### Syymbol Table Entry

Per ogni **Identificatore** (o **Nome**), la tabella memorizza un insieme di attributi necessari per le fasi successive del compilatore:
- **Natura del Nome**: se si tratta di una variabile, un campo, un metodo o una classe.
- **Tipo**: ad esempio int, float, o la firma di un metodo (dominio e codominio).
- **Livello di Annidamento** (Nesting level): fondamentale per gestire gli scope.
- **Locazione di Memoria o Offset**: dove l'elemento sarà reperibile a runtime.

### Scoping

Il concetto di **Scoping** definisce l'**Insieme di Regole** che **determinano come l'uso di un nome all'interno di un programma venga associato alla sua corrispondente dichiarazione**.

In sostanza, **le regole di scoping mappano ogni occorrenza di un identificatore alla definizione corretta**.

Esistono due approcci principali per gestire la visibilità dei nomi:
- **Scoping Statico** (o **Lessicale**):
  - È il modello utilizzato da linguaggi come Java e C++, in cui **la Mappatura tra Uso e Dichiarazione avviene a Tempo di Compilazione**, si basa quindi sulla **Struttura Testuale del Codice**.
  - **Regola del "Most Closely Nested"**:
  <center>
    L'uso di una <b>variabile <i>x</i></b> corrisponde alla <b>dichiarazione</b> di <b><i>x</i></b> nello <b>Scope</b>  più vicino che racchiude l'uso stesso.
  
    <b>Una dichiarazione in uno scope interno "nasconde" quella con lo stesso nome in uno scope esterno.</b>
  </center>
- **Scoping Dinamico**:
  - Utilizzato da linguaggi come Lisp o APL, in cui la risoluzione dei nomi avviene a runtime.
  - **Un riferimento a una variabile non locale corrisponde alla dichiarazione presente nella funzione chiamata più recentemente che è ancora attiva.**
  - È generalmente considerato meno sicuro dello statico perché rende il codice difficile da comprendere e un singolo uso di variabile può corrispondere a dichiarazioni di tipo diverso a seconda del flusso di esecuzione.

riguarda slide 12
