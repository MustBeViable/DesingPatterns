# Muistiinpanot: Trees ja BST

## 1. Root node

### Missä vastaukseni oli pielessä
Vastasin, että root on puun **alin** node. Tämä on väärin.

### Oikea vastaus
**Root node** on puun **juurisolmu**, eli ainoa node jolla **ei ole parentia**.  
Se on puun **ylin** node, koska puu kuvataan yleensä ylösalaisin. :contentReference[oaicite:0]{index=0}

---

## 2. Level / Depth vs Height

### Missä vastaukseni oli pielessä
Sekoitin **level/depthin** ja **heightin** toisiinsa. Sanoin käytännössä, että level/depth olisi puun korkeus. Lisäksi sanoin rootin lasten olevan level 2, mikä on väärin.

### Oikea vastaus
**Level** tai **depth** tarkoittaa **edgejen määrää rootin ja kyseisen noden välillä**.
- Root = level 0
- Rootin lapset = level 1
- Niiden lapset = level 2

**Tree height** taas tarkoittaa, **kuinka monta leveliä puussa on**. :contentReference[oaicite:1]{index=1}

---

## 3. Binary tree vs BST

### Missä vastaukseni oli pielessä
Kerroin binary treestä myös säännön, että vasen child olisi pienempi ja oikea suurempi. Tämä ei kuulu tavalliseen binary treehen.

### Oikea vastaus
**Binary tree** tarkoittaa vain sitä, että jokaisella nodella voi olla **enintään kaksi lasta**:
- **left child**
- **right child**

Tavallisessa binary treessä **ei ole pakko olla mitään arvojärjestystä** lasten välillä.  
Arvojärjestys kuuluu vasta **binary search treehen (BST)**. :contentReference[oaicite:2]{index=2} :contentReference[oaicite:3]{index=3}

---

## 4. BST:n järjestyssääntö

### Missä vastaukseni oli pielessä
Sanoin säännön muodossa `left < parent < right`. Idea oli oikein, mutta se ei ollut täysin tarkka.

### Oikea vastaus
BST:ssä jokaiselle nodelle pätee:
- **vasemman puolen arvot ovat pienempiä tai yhtä suuria**
- **oikean puolen arvot ovat suurempia**

Eli tarkemmin:
**left <= parent < right** :contentReference[oaicite:4]{index=4}

---

## 5. Successor

### Missä vastaukseni oli pielessä
Kuvailin successorin lähinnä poistossa käytettäväksi “korvaajanodeksi”. Se on osittain oikein, mutta ei määritelmänä riitä.

### Oikea vastaus
**Successor** on noden **seuraava suurempi arvo** koko BST:ssä.  
Se löytyy näin:
1. siirry ensin **oikeaan lapseen**
2. sitten mene **niin pitkälle vasemmalle kuin mahdollista**

Poistossa successor voidaan käyttää korvaamaan poistettava node, mutta itse käsite tarkoittaa ensisijaisesti **next bigger value**. :contentReference[oaicite:5]{index=5}

---

## 6. Detach

### Missä vastaukseni oli pielessä
Sanoin myös kahden lapsen tapauksen detachin yhteydessä. Se menee liian pitkälle, koska detach yksin ei riitä silloin.

### Oikea vastaus
**Detach** tarkoittaa, että node **irrotetaan puusta muuttamalla viittaukset uudelleen** niin, ettei puu enää osoita siihen nodeen.

Detach onnistuu, kun nodella on:
- **ei lapsia**, tai
- **yksi lapsi**

Jos nodella on **kaksi lasta**, pelkkä detach ei riitä, vaan poistossa tarvitaan successor ja korvausprosessi. :contentReference[oaicite:6]{index=6} :contentReference[oaicite:7]{index=7}

---

## 7. Poisto, kun nodella on kaksi lasta

### Missä vastaukseni oli pielessä
Sanoin lopuksi, että successorin **data siirretään** poistettavan tilalle. Materiaalissa idea on tarkemmin se, että successor-node korvaa poistettavan noden paikan viittauksien avulla.

### Oikea vastaus
Kun poistettavalla nodelle on **kaksi lasta**, vaiheet ovat:
1. **etsi successor**
2. **detachaa successor** vanhasta paikastaan
3. **korvaa poistettava node successorilla**

Eli kyse ei ole vain datan kopioinnista, vaan noden paikan korvaamisesta viittauksia muuttamalla. :contentReference[oaicite:8]{index=8}

---

## 8. Breadth-first traversal

### Missä vastaukseni oli pielessä
Selityksessäni tuli mukaan “oikean noden tarkistaminen”, mikä ei kuulu traversal-idean ytimeen.

### Oikea vastaus
**Breadth-first traversal** käy puun läpi **level kerrallaan**, yleensä **vasemmalta oikealle**.  
Toteutuksessa käytetään yleensä **queuea**:
1. lisää root jonoon
2. ota jonon ensimmäinen node
3. käsittele sen arvo
4. lisää sen vasen ja oikea lapsi jonoon, jos ne ovat olemassa
5. toista kunnes jono on tyhjä :contentReference[oaicite:9]{index=9} :contentReference[oaicite:10]{index=10}

---

## 9. In-order traversal

### Missä vastaukseni oli pielessä
Selitin ideaa osittain oikein, mutta en antanut täsmällistä järjestystä. Puhuin enemmän leafeistä ja parenteista yleisesti.

### Oikea vastaus
**In-order traversal** etenee järjestyksessä:

**left → parent → right**

BST:ssä tämä antaa arvot yleensä **pienimmästä suurimpaan**. :contentReference[oaicite:11]{index=11} :contentReference[oaicite:12]{index=12}

---

## 10. Pre-order traversal

### Missä vastaukseni oli pielessä
Idea rootin käsittelystä ensin oli oikein, mutta selitys ei ollut tarpeeksi tarkka.

### Oikea vastaus
**Pre-order traversal** etenee järjestyksessä:

**parent → left → right** :contentReference[oaicite:13]{index=13} :contentReference[oaicite:14]{index=14}

---

## 11. Post-order traversal

### Missä vastaukseni oli pielessä
Vastasin PDF:n tekstin mukaan oikein, mutta materiaalissa on tästä kohdasta ristiriita.

### Oikea vastaus
PDF:n **tekstissä** post-order annetaan muodossa:

**right → left → parent** :contentReference[oaicite:15]{index=15}

Mutta PDF:n **koodissa** toteutus on:

**left → right → parent** :contentReference[oaicite:16]{index=16}

Yleisesti post-order tarkoittaa tavallisesti:

**left → right → parent**

Eli tästä kohdasta kannattaa muistaa, että materiaalissa on **epäjohdonmukaisuus**.