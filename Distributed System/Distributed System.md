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

## What do we expect from a distributed systems During a failure?

Che siano **Coerenti**, vorremmo che si comportassero correttamente, che forniscano risposte corrette quando interrogati.

Che siano **Disponibili**, vorremmo che siano pronti a funzionare senza interruzioni.

Tuttavia, sappiamo che i sistemi possono effettivamente subire interruzioni di corrente, crash, guasti di rete, perdita di messaggi, attacchi dannosi e così via, e risultare inaffidabili.

## The CAP Theorem

According to the CAP theorem, it is only possible to simultaneously provide any two of the three following properties in distributed applications:

- Consistency (C) = The replicated data is always consistent with each other
- Availability (A) = The data is highly available to the users
- Partition Tolerance (P) = The system can continue providing services to its users even when the network partitions

Secondo il ***CAP Theorem***, nelle **Applicazioni Distribuite** è possibile fornire contemporaneamente solo due delle tre seguenti proprietà:

- **Coerenza** (C) = I dati replicati sono sempre coerenti tra loro
- **Disponibilità** (A) = I dati sono altamente disponibili per gli utenti
- **Tolleranza di Partizione** (P) = Il sistema può continuare a fornire servizi ai suoi utenti anche quando le partizioni di rete

