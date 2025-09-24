# Introduzione

## Il concetto di Linguaggio

Un **Linguaggio di Programmazione** è uno **Strumento** che ci permette di **descrivere in maniera rigorosa problemi**, in modo tale che questi possano poi essere **risolti da un esecutore automatico**.

## Lessico VS Sintassi

Il **Lessico** è l'**insieme delle Parole e delle Locuzioni** di una lingua (***Tokenizzazione***), mentre la **Sintassi** è la parte della **Grammatica** che studia come queste parole si combinano per formare **Frasi** e **Periodi**.

## Compilatore e Linguaggi

Il **Compilatore** è un **Parser** che permette la **generazione di Codice Oggetto**

La **Generazione Automatica del Codice** del compilatore per un nuovo linguaggio richiede un **Approccio Dichiarativo**, la **Logica della Computazione** viene espressa **senza descrivere il suo controllo di flusso**.

## Automi a Stati Finiti

Un **Automi a Stati Finiti** è un **Modello** per descrivere **Situazioni di Calcolo** in cui si consumano informazioni una alla volta, e durante la consumazione si devono memorizzare quantità finite di informazioni.

Esempio: automa a stati finiti per un interruttore on/off

![alt text](image.png)

## Macchina di Turing

La ***Macchina di Turing*** è un **Modello Matematico** di un semplice **Esecutore Automatico** o **CPU** (Automa con Memoria Ausiliaria).

La ***Tesi di Turing-Church*** afferma cheç

*Ogni **Problema** calcolabile da un **Algorimo**, o meglio tramite una **Procedura**, può essere risolto da una **Macchina di Turing***.

## Procedura VS Algoritmo

Una **Procedura** (AKA Pseudocodice) differisce da un **Algoritmo** poiché **non garantiscano la Terminazione**.

## Modelli Computazionali

I **Modelli Computazionali** sono **rappresentazioni** di **Sitemi DIstribuiti** o **Concorrenti**.

## Logiche Temporali

Le **Logiche Temporali**, permettono di esprimere le varie **Proprietà** del **Modello**.

I **Model Checker** sono **Strumenti** che **verificano** se delle **Proprietà** espresse tramite delle **Logiche Temporali** valgano oppure no.

---

## Concetti di Base

- **Alfabeto**: Insieme Finito e non vuoto di Simboli
- **Stringa**: Sequenza Finita di Simboli da un Alfabeto
- **Stringa Vuota**: La Stringa con Zero Occorrenze di Simboli
- **Lunghezza di una Stringa**: Numero di Posizioni per i Simboli nella Stringa. $$|0110| = 4$$
- **Potenze di un alfabeto**: Insieme delle Stringhe di Lunghezza $k$ con Simboli da $Σ$ $$|Σ|^k$$
- **Star di Kleene** = Unitoria di tutte le Stringhe. $$\bigcup_{k\ge 0} \Sigma^k$$
- **Concatenazione**: Se x e y sono Stringhe, allora xy e’ la Stringa ottenuta concatenando una copia di y subito dopo una copia di x.

## Linguaggi
Se $Σ$ è un **Alfabeto**, e $L ⊆ Σ^∗$ allora $L$ è un **Linguaggio**.

## Automi a Stati Finiti Deterministici

Un DFA è una **quintupla**:

$$A = (Q, Σ, δ, q0, F )$$

- $Q$ = Un **Insieme Finito** di **Stati**
- $Σ$ = Un **Alfabeto Finito**
- $δ$ = Una **Funzione di Transizione** da $Q × Σ \rightarrow Q$
- $q_0 ∈ Q$ = Lo **Stato Iniziale**
- $F ⊆ Q$ = Un **Insieme di Stati Finali**

Sono **Deterministici** poichè ogni **Transizione** è **unica** da **Stato** a **Stato**, non esiste casualità.

## Tabella e Diagramma di Transizione

Una **Tabella di Transizione** rappresenta i vari **Passaggi di Stato** che avvengono all'interno dell'**Automa**.

Un **Diagramma di Transizione** è una rappresentazinoe grafica di tutti i possibili **Passaggi di stato**.

## Funzioni di Transizione

La **Funzione di Transizione** $δ$ è la funzione che fornita una **Stringa** ritorna lo **Stato Finale dell'Automa**.

## Funzione di Transizione Estesa

La **Funzione di Transizione** $δ$ può essere estesa a $\hat{δ}$ che opera su **Stati** e **Stringhe**, invece che su **Stati** e **Simboli**.

$$\hat{\delta}(q,\epsilon)=q$$

