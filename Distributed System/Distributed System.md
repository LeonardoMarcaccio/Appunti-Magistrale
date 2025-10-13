# Introduction

## Cos'è un Sistema Distribuito

Una tipologia di **Sistema Informatico** costituito da un insieme di **Processi Interconnessi** tra loro in cui **le comunicazioni avvengono solo esclusivamente tramite lo scambio di opportuni messaggi**.

Ogni **Nodo del Sistema** esegue un insieme di **Componenti** che comunicano tra di loro utilizzando uno **Strato Software** detto ***Middleware*** che permette all'utente di percepire il sistema come un'unica entità.

Con il termine **Processo** si indica una qualsiasi **Entità** capace di comunicare con un qualsiasi altro processo e di eseguire un algoritmo distribuito.

## Fallimenti all'interno dei Sistemi Distribuiti

Essere in grado di provvedere al servizio a discapito di fallimenti, è uno dei principali punti di forza che i sistemi distribuiti hanno rispetto ai sistemi centralizzati.

I **Sistemi Distribuiti** possono essere progettati in modo che, se un **componente** del sistema si **guasta**, si **disconnette** o viene **partizionato**, altri **componenti** possano **sostituirlo** in modo da nascondere i guasti al mondo esterno o almeno da ridurne l'impatto.

Quando un Sistema riesce a nascondere la maggior parte dei suoi fallimenti possiamo definirlo come ***High Available***.

## Cosa ci si deve aspettare da un Sistema Distribuito in caso di Fallimento

Che siano **Coerenti**, vorremmo che si comportassero correttamente, che forniscano risposte corrette quando interrogati.

Che siano **Disponibili**, vorremmo che siano pronti a funzionare senza interruzioni.

Tuttavia, sappiamo che i sistemi possono effettivamente subire interruzioni di corrente, crash, guasti di rete, perdita di messaggi, attacchi dannosi e così via, e risultare inaffidabili.

## The CAP Theorem

Secondo il ***CAP Theorem***, nelle **Applicazioni Distribuite** è possibile fornire contemporaneamente solo due delle tre seguenti proprietà:

- **Coerenza** (C) = I dati replicati sono sempre coerenti tra loro
- **Disponibilità** (A) = I dati sono altamente disponibili per gli utenti
- **Tolleranza di Partizione** (P) = Il sistema può continuare a fornire servizi ai suoi utenti anche quando le partizioni di rete

## Availability

Affinché un **Sistema Distribuito** sia costantemente **disponibile**, ogni **Richiesta** ricevuta da un **Nodo** non guasto nel sistema deve **generare una Risposta**.

## Consistency

Un **Servizio Coerente** è modellato come un **Oggetto Dati Atomico** in cui le **Operazioni** sono **totalmente ordinate** e ogni **Operazione** avviene in un **singolo istante di tempo**.

Qui, il significato di coerente è diverso dalle proprietà ACID, poiché comprende sia A che C.

## Network partition

Quando una **Rete** è **Partizionata**, tutti i **Messaggi** inviati dai **Nodi** di un componente della partizione ai nodi di un altro componente vengono persi e qualsiasi schema di perdita di messaggi può essere modellato come una partizione temporanea che separa i nodi comunicanti nell'istante esatto in cui il messaggio viene perso.

# Teorema

Nel **Modello di Rete Asincrona** è impossibile implementare un **Oggetto Dati di Lettura/Scrittura** che garantisca **Disponibilità** e **Coerenza Atomica** in tutte le esecuzioni corrette.

### Ipotesi

- **Atomicita**, **Disponibilità**, e la **Tolleranza alle Partizioni** sono già tutte soddisfatte.
- I **Nodi** nel nostro **Network** possono essere **Partizionati** in due **Gruppi Disconnessi** e **non Vuoti** $G_1$ e $G_2$.
- Un **Oggetto Atomico** $o$ ha **Valore Iniziale** $v_0$
- L'oggetto $o$ dovrebbe essere **consistente** tra $G_1$ e $G_2$.
- $α_1$ esegue una **singola Scrittura** $v_1\not=v_0$ di $o$ in $G_1$.
- $α_1$ è l'**unica Richiesta** al momento.
- Durante $α_1$, **nessuno Messaggio** da $G_1$ a $G_2$ o viceversa.
- $α_2$ esegue una **singola Lettura** di $o$ in $G_2$.
- Durante $α_2$, **nessun Messaggio** da $G_1$ a $G_2$ o viceversa.

