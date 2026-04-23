# Muistiinpanot – Linked listit (vain kohdat joissa vastasin väärin tai osittain oikein)

Perustuu materiaaliin *Data structures and algorithms with Python – Chapter 3 – Lists*. :contentReference[oaicite:0]{index=0}

---

## 1. Listan yleinen merkitys vs. list of nodes

### Missä vastaus oli puutteellinen
Sanoin oikein, että arkikielen lista on peräkkäisiä asioita ja että list of nodes ei ole välttämättä muistissa peräkkäin, vaan solmut viittaavat toisiinsa.  
Puuttui kuitenkin tärkeä tarkennus: ohjelmoinnissa sana **list** voi tarkoittaa eri toteutuksia, mutta tässä materiaalissa **list of nodes** tarkoittaa tiettyä tietorakennetta. Lisäksi Pythonin `list` ei tässä materiaalissa tarkoita tätä, vaan se on toteutettu dynaamisena taulukkona. :contentReference[oaicite:1]{index=1}

### Oikea / täydellinen vastaus
Arkikielessä lista tarkoittaa yleensä järjestettyä joukkoa asioita.  
Ohjelmoinnissa **list of nodes** on tietorakenne, jossa alkiot ovat solmuissa ja solmut on linkitetty viitteillä toisiinsa. Pythonin `list` ei ole tässä mielessä list of nodes, vaan dynaaminen taulukko. :contentReference[oaicite:2]{index=2}

---

## 2. Singly linked listin `append` ilman `tail`-osoitinta

### Missä vastaus oli puutteellinen
Kerroin vain, että lähdetään `head`-solmusta ja kuljetaan loppuun asti, kunnes `next` on `None`, ja sitten liitetään uusi node loppuun.  
Puuttui kaksi tärkeää kohtaa:
- uusi solmu pitää **luoda ensin**
- tyhjän listan **erikoistapaus** pitää käsitellä erikseen, jolloin `head` asetetaan uuteen solmuun. :contentReference[oaicite:3]{index=3}

### Oikea / täydellinen vastaus
`append` toimii näin:
1. Luodaan uusi solmu.
2. Jos lista on tyhjä, asetetaan `head` osoittamaan uuteen solmuun.
3. Muuten kuljetaan listaa pitkin viimeiseen solmuun asti.
4. Asetetaan viimeisen solmun `next` osoittamaan uuteen solmuun. :contentReference[oaicite:4]{index=4}

---

## 3. Singly linked list “with tail” – mitä tallennetaan ja mitä hyötyä siitä on

### Missä vastaus oli puutteellinen
Sanoin vain, että tallennetaan `tail`, jolloin lisääminen loppuun ja alkuun on `O(1)`.  
Puuttui:
- materiaalissa tallennetaan myös **`size`**
- `tail` auttaa erityisesti **loppuun lisäämisessä**, ei alkuun lisäämisen takia. :contentReference[oaicite:5]{index=5}

### Oikea / täydellinen vastaus
Versiossa “with tail” tallennetaan:
- `head`
- `tail`
- `size`

Hyödyt:
- loppuun lisääminen (`append`) on `O(1)`, koska viimeinen solmu tiedetään suoraan
- pituuden kysyminen on `O(1)`, koska koko pidetään `size`-muuttujassa. :contentReference[oaicite:6]{index=6} :contentReference[oaicite:7]{index=7}

---

## 4. Doubly linked listin ero singly linked listiin

### Missä vastaus oli puutteellinen
Sanoin oikein, että doubly linked listissä on myös viite edelliseen solmuun, mutta yleistin liikaa sanomalla, että lisääminen ja poistaminen on nopeampaa.  
Tämä ei aina pidä paikkaansa kokonaisuutena, koska ensin oikea kohta tai solmu voi silti vaatia etsimisen, mikä on usein `O(n)`. :contentReference[oaicite:8]{index=8}

### Oikea / täydellinen vastaus
Doubly linked listissä jokaisella solmulla on sekä `next` että `prev`.  
Tämä mahdollistaa etenemisen sekä eteen- että taaksepäin ja helpottaa linkkien päivittämistä. Itse lisäys/poisto voi olla `O(1)`, **jos oikea solmu tai kohta on jo tiedossa**, mutta solmun etsiminen voi silti olla `O(n)`. :contentReference[oaicite:9]{index=9} :contentReference[oaicite:10]{index=10}

---

## 5. Miksi doubly linked listin `pop` lopusta on `O(1)`

### Missä vastaus oli puutteellinen
Sanoin, että uuden viimeisen noden viite tiedetään, joten sen `next` voidaan päivittää nopeasti.  
Ajatus oli melkein oikein, mutta tärkein syy jäi nimeämättä: uusi viimeinen solmu saadaan suoraan **`prev`-viitteestä**. :contentReference[oaicite:11]{index=11}

### Oikea / täydellinen vastaus
Doubly linked listissä `tail` osoittaa viimeiseen solmuun ja viimeisellä solmulla on `prev`-viite edelliseen solmuun.  
Siksi lopusta poistettaessa edellinen solmu saadaan heti ilman listan läpikäyntiä, joten operaatio on `O(1)`. :contentReference[oaicite:12]{index=12}

---

## 6. Singly linked listin `append`, kun listalla on `head` ja `tail`

### Missä vastaus oli puutteellinen
Kirjoitin käytännössä vain tämän idean:

```python
append(self, data):
    tail = self.tail
    new_node = Node(data)
    tail.next = new_node
    self.tail = new_node