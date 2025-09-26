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