### Dimostrazione per Assurdo

A causa della **Disponibilità**, $α_1$ termina quindi $v0 → v1$, e anche $α_2$ termina, ma eseguendo $α_1$ e $α_2$, $G_2$ vede solo $α_2$, e deve ritornare $v_0$.
Ciò viola il principio di **Consistenza**.

## Soluzioni a questa problematica

Quando avviene una **Partizione**, un **Sistema Distribuito** deve scegliere un **Tradeoff** tra **Consistenza** e **Disponibilità**, mentre, quando non c'è una partizione, un sistema può avere sia **Consistenza** che **Disponibilità**.

## ACID vs. BASE

La **ACID** (***Atomicity, Consistency, Isolation, and Durability***) semantica
può risultare troppo stringente.

Come alternativa a ciò si può usare **BASE** o ***Basically Available Soft state Eventual consistency***.

I **Dati obsoleti** possono essere ancora **temporaneamente Tollerati**, fin tanto che questi **Dati** diventeranno **Consistenti** a breve.

Il **Soft State**, che può essere generato a scapito di **calcoli aggiuntivi** o **I/O su file**, viene sfruttato per **migliorare le prestazioni**, **i dati non sono durevoli**"

**Risposte approssimative**, basate su **Dati obsoleti** o **Soft State incompleto**,fornite rapidamente possono essere più preziose di risposte esatte.

---

# Dependability in Distributed Systems

## Prologo

I **Sistemi Distribuiti** sono fondamentali per società, governi, imprese e individui e la dipendenza da questi rende essenziale la loro **Affidabilità (*Dependability*)**.

I **Guasti** hanno **costi enormi**, anche garantire **alta Affidabilità** è **costoso**, nasce dunque la necessità di formare ingegneri capaci di progettare **Sistemi Distribuiti Affidabili**.

---

## Dependability & Faults (Affidabilità e Guasti)

### Definizioni

- ***Dependability*** : Capacità di un **Sistema Distribuito** di fornire **Servizi corretti nonostante minacce** come bug software, guasti hardware, attacchi.
- ***Fault*** (Guasto): causa di un errore.
- ***Error*** (Errore): stato errato di un componente.
- ***Failure*** (Fallimento): servizio che non rispetta le specifiche.

## Modelli di Sistema

### Stati nei sistemi distribuiti

Un **Sistema Distribuito** è composto da **Processi** che girano su **Nodi Diversi della Rete**, ognuno di questi **Processi** può avere **più Thread**, e lo **Stato Complessivo del Sistema dipende dall’Insieme degli Stati Locali**.

### Tipi di stato:

1. **Stato interno**

   * Include tutte le **Informazioni non direttamente Visibili all’esterno**: registri della CPU, memoria (stack, heap), descrittori di file, variabili locali, kernel state.
   * È utile per capire il **comportamento interno**, ma **non è osservabile dagli utenti**.

2. **Stato Esterno (o osservabile)**

   * È la parte dello stato che si manifesta tramite l’**interazione con l’Utente o altri Sistemi**.
   * È definito a livello di **Specifica Funzionale del Servizio** (ciò che il sistema promette di fare).
   * Esempio: la risposta che un server fornisce a una richiesta HTTP.

Lo **Stato** in un determinato momento rappresenta il **Minimo Insieme di Informazioni** che, insieme alle **Regole di Evoluzione del Sistema**, permette di predire il comportamento futuro.

Salvare lo stato è cruciale per il **ripristino dopo un guasto**, se il **Sistema** salva lo **Stato** su una **Memoria Stabile** (***Checkpointing***), può **ripartire dal punto precedente l’Errore**, mentre senza uno stato salvato, un crash può far perdere dati o coerenza.