da cui per induzione si ottine che:

$$\hat{\delta}(q,xa)=\delta(\hat{\delta}(q,x),a)$$

## Automi a Strati Nondeterministici (NFA)

Un **NFA** accetta una **Stringa** se esiste un **Cammino** che conduce ad uno **Stato Finale**.

Formalmente, un NFA e’ una quintupla:

$$A = (Q, Σ, δ, q_0, F )$$

- $Q$ = Un Insieme Finito di Stati
- $Σ$ = Un Alfabeto Finito
- $δ$ = Una Funzione di Transizione dall'Insieme $Q×Σ$ all’Insieme dei Sottoinsiemi di $Q$, ovvero $\delta(q, a) \rightarrow Q'$ con $Q' ⊆ Q$
- $q_0 ∈ Q$ e’ lo Stato Iniziale
- $F⊆Q$ = Un Insieme di Stati Finali

## Funzione di Transizione Estesa per NFA

A differenza dei **DFA**, negli **NFA** non parliamo più di **singoli Stati**, ma di **Insiemi di Stati**.

Quindi per induzione otteniamo:

$$\hat{\delta}(q,xa) = \bigcup_{p\in\hat{\delta}(q,x)}\delta(p,a)$$

E dunque il Linguaggio Accettato da un NFA è:

$$L(A)=\{w:\hat{\delta}(q_o,w)\cap F\not=\empty\}$$

## Equivalenza tra DFA e NFA

Per ogni **NFA** $N$ esiste un **DFA** $D$, tale per cui:

$$L(D)=L(N)$$

Questo comporta una **Costruzione a Sottoinsiemi**.

$$Q_D = \{S:S\subseteq Q_n\}$$

Dove:

$$|Q_D| = 2^{|Q_N|}$$

e

$$F_D = \{S\subseteq Q_N : S\cap F_N \not= \empty\}$$

quindi, per ogni $S\subseteq Q_N$ e $a\in \Sigma$ :

$$\delta_D(S,a) = \bigcup_{p\in S}\delta_N(p,a)$$

Possiamo inoltre evitare la **Crescita Esponenziale** degli **Stati** costruendo la **Tabella di Transizione** solo per **Stati Accessibili**.

### Teoremi

Sia $D$ il **DFA** ottenuto da un **NFA** $N$ con la **Costruzione a Sottoinsiemi**, allora:

$$L(D) = L(N)$$

Un **Linguaggio** $L$ è **accettato** da un **DFA** se e solo se $L$ è **accettato** da un **NFA**.

Il **Numero di Stati** del **DFA** equivalente ad un **NFA** con $n$ stati è, nel caso peggiore, pari a $2^n$ stati.

## Transizioni Epsilon

Una **Transizione Epsilon** consente a un **Automa** di **cambiare stato spontaneamente**, ovvero **senza consumare un simbolo di input**.

## Rappresentare un NFA con Numeri Decimali

Un **ϵ-NFA** che accetta **Numeri Decimali** consiste di:

1. Un segno + o -, opzionale
2. Una stringa di cifre decimali
3. Un punto decimale
4. Un’altra stringa di cifre decimali

Una delle stringhe (2) o (4) è opzionale.

## ϵ-NFA

Un **ϵ-NFA** è una quintupla $(Q, Σ, δ, q_0, F)$ dove $δ$ e’ una **Funzione** da $Q×(Σ∪\{ϵ\})$ all’**Insieme dei Sottoinsiemi** di $Q$.

## Epsilon-chiusura

Chiudiamo uno **Stato** aggiungendo tutti gli **Stati raggiungibili** da lui tramite una sequenza $ϵ$.

$$q\in ENCLOSE(q)$$

Da cui, dato un $p$ per cui:

$$p\in ENCLOSE(q)$$

allora:

$$r\in\delta(p,\epsilon)\rightarrow r\in ENCLOSE(q)$$

Se $r$ è **raggingibile** da $p$ con **input** $\epsilon$, allora $r$ **appartiene** alla ENCLOSE di $q$

## Definizione di $\hatδ$ per ϵ-NFA

Partendo da:

$$\hat{\delta}(q,\epsilon)=ENCLOSE(q)$$

Otteniamo che:

$$\hat{\delta}(q,xa)=\bigcup_{p\in\hat{\delta(q,x)}}\bigg(\bigcup_{t\in\hat{\delta(p,a)}}ENCLOSE(t)\bigg)$$

Ma il **Linguaggio accettato** $L$ rimane definito come:

$$\{w:\hat{δ}(q_0, w)∩F\not=\empty\}$$