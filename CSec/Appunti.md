# Introduction

## Articolo 1
https://www.anthropic.com/news/detecting-and-preventing-distillation-attacks

Problema della generazione di "**Modelli Distillati**", ovvvero modelli di qualità inferiore addestrati sullàoutput di un modello migliore(Claude).

## Vulnerability

In cybersecurity, vulnerability refers to a **weakness** or **flaw** in a system's **design**, **implementation** or **configuration** that could be exploited by threat actors to compromise the confidentiality, **integrity** or **availability** of the system or its data.

Vulnerabilities can exist in various components of a computer system, including **software**, **hardware**, **network protocols** and human factors.

### Zero Day

It's a **Vulnerability** in a computer system that was **previously unknown** to its developers or anyone capable of mitigating it.

Top level vulnerability, because it combines the worst possible conditions in cybersecurity: **unknown**, **unpatched**, and **immediately exploitable**.

Vendors who discover the vulnerability may create patches or advise workarounds to mitigate it, though users need to deploy that mitigation to eliminate the vulnerability in their systems.

#### Domanda -Richiedi la domanda quando si parlera dei broker-
Se voglio vendere una vulnerabilita' come faccio a dimostrare la sua esistenza senza che il vendor scopra direttamente la vulnerabilita'?

## Exploit

An **Exploit** is simply a **method** or **technique** used to take advantage of a **Vulnerability**.

A vulnerability is the weakness, an exploit is the way attackers use that weakness.

An exploit can lead to a **Total Compromission** of the device, system or software

## Security Bulletin

A **Security Bulletin** is an official notification issued by a **software** or **hardware vendor** describing **security vulnerabilities** and how to address them.

Structura:
- **Overview** = Description of the Vulnerability
- **Affected Products/Versions**
- Severity rating (often CVSS score)
- **Impact** = The severity of the vulnerability
- **Mitigation Guidance**

---
# Reading 1 (https://www.wired.com/2014/01/theres-no-good-way-to-patch-the-internet-of-things-and-thats-a-huge-problem/?utm_source=chatgpt.com "The Internet of Things Is Wildly Insecure — And Often Unpatchable | WIRED")

Oggi viviamo una crisi silenziosa ma profonda: la sicurezza dei dispositivi embedded e dell’Internet delle cose. Milioni di router, modem, telecamere e oggetti connessi sono pieni di vulnerabilità e, nella maggior parte dei casi, non esiste un sistema efficace per aggiornarli.

La situazione ricorda quella dei PC negli anni ’90: molti bug, poche patch, utenti che non aggiornano. Nel tempo, però, i computer sono diventati più sicuri grazie agli aggiornamenti automatici e alla pressione pubblica sulle aziende. Con l’IoT questo modello non funziona, perché il mercato è frammentato e i produttori non hanno reali incentivi a garantire manutenzione nel lungo periodo.

I dispositivi vengono prodotti con software spesso vecchio, talvolta contenente componenti proprietarie non modificabili. Anche quando gli aggiornamenti sarebbero possibili, raramente vengono distribuiti o installati. Il risultato è un’enorme quantità di dispositivi sempre connessi e sempre accesi, ma vulnerabili da anni.

Gli attacchi non sono ipotetici: malware e worm hanno già compromesso milioni di router e altri dispositivi, trasformandoli in strumenti per frodi e intrusioni. E poiché questi apparecchi sono il centro delle reti domestiche, una loro compromissione può mettere a rischio tutto il resto.

La soluzione non è solo tecnica, ma economica. Servono sistemi progettati con la sicurezza fin dall’inizio, aggiornamenti automatici obbligatori e una maggiore responsabilità da parte dei produttori e degli ISP. Senza un cambiamento strutturale, continueremo a costruire un ecosistema digitale fragile e pericolosamente esposto.

# Reading 2 (https://digital-strategy.ec.europa.eu/en/policies/cra-summary?utm_source=chatgpt.com "The Cyber Resilience Act - Summary of the legislative text | Shaping Europe’s digital future")

Oggi vorrei parlarvi di una delle normative più importanti in materia di sicurezza digitale in Europa: il Cyber Resilience Act.