### Confini del sistema

Per definire cosa è incluso nello **Stato**, bisogna stabilire la **Frontiera del Sistema**:
  * **Dentro:** componenti del sistema stesso.
  * **Fuori:** l’ambiente, cioè altri sistemi che interagiscono con esso.

A seconda del **Livello di Astrazione**, ciò che consideriamo “**Sistema**” o “**Componente**” può cambiare.

### Difficoltà del concetto di tempo

Dire “lo stato del sistema in un certo istante t” non è banale nei sistemi distribuiti, perché **non esiste un unico Orologio Globale perfettamente Sincronizzato**, questo rende la definizione di **snapshot coerente** una sfida tecnica.

## Threat Models nei Sistemi Distribuiti

Per analizzare l’**Affidabilità** di un **Sistema Distribuito** non basta descriverne l’architettura: è fondamentale anche modellare le **minacce** che possono comprometterne il funzionamento.

Il **Modello di Minaccia** (o ***Threat Model***) fornisce un **quadro concettuale** per capire **come e perché un sistema può fallire**.

### Concetti Chiave

Un sistema **fallisce (failure)** quando non eroga il servizio come specificato, la causa diretta del fallimento è un **errore (error)** nello stato del sistema, gli errori derivano da **guasti (faults)**, cioè difetti latenti che si attivano in certe condizioni.

### Attivazione e Propagazione dei Fault

Un ***fault*** può restare **nascosto**, o **dormiente**, per molto tempo, ma quando il ***fault*** si attiva, genera un ***error*** che **compromette il comportamento del componente** e successivamente può propagarsi ad altri componenti attraverso le loro interazioni.

Se l’**errore** raggiunge l’**interfaccia utente** o altri sistemi, si manifesta come ***failure***.

### Classificazioni dei Fault

Per descrivere meglio le minacce, i ***fault*** possono essere classificati in base a diversi criteri:

1. **Origine**

   * ***Hardware faults***: guasti a dischi, memorie, alimentazione.
   * ***Software faults***: bug, race conditions, buffer overflow.
   * ***Operator faults***: errori umani di configurazione o gestione.

2. **Intento**

   * ***Non-malicious faults***: guasti accidentali o naturali.
   * ***Malicious faults***: azioni intenzionali volte a danneggiare (es. attacchi Byzantine).

3. **Durata**

   * ***Transient***: temporanei, scompaiono spontaneamente (es. disturbo elettrico).
   * ***Intermittent***: appaiono e scompaiono più volte (es. bug di concorrenza).
   * ***Permanent***: persistono finché non si ripara o sostituisce il componente.

4. **Manifestazione**

   * ***Content faults***: valori sbagliati prodotti da un componente.
   * ***Timing faults***: risposte in ritardo, troppo rapide o assenti.

5. **Riproducibilità**

   * ***Deterministici***: facili da riprodurre e diagnosticare.
   * ***Nondeterministici*** or ***Heisenbugs***: difficili da osservare e replicare.

6. **Relazione tra fault**

   * ***Indipendenti***: non influenzano l’uno l’altro.
   * ***Correlati***: derivano da una stessa causa (common mode failures).

### Importanza del Modello di Minaccia

Fornisce la base per decidere quali tecniche di **Prevenzione**, **Rilevamento** e **Tolleranza** adottare.

Aiuta a distinguere i casi in cui è sufficiente **prevenire Guasti Banali** da quelli in cui bisogna proteggersi da ***fault* complessi** o **malevoli**.

È indispensabile per la **Progettazione di Sistemi Distribuiti Critici**, dove la propagazione di un fault può rapidamente diventare catastrofica.

## Attributi e Metriche dell’Affidabilità

### Definizione

La **Dependability** di un **Sistema Distribuito** viene descritta attraverso un **Insieme di Attributi Qualitativi e Quantitativi**.

### Disponibilità (Availability)

