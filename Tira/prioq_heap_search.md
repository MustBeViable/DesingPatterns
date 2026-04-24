# Muistiinpanot: Priority queue, heap ja searching

Aihe perustuu Chapter 8 -materiaaliin: Priority queues and heaps, Searching.

---

## 1. Priority queue

### Oma vastaus oli osittain oikein
Sanoin, että priority queue muodostuu heapista.

### Korjaus
Priority queue ei tarkoita suoraan heapiä. Priority queue on **abstrakti tietorakenne**, joka voidaan toteuttaa monella tavalla. Heap on vain yleinen ja tehokas tapa toteuttaa se.

### Oikea vastaus
Priority queue on jono, jossa alkio palautetaan **prioriteetin** perusteella, ei lisäysjärjestyksen perusteella.

Tavallinen queue toimii FIFO-periaatteella:

```text
First In, First Out