### **Cos'è un Linguagggio?**

Un Linguaggio è un l'insieme di tutte le possibili combinazioni dei Simboli di un Alfabeto

**Cos'è un Linguaggio Regolare**

Un Linguaggio Regolare è un Linguaggio Formale, ovvero un Insieme di Stringhe, generato da una Grammatica Regolare o accettato da un FSA.

### **Cos'è un DFA**

Un DFA è una quintupla:

$$A = (Q, Σ, δ, q0, F )$$

- $Q$ = Un **Insieme Finito** di **Stati**
- $Σ$ = Un **Alfabeto Finito**
- $δ$ = Una **Funzione di Transizione** da $Q × Σ \rightarrow Q$
- $q_0 ∈ Q$ = Lo **Stato Iniziale**
- $F ⊆ Q$ = Un **Insieme di Stati Finali**

Sono **Deterministici** poichè ogni **Transizione** è **unica** da **Stato** a **Stato**, non esiste casualità.

### **Cos'è un NFA?**

Un NFA è una quintupla:

$$A = (Q, Σ, δ, q_0, F )$$

- $Q$ = Un **Insieme Finito di Stati**
- $Σ$ = Un **Alfabeto Finito**
- $δ$ = Una **Funzione di Transizione** dall'Insieme $Q×Σ$ all’Insieme dei Sottoinsiemi di $Q$, ovvero $\delta(q, a) \rightarrow Q'$ con $Q' ⊆ Q$
- $q_0 ∈ Q$ è lo Stato Iniziale
- $F⊆Q$ = Un Insieme di Stati Finali

$$L(A)=\{w:\hat{\delta}(q_o,w)\cap F\not=\empty\}$$

### Teorema Equivalenza tra DFA e NFA (Valido anche per ENFA)

Sia $D$ il **DFA** ottenuto da un **NFA** $N$ con la **Costruzione a Sottoinsiemi**, allora $L(D) = L(N)$

Un **Linguaggio** $L$ è **accettato** da un **DFA** se e solo se $L$ è **accettato** da un **NFA**.

Il **Numero di Stati** del **DFA** equivalente ad un **NFA** con $n$ stati è, nel caso peggiore, pari a $2^n$ stati.