* **Definizione**: Probabilità che il **Sistema sia Operativo e Pronto** a erogare i suoi servizi in un dato istante.
* **Metriche**:
  * *MTTF* (Mean Time To Failure): tempo medio al guasto.
  * *MTTR* (Mean Time To Repair): tempo medio di riparazione.
  * *MTBF* (Mean Time Between Failures): MTTF + MTTR.
  * Formula: **Availability = MTTF / (MTTF + MTTR)**.

### Affidabilità Operativa (Reliability)

* **Definizione**: capacità del sistema di **fornire Servizi corretti senza Interruzioni** per un periodo di tempo continuo.
* **Formula tipica**:
  * $R(Δt) = e^{(-λΔt)}$, dove $λ$ è il **Tasso di Guasto**.
  * È proporzionale a MTTF.
* Un sistema può avere alta disponibilità (si riprende rapidamente dai guasti) ma bassa affidabilità (guasti frequenti).

### Sicurezza (Safety)

* **Definizione**: assenza di **Conseguenze Catastrofiche** in caso di fallimento temporaneo.
* **Caratteristica**: è più difficile da definire formalmente e non sempre misurabile con metriche semplici.

### Integrità (Integrity)

* **Definizione**: capacità del sistema di **proteggere lo Stato Interno e i Dati dalla Corruzione**.

* **Nel contesto distribuito**: spesso coincide con la consistenza delle repliche, finché il numero di repliche guaste non supera una soglia, il sistema mantiene l’integrità.

### Manutenibilità (Maintainability)

* **Definizione**: facilità con cui un sistema può essere **riparato** o **aggiornato** dopo il **rilascio**.

* **Aspetti rilevanti**:
  * Applicazione rapida di patch senza reinstallazioni complete.
  * Aggiornamenti “live” (senza fermare il servizio).
* **Relazione**: un’elevata manutenibilità contribuisce indirettamente ad aumentare la disponibilità.


### Attributi Fondamentali vs. Secondari

* **Fondamentali per ogni sistema distribuito**: Disponibilità, Affidabilità e Integrità.
* **Secondari o specifici per certi domini**: Sicurezza e Manutenibilità.

### Mezzi per garantire l’Affidabilità nei Sistemi Distribuiti

Per costruire **Sistemi Distribuiti affidabili** non basta rilevare i guasti: occorre adottare **Strategie Sistematiche** che coprano tutte le fasi del ciclo di vita di un fault, dalla prevenzione fino al recupero. Le principali categorie di tecniche sono quattro: **evitare, rilevare, rimuovere e tollerare i guasti**.

### Fault Avoidance (Evitare i guasti)

* **Obiettivo**: ridurre al minimo la probabilità che si verifichino guasti.
* **Approcci tipici**:
  * Uso di componenti hardware e software di qualità.
  * Specifiche progettuali corrette e verificate formalmente.
  * Test rigorosi per individuare bug prima della distribuzione.
  * Metodi formali per dimostrare proprietà di correttezza.

### Fault Detection & Diagnosis (Rilevamento e diagnosi)

* **Obiettivo**: individuare guasti già avvenuti e identificarne la causa.
* **Tecniche**:
  * Monitoraggio periodico (heartbeat, probe) per rilevare crash.
  * Sistemi di logging e metriche di salute del sistema.
  * Meccanismi di gestione delle eccezioni nei linguaggi di programmazione.
  * Modelli statistici e strumenti di diagnostica per localizzare il componente difettoso.
* **Nota**: non tutti i guasti sono facilmente rilevabil

### Fault Removal (Rimozione)

* **Obiettivo**: eliminare i guasti rilevati e reintegrare il sistema in condizioni sane.
* **Approcci tipici**:
  * Isolare il componente guasto.
  * Ripararlo o sostituirlo.
  * Reintrodurlo nel sistema tramite **meccanismi di membership** (chi è dentro o fuori dal gruppo di nodi attivi).
* **Casi speciali**:
  * Aggiornamenti software (patching e hot fix).
  * Riconfigurazioni dinamiche nei sistemi distribuiti.

### Fault Tolerance (Tolleranza ai guasti)