Si tratta di un regolamento dell’Unione Europea che introduce requisiti obbligatori di cybersecurity per tutti i prodotti con elementi digitali immessi sul mercato europeo: hardware, software, dispositivi IoT, firmware e componenti connessi. L’obiettivo è chiaro: aumentare il livello minimo di sicurezza e ridurre il numero di vulnerabilità sfruttabili dai criminali informatici.

Il regolamento è entrato in vigore il 10 dicembre 2024, ma la sua applicazione sarà progressiva. Alcuni obblighi, come quelli relativi alla segnalazione delle vulnerabilità, inizieranno dal settembre 2026, mentre la piena applicazione è prevista per dicembre 2027.

Il CRA si rivolge a produttori, sviluppatori, importatori e distributori di prodotti digitali destinati al mercato UE. Introduce un principio fondamentale: la sicurezza deve essere garantita fin dalla progettazione, secondo l’approccio “security by design” e “by default”. I prodotti non devono contenere vulnerabilità note al momento della vendita e devono essere accompagnati da processi strutturati per la gestione delle falle nel tempo.

Un punto centrale è l’obbligo di aggiornamento: le aziende devono garantire patch di sicurezza per un periodo definito del ciclo di vita del prodotto. Inoltre, dal 2026, i produttori dovranno segnalare rapidamente le vulnerabilità attivamente sfruttate alle autorità competenti attraverso una piattaforma europea unica, con scadenze precise: 24 ore per la prima notifica, 72 per i dettagli e 14 giorni per il rapporto finale.

Il regolamento distingue anche i prodotti in base al livello di rischio: quelli considerati più critici dovranno superare valutazioni di conformità più rigorose prima di ottenere il marchio CE.

Per quanto riguarda l’open source, il software libero non monetizzato non è direttamente soggetto al CRA. Tuttavia, se viene integrato in un prodotto commerciale venduto nell’UE, il produttore rimane responsabile della conformità ai requisiti di sicurezza.

Infine, il mancato rispetto del regolamento può comportare sanzioni significative e limitazioni all’accesso al mercato europeo.

In sintesi, il Cyber Resilience Act rappresenta un cambio di paradigma: la sicurezza dei prodotti digitali non è più una scelta volontaria o un vantaggio competitivo, ma un obbligo legale strutturato, destinato a rafforzare l’intero ecosistema digitale europeo entro il 2027.

---

# What “value” means in cybersecurity

In cybersecurity, **value** refers to:
- How important it is to protect an asset
- What damage could occur if it were lost, stolen, or compromised

It is not only about money, but about **potential impact**.

## What is considered valuable

The **assets** we protect include:
- Customer data (names, passwords, credit cards)
- Intellectual property (source code, patents)
- Financial documents
- Systems and servers
- Company reputation
- Operational continuity (uptime)

Practical examples:
- Hospital patient database → very high value
- Public blog post → low value

## CIA Triad (Confidentiality, Integrity, Availability)

Asset value is often measured using the CIA triad:
- **Confidentiality:** how serious it would be if private data were disclosed
- **Integrity:** how serious it would be if data were changed without authorization
- **Availability:** how serious it would be if a system became inaccessible

Examples:
- Banking system → all three dimensions are critical
- Company website → availability is more important than confidentiality

### Value and risk

Risk is calculated as:

**Risk = Asset Value × Threat × Vulnerability**

In practice:
- High-value asset + high exposure + weak protection = high risk
- Low-value asset or well-protected asset = lower risk

## Why value is important

Not everything can be protected equally, organizations must:
1. Identify high-value assets
2. Prioritize their protection
3. Allocate security resources effectively

This approach is called **risk-based cybersecurity**.

### Practical example

A company has:
- Public cafeteria menu
- Employee salary database

If attacked:
- Menu → minor inconvenience
- Salary database → legal issues, trust damage, reputational loss

The salary database has **higher value** for cybersecurity purposes.

## Value is not just monetary

It can also be:
* Financial
* Legal
* Reputational
* Operational
* Strategic
* Safety-related (in critical infrastructure)

---

# Crypto

## Central Authority & Guarantee

### Normal Currency (Fiat Money)

Examples: US Dollar, Euro, Yen

