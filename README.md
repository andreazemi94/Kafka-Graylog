# Kafka-Graylog
## Descrizione del Progetto
Il progetto Kafka-Graylog è composto da tre microservizi Spring Boot, Kafka, Graylog e un Database PostgreSQL. Questo sistema si occupa di gestire un flusso di ordini e fatture con l'integrazione di Kafka per la comunicazione asincrona e Graylog per il logging.
## Funzionamento del Sistema
Il flusso del sistema si sviluppa nei seguenti passi:

### 1) Microservizio Order:
- Espone un'API REST chiamata `createOrder()`, la quale, quando viene chiamata, crea un ordine nella tabella `orders` del database PostgreSQL.
- Viene effettuato un log della creazione dell'ordine su Graylog per monitorare l'evento.
- Un messaggio contenente l'ordine appena creato viene pubblicato su un topic Kafka.

### 2) Microservizio Invoice:
- Consuma i messaggi pubblicati su Kafka dal topic dove è stato pubblicato l'ordine.
- Una volta ricevuto il messaggio, il microservizio crea una fattura (`invoice`) nel database PostgreSQL.
- L'evento viene loggato su Graylog.
- L'oggetto `invoice` appena creato viene poi pubblicato su un altro topic Kafka, separato da quello utilizzato per gli ordini.

### 3) Microservizio Order (nuovamente):
- Consuma i messaggi dal topic Kafka dove sono pubblicate le fatture (`invoice`).
- Quando il microservizio `Order` trova un ordine associato a una fattura, aggiorna lo stato dell'ordine in "Pagamento Completato".
- Viene quindi effettuato un log dell'aggiornamento dello stato dell'ordine su Graylog per tracciare il cambiamento.

## Componenti Principali
- **Microservizio Order**: Gestisce la creazione dell'ordine, l'interazione con Kafka per l'invio e la ricezione dei messaggi, e il logging degli eventi in Graylog.
- **Microservizio Invoice**: Consuma i messaggi degli ordini, crea le fatture e interagisce con Kafka per pubblicare l'invoice e aggiornare lo stato su Graylog.
- **Kafka**: Utilizzato per la comunicazione asincrona tra i microservizi tramite la pubblicazione e la sottoscrizione a topic specifici.
- **Graylog**: Sistema di logging centralizzato che raccoglie e visualizza i log di tutti i microservizi.
- **PostgreSQL**: Database relazionale utilizzato per memorizzare gli ordini e le fatture.

## Tecnologie Utilizzate
- **Spring Boot**: Per la creazione dei microservizi.
- **Apache Kafka**: Per la gestione dei messaggi asincroni tra i microservizi.
- **Graylog**: Per la gestione dei log centralizzati.
- **PostgreSQL**: Per la gestione dei dati relativi agli ordini e alle fatture.

## Architettura
![Disegno SVG](Schema_progetto.svg)

Il sistema è progettato per garantire una comunicazione asincrona ed efficiente tra i microservizi, monitorando e loggando ogni evento per avere visibilità completa sul flusso dell'applicazione. La separazione dei topic Kafka per ordini e fatture consente una gestione più fluida degli eventi, mentre PostgreSQL funge da solido punto di archiviazione per i dati strutturati di ordini e fatture.

## Dockerizzazione
L'intero progetto è stato dockerizzato per poter essere avviato facilmente in locale. Puoi avviare tutti i servizi necessari utilizzando Docker Compose.