* **Obiettivo**: mantenere il servizio corretto anche quando si verificano guasti.
* **Motivazione**: i guasti hardware e software non possono essere eliminati del tutto, quindi serve resilienza.
* **Tecniche principali**:
  * **Rollback recovery**: ritorno a uno stato precedente corretto (checkpoint + logging).
  * **Recovery-Oriented Computing**: progettazione orientata al rapido recupero piuttosto che alla totale prevenzione.
  * **Redundancy (ridondanza)**: duplicazione di risorse per mascherare i guasti.

### Tipi di ridondanza

1. **Informativa**
   * Aggiunta di dati extra (checksum, codici di correzione d’errore).
   * Permette di rilevare e correggere dati corrotti.

2. **Temporale**
   * Ripetizione delle operazioni.
   * Esempio: ritentare una transazione abortita.

3. **Fisica**
   * Aggiunta di componenti hardware ridondanti.
   * Esempio: server replicati, sistemi RAID, cluster fault-tolerant.
   * È la forma più costosa, ma anche la più robusta.

### Riflessione finale

Questi mezzi non sono alternativi, ma **complementari**:

* L’evitamento riduce i guasti a monte.
* Il rilevamento e la rimozione permettono di reagire prontamente.
* La tolleranza garantisce la continuità del servizio anche in presenza di guasti inevitabili.

Insieme, costituiscono la base per progettare sistemi distribuiti realmente **affidabili e resilienti**.

### Conclusione

* L’affidabilità è essenziale per i sistemi distribuiti.
* Servono modelli chiari di sistemi e minacce.
* Le tecniche adottate per gestire i guasti determinano il livello di affidabilità raggiunto.

---

# Logging & Checkpointing: verso il recupero dei sistemi distribuiti

## Interazione, dipendenze, causalità e tempo

### Componenti e interazione

* Un sistema distribuito è composto da **componenti** con ruoli diversi: ognuno svolge funzioni, offre servizi, esegue compiti e persegue obiettivi specifici.
* Le componenti non operano in isolamento: interagiscono tra loro **nel tempo** (nei sistemi concorrenti) e **nello spazio** (nei sistemi distribuiti).
* Le interazioni creano **dipendenze** funzionali e temporali: il successo di un componente può dipendere da altri.

### Dipendenze e causalità

* Le dipendenze tra componenti possono essere modellate tramite la **relazione di causalità**:
  un evento *A* è causa di un evento *B* se l’occorrenza di *A* influisce su *B*.
* La causalità è una costruzione cognitiva, utile per descrivere e prevedere i comportamenti del sistema.
* Nelle scienze e nell’informatica si distingue tra **correlazione** e **causa-effetto**: correlazione non implica necessariamente causalità.

### Causalità nei sistemi distribuiti

* La causalità introduce una relazione **temporale**: una causa precede il suo effetto.
* Nei sistemi distribuiti, ciò permette di derivare una nozione di **ordine parziale** tra eventi, utile per comprendere le dipendenze e definire un “tempo logico”.

## Tecniche di base per l’affidabilità

### Checkpointing e logging

* Sono le **tecniche fondamentali** per il recupero dei sistemi distribuiti dopo un guasto.
* Consentono una forma di **tolleranza ai guasti** a basso costo e con overhead limitato.
* Limiti: possibili perdite di informazioni e tempi di ripristino più lunghi rispetto a soluzioni più sofisticate.

### Checkpointing: concetto base

* Consiste nel **salvare periodicamente lo stato del sistema** su una memoria stabile (stable storage).
* In caso di guasto, il sistema può essere **ripristinato** allo stato salvato più recente.

### Logging e recupero

* Per tornare esattamente al punto prima del fallimento, è necessario registrare (loggare) anche:
  * Tutti i **messaggi in ingresso**.
  * Eventuali **eventi non deterministici** (es. ricezione di messaggi, input esterni).
* Insieme, checkpointing e logging implementano un **rollback recovery**, cioè un ritorno a uno stato precedente corretto.
* Esistono anche metodi di **roll-forward recovery**, ma sono più costosi e complessi.