* Issued and controlled by a **central bank** (like the Federal Reserve in the U.S. or the European Central Bank in Europe).
* The government guarantees it as **legal tender**.
* If something goes wrong (bank fraud, error), there is usually a **legal system and central authority** to help you.

### Cryptocurrency

Examples: Bitcoin, Ethereum

* No central authority.
* Operates on a **blockchain** (a distributed ledger).
* Transactions are verified by a network of computers.
* If you lose your wallet key, your money is usually **gone forever** — no authority can restore it.

This gives more **freedom**, but less **institutional protection**.

## Double Spending Attack

### What is Double Spending?

Double spending means trying to spend the same money twice.

### In Normal Currency:

* Physical cash cannot easily be duplicated.
* Digital bank money is controlled by a central database.
* The bank prevents double spending.

### In Cryptocurrency:

- Since it is digital, double spending was a big early problem.
- Blockchain technology solves this by:
  - Recording all transactions publicly.
  - Requiring network consensus before confirming transactions.

For example, Bitcoin uses a system called **Proof of Work** to prevent double spending.

However:

* Smaller cryptocurrencies with weak networks can be vulnerable to **51% attacks** (a type of double spending attack).
So crypto solved the double-spending problem technically — but security depends on the strength of the network.

## Money Laundering

### Normal Currency

Cash is widely used for **Illegal Transactions**, **Banks** must follow **KYC (Know Your Customer)** and **AML (Anti-Money Laundering)** regulations.
Governments monitor suspicious activity.

### Cryptocurrency

Transactions can be **pseudonymous** (not directly tied to real identity).
This makes crypto attractive for:
  - Money laundering
  - Illegal markets
  - Tax evasion (in some cases)

However:
- Many crypto exchanges now require identity verification.
- Blockchain transactions are **public and traceable**, which sometimes makes tracking easier than cash.

So crypto is **not anonymous**, but it can provide more privacy than traditional banking.

### Summary Table

| Feature           | Normal Currency    | Cryptocurrency          |
| ----------------- | ------------------ | ----------------------- |
| Central Authority | Yes (central bank) | No (decentralized)      |
| Guarantee         | Government-backed  | No guarantee            |
| Double Spending   | Prevented by banks | Prevented by blockchain |
| Regulation        | Strongly regulated | Varies by country       |
| Privacy           | Low                | Medium (pseudonymous)   |
| Risk              | Lower volatility   | High volatility         |

---

# Vulnerability Brokers

A **vulnerability broker** is an individual or organization that **finds, buys, sells, or trades software or system vulnerabilities**.

They act as a middleman between the discoverers of vulnerabilities (researchers or hackers) and those who want to use them (companies, governments, or malicious actors).

Their role is mostly in the **cybersecurity marketplace**, where vulnerabilities are treated as valuable assets.

The value depends on:
- How critical the vulnerability is (e.g., allows full system control)
- How widespread the affected software is
- How difficult it is to detect or exploit

## Types of vulnerability brokers

- **Legitimate brokers**:
   - Sell vulnerabilities to software vendors or security companies
   - Help improve security by responsibly disclosing vulnerabilities
   - **Taxed**
- **Gray-market brokers**:
   - Sell vulnerabilities privately without official coordination
   - Buyers may use them offensively or defensively
- **Black-market brokers**:
   * Sell vulnerabilities to cybercriminals
   * Focus purely on financial gain or illegal use

## How vulnerability brokers operate

- Researchers discover vulnerabilities and contact a broker.
- Broker evaluates the **risk and value** of the vulnerability.
- Broker negotiates a **sale** or **auction**.
- The buyer may use it for:
  - **Defensive Purposes** (patching systems)
  - **Offensive Purposes** (hacking, cyberespionage)

## Legal and ethical considerations

Selling vulnerabilities is **legal if done responsibly** to software vendors or security firms, but selling vulnerabilities to criminal groups is **illegal** and **unethical**.

Some governments have **regulations and programs** for buying vulnerabilities, like the U.S. Department of Defense’s “Hack the Pentagon” program.

## Why vulnerability brokers are important in Cybersecurity

They create a **market for vulnerabilities**, which can influence cybersecurity priorities.

Responsible brokers can **help organizations patch vulnerabilities quickly**.

Irresponsible brokers can **increase the risk of cyberattacks** if flaws are sold to malicious actors.