## Modelli

### Modello di sistema

* Il sistema è composto da **N processi** che interagiscono tramite **messaggi**.
* Ogni processo ha:

  * Un proprio **stato locale** (spazio di indirizzamento, variabili, stack, heap, ecc.).
  * Una **sequenza di eventi** che ne modifica lo stato.
* I processi comunicano anche con l’esterno tramite messaggi di input/output.

### Modello di guasto

* Si assume un modello **fail-stop**: un processo fallisce smettendo di eseguire e perdendo lo stato volatile.
* Le comunicazioni sono **affidabili e FIFO**, quindi non ci sono perdite né riordinamenti di messaggi.

### Stato globale

* È la combinazione degli stati di tutti i processi e dei messaggi in transito.
* Tuttavia, non basta aggregare gli stati locali: bisogna considerare le **dipendenze causali** tra processi.
* Uno **stato globale consistente** è tale che tutte le dipendenze (causali e di messaggi) siano rispettate.
* Se i checkpoint non rispettano queste relazioni (es. un processo registra la ricezione di un messaggio che un altro non ha ancora inviato), si ottiene uno **stato inconsistente**.

### Channel state

* Per evitare la perdita di messaggi “in transito”, si registra anche lo **stato dei canali di comunicazione** (messaggi non ancora ricevuti).
* Ciò consente di ricostruire stati coerenti anche se i messaggi erano in viaggio al momento del guasto.

### Piecewise Deterministic Assumption

* Ipotesi di base per i protocolli di logging:

  * L’esecuzione di ogni processo è **deterministica** tra due eventi non deterministici.
  * Tutti gli eventi non deterministici possono essere identificati e registrati.
* Permette di ricostruire la sequenza esatta di stati fino al punto del fallimento.

### Output commit

* Quando il sistema invia un messaggio verso l’esterno, parte del suo stato diventa **osservabile** e “impegnato”.
* Il protocollo di recupero deve garantire che lo stato visibile all’esterno resti coerente anche dopo il ripristino (problema dell’**output commit**).

### Memoria stabile (stable storage)

* Tutti i checkpoint e i log devono essere conservati in **memoria stabile**:

  * Disco locale, RAID, file system replicati, o cloud storage.
* Deve sopravvivere ai guasti di processo e di disco per consentire il ripristino.

## Protocolli basati su Checkpoint

### Caratteristiche generali

* Si concentrano sugli **stati** (non sugli eventi).
* Sono più semplici ma meno precisi: dopo un fallimento, il sistema può ripristinarsi solo fino all’ultimo checkpoint coerente.

### Checkpointing non coordinato

* Ogni processo decide **autonomamente** quando salvare un checkpoint.
* Il problema è che i checkpoint indipendenti possono risultare **incompatibili**, rendendo impossibile ricostruire uno stato globale coerente.
* Servono quindi metadati sulle **dipendenze tra checkpoint**, aumentando la complessità.

### Protocollo globale di Tamir e Sequin (1984)

* Protocollo **coordinato e bloccante** (tutti i processi sospendono l’esecuzione).
* Un processo è designato come **coordinatore** e gestisce una fase a due stadi:

  1. Creazione di un punto di quiescenza del sistema (tutti fermano l’attività).
  2. Commit atomico dei checkpoint o rollback in caso di errore.
* Utilizza messaggi di controllo:

  * **CHECKPOINT**, **SAVED**, **FAULT**, **RESUME**.
* Garantisce la **consistenza globale** ma introduce overhead e tempi di blocco.

### Protocollo di Chandy e Lamport (1985)

* Protocollo **non bloccante**: i processi continuano ad operare durante la creazione del checkpoint globale.
* Usa **Marker messages** per propagare e coordinare i checkpoint.
* Cattura anche lo stato dei canali di comunicazione per garantire la consistenza.
* È più flessibile, ma non fornisce atomicità completa nella transizione di stato.

#### Confronto tra i due:

| Aspetto     | Tamir & Sequin            | Chandy & Lamport              |
| ----------- | ------------------------- | ----------------------------- |
| Tipo        | Coordinato, bloccante     | Non coordinato, non bloccante |
| Consistenza | Forte                     | Consistenza eventuale         |
| Atomicità   | Garantita                 | Non garantita                 |
| Complessità | Maggiore                  | Inferiore                     |
| Adatto per  | Sistemi critici, sincroni | Sistemi dinamici, asincroni   |

## Protocolli basati su Logging

### Concetto generale

* Si registrano **eventi** invece degli **stati**.
* Basati sull’ipotesi *piecewise deterministic*: ogni processo alterna fasi deterministiche e eventi non deterministici.
* Loggando ogni evento non deterministico, si può **ricostruire la sequenza esatta di esecuzioni** fino al momento del guasto.

### Tipologie di logging [Alvisi & Marzullo, 1998]

1. **Pessimistico**

   * I messaggi vengono registrati **sincronamente** prima dell’esecuzione.
   * Recupero semplice e rapido, ma maggior latenza.
2. **Ottimistico**

   * Gli eventi vengono prima salvati in memoria volatile e poi scritti asincronamente.
   * Overhead ridotto, ma rischio di perdere messaggi e dover eseguire rollback più estesi.
3. **Causale**

   * Le informazioni sui messaggi non ancora loggati vengono “trasportate” (piggyback) nei messaggi inviati.
   * Garantisce una **consistenza causale** del recupero, ma aumenta notevolmente la complessità.

### Logging + Checkpointing combinati

* Nella pratica, **logging e checkpointing vengono sempre usati insieme**:

  * I checkpoint riducono la lunghezza del log e il tempo di ripristino.
  * I log permettono di riprodurre gli eventi successivi all’ultimo checkpoint.
* Combinazione ideale per bilanciare **overhead, spazio di archiviazione e tempo di recupero**.

---

# Logging & Checkpointing: verso il recupero dei sistemi distribuiti

## Perché replicare?

### Obiettivi della replicazione

* **Affidabilità e tolleranza ai guasti**: se una replica fallisce, il sistema può continuare ad operare su un’altra.
* **Performance**: ridurre tempi di accesso e latenza, specialmente in sistemi geograficamente distribuiti.
* **Scalabilità**: aumentare la capacità gestendo più richieste contemporanee.

### Replicazione per le performance

* Serve quando cresce il numero di processi che accedono agli stessi dati.
* Posizionare le repliche **vicino ai client** riduce la latenza percepita.
* Tuttavia, mantenere aggiornate tutte le repliche consuma **banda di rete** e **risorse computazionali**.

> Trade-off: più repliche = accessi più rapidi, ma maggiore costo di sincronizzazione.

### Problemi della replicazione

1. **Costi**:

   * Hardware aggiuntivo, gestione fisica, manutenzione.
   * Maggiore traffico di rete per sincronizzare le copie.
2. **Consistenza**:

   * Quando una copia viene modificata, diventa diversa dalle altre.
   * Occorre aggiornare tutte le copie in modo coerente.

### Replicazione come tecnica di scalabilità

* **Replica locale**: accedere a dati vicino all’utente migliora i tempi di risposta.
* **Problema**: aggiornare continuamente le copie può risultare più costoso del beneficio ottenuto.

Esempio numerico:

* Processo ( P ) accede alla replica ( N ) volte/sec.
* Replica aggiornata ( M ) volte/sec.
* Se ( N \ll M ), molti aggiornamenti non servono → spreco di rete.

### Dilemma: replicazione vs. consistenza

* Replicazione e caching migliorano le prestazioni.
* Ma mantenere **consistenza globale** tra copie richiede **sincronizzazione costosa**.
* Soluzione comune: **rilassare i vincoli di consistenza**, accettando leggere differenze temporanee tra copie.

> “Il rimedio può essere peggiore della malattia” — bisogna scegliere il compromesso più adatto all’applicazione.

## Consistenza

### Concetto generale

Non esiste una sola nozione di consistenza.
Diversi **modelli di consistenza** bilanciano costi e benefici in base al tipo di applicazione.
Ogni modello definisce un **“contratto”** tra i processi e i data store:

* specifica cosa significa “dati corretti”,
* e quali regole devono essere rispettate per mantenere tale correttezza.

### Tipi principali di modelli

1. **Data-centric consistency models**

   * Si concentrano sulla coerenza dei dati tra repliche.
   * Adatti a database e sistemi condivisi.
2. **Client-centric consistency models**

   * Si focalizzano sull’esperienza del singolo client.
   * Tipici nei sistemi mobili o geograficamente distribuiti.


## Modelli di Consistenza Data-centric

### Continuous Consistency

* Permette **deviazioni controllate** tra repliche.
* Le deviazioni possono essere misurate lungo tre assi:

  1. **Numerical deviation** – differenza di valori (es. ±0,01€ nel prezzo di un’azione).
  2. **Staleness deviation** – ritardo massimo tollerato (es. dati meteo vecchi fino a 4 ore).
  3. **Ordering deviation** – limite sul disordine degli eventi (es. massimo 6 messaggi fuori ordine in un forum).
     → Approccio flessibile che definisce la nozione di *consistenza continua*.

### Conit (unità di consistenza)

* La coerenza si misura su **unità logiche di dati** chiamate *conit* (consistency unit).
* Ogni sistema definisce la propria granularità:

  * **Conit grandi** → più semplicità ma più propagazione.
  * **Conit piccoli** → meno overhead ma maggiore complessità di gestione.
    → La scelta dipende dal tipo di dato e dal livello di coerenza desiderato.

### Sequenziale e Causale

* **Sequential consistency**
  Tutti i processi vedono le operazioni nello stesso ordine.
  Formalmente: l’esecuzione equivale a una sequenza unica in cui le operazioni di ciascun processo appaiono nell’ordine del suo programma.

* **Causal consistency**
  Basata sulla relazione causa-effetto.
  Solo le operazioni **causalmente correlate** devono mantenere l’ordine.
  Operazioni indipendenti possono essere viste in ordini diversi.
  → Modello più debole, ma più scalabile.

## Modelli di Consistenza Client-centric

### Tipi di consistenza client-centrica

1. **Eventual Consistency**

   * Tutte le repliche convergono nel tempo, se non ci sono nuovi aggiornamenti.
   * Accettabile in sistemi dove leggere dati temporaneamente obsoleti non è critico.
   * Esempi: DNS, contenuti web.

2. **Monotonic Reads**

   * Se un processo legge un valore di ( x ), le letture successive restituiranno sempre lo stesso o un valore più recente.
   * Evita “regressioni” nei dati (es. e-mail già lette che ricompaiono come non lette).

3. **Monotonic Writes**

   * Le scritture dello stesso processo rispettano l’ordine temporale in tutte le repliche.
   * Evita aggiornamenti fuori sequenza (es. sviluppo software distribuito).

4. **Read Your Writes**

   * Dopo una scrittura, il processo deve sempre leggere il valore aggiornato.
   * Evita l’effetto “ho aggiornato la pagina web ma vedo ancora la vecchia versione”.

5. **Writes Follow Reads**

   * Una scrittura successiva a una lettura avviene su un valore aggiornato.
   * Evita di sovrascrivere informazioni obsolete (es. commenti a un post social).

## Replicazione nei sistemi distribuiti

### Gestione delle repliche

Replicare non significa solo copiare i dati:

* Occorre decidere **dove, quando e da chi** creare le repliche.
* Due problemi distinti:

  1. **Replica server placement** – dove posizionare i server di replica.
  2. **Replica content placement** – quali contenuti replicare e con quale politica di aggiornamento.

### Replicazione di servizi e processi

* **Service replication**: replicare funzioni o microservizi, non solo dati.
* **Process replication**: nei sistemi mobili, si possono replicare o clonare processi per continuità e tolleranza ai guasti.
* Introduce livelli di complessità aggiuntivi (es. sincronizzazione degli stati interni).

---
