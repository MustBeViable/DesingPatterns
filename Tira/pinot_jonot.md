# Muistiinpanot – Stacks and Queues

Perustuu luvun sisältöön kohdista, joissa vastasin väärin tai osittain oikein. :contentReference[oaicite:0]{index=0}

## 1. Stack ja random access

### Missä meni osittain väärin
Sanoin käytännössä, että stackista näkyy vain päällimmäinen alkio ulospäin.  
Tämä ei ole varsinainen pääsyy siihen, miksi stack ei sovi satunnaiseen hakuun.

### Oikea / täydellinen vastaus
Stack ei sovi random accessiin, koska sen operaatiot kohdistuvat käytännössä vain huippuun (`top`).  
Jos haluan jonkin muun alkion, minun pitää poistaa päältä alkioita yksi kerrallaan, kunnes pääsen haluttuun kohtaan. :contentReference[oaicite:1]{index=1}

---

## 2. Stackin push ja pop

### Missä meni osittain väärin
Sanoin, että molemmissa tarkistetaan onko stack tyhjä ja handlataan se.  
Tämä ei ole paras yleinen kuvaus.

### Oikea / täydellinen vastaus
- `push` lisää uuden alkion stackin huipulle
- `pop` poistaa stackin huipulla olevan alkion ja palauttaa sen arvon

Tyhjän stackin erikoistapaus on erityisen tärkeä `pop`-operaatiossa. Jos stack on tyhjä, palautetaan `None`. `push` ei yleensä tarvitse samanlaista tyhjyystarkistusta lisäystä varten. :contentReference[oaicite:2]{index=2} :contentReference[oaicite:3]{index=3}

---

## 3. Pop palauttaa datan, ei nodea

### Missä meni osittain väärin
Sanoin, että lopuksi palautetaan juuri otettu node.

### Oikea / täydellinen vastaus
`pop()` palauttaa poistetun noden **sisällön / datan**, ei itse node-oliota.  
Toiminta:
1. tarkista onko stack tyhjä
2. ota vanha top talteen
3. siirrä `top` osoittamaan seuraavaa nodea
4. pienennä kokoa
5. palauta vanhan topin data

Jos stack on tyhjä, palautetaan `None`. :contentReference[oaicite:4]{index=4} :contentReference[oaicite:5]{index=5}

---

## 4. Sulkeiden tasapainotus käyttää yhtä stackia, ei kahta

### Missä meni väärin
Selitin, että avaavat ja sulkevat sulkeet laitetaan eri stackeihin.

### Oikea / täydellinen vastaus
Sulkeiden tasapainon tarkistuksessa käytetään **yhtä stackia**:
- kun tulee avaava sulku `(`, `[`, `{`, se pushataan stackiin
- kun tulee sulkeva sulku `)`, `]`, `}`, stackista popataan päällimmäinen avaava sulku
- tarkistetaan, että ne muodostavat oikean parin
- jos eivät muodosta paria tai stack on tyhjä sulkevan sulun kohdalla, merkkijono ei ole tasapainossa
- lopussa stackin pitää olla tyhjä

Esim. `([{}])` toimii, mutta `([)]` ei toimi. :contentReference[oaicite:6]{index=6}

---

## 5. Queue-operaatioiden nimet

### Missä meni väärin
Käytin joissain kohdissa queuelle nimiä `push` ja `pop`.

### Oikea / täydellinen vastaus
Queuen oikeat perusoperaatiot ovat:
- `enqueue` = lisää alkio jonoon
- `dequeue` = poistaa ja palauttaa jonosta sen alkion, joka on ollut siellä pisimpään

`push` ja `pop` ovat tämän luvun sanastossa stackin operaatiot. :contentReference[oaicite:7]{index=7} :contentReference[oaicite:8]{index=8}

---

## 6. Queue: operaatiot kannattaa kuvata yleisellä tasolla

### Missä meni osittain väärin
Selitin queuen perusoperaatiot suoraan tietyn node-toteutuksen kautta.

### Oikea / täydellinen vastaus
Yleisellä tasolla:
- `enqueue` lisää uuden alkion jonoon
- `dequeue` poistaa jonosta ensimmäisenä sisään tulleen alkion

Tärkeintä on FIFO-periaate, ei se, toteutetaanko se juuri head/tail-nodeilla tai jollain muulla tavalla. :contentReference[oaicite:9]{index=9}

---

## 7. Kahteen stackiin perustuvan queuen amortisoitu tehokkuus

### Missä meni osittain väärin
Selitin oikein, että joskus inbound pitää siirtää kokonaan outboundiin eli tulee O(n), mutta en selittänyt itse amortisoitua ideaa loppuun.

### Oikea / täydellinen vastaus
Kahden stackin queue toimii näin:
- `enqueue` lisää inbound-stackiin
- `dequeue` ottaa outbound-stackista
- jos outbound on tyhjä, inbound siirretään kokonaan outboundiin

Yksittäinen `dequeue` voi siis joskus olla **O(n)**, mutta jokainen alkio siirtyy inboundista outboundiin korkeintaan kerran.  
Siksi monen operaation yli katsottuna keskimääräinen kustannus per operaatio on hyvä eli **amortisoidusti tehokas**. :contentReference[oaicite:10]{index=10}

---

## 8. Doubly linked list ja queue

### Missä meni osittain väärin
Selitin paljon yleistä node-logiikkaa, mutta en vastannut täsmälleen siihen, mitä luvussa painotettiin.

### Oikea / täydellinen vastaus
Doubly linked list sopii hyvin queuen toteuttamiseen, koska:
- listassa voidaan operoida tehokkaasti molemmista päistä
- `head` ja `tail` pidetään yllä
- nodeilla on sekä `next` että `prev`

Tämän ansiosta lisäys ja poisto voidaan tehdä tehokkaasti queuen tarvitsemista päistä ilman koko listan läpikäyntiä. Luvun esimerkissä:
- `enqueue` tehdään fronttiin / headiin
- `dequeue` tehdään tailista `pop()`-operaatiolla :contentReference[oaicite:11]{index=11}

---

## 9. Miksi `remove` ei ole hyvä dequeue-toteutukseen

### Missä meni osittain väärin
Sanoin, että `remove` poistaa noden määrityksen mukaan eikä jonon alusta.  
Tämä ei ollut varsinainen syy, jota luvussa painotettiin.

### Oikea / täydellinen vastaus
`remove` ei ole hyvä dequeue-toteutukseen, koska se joutuu ensin **etsimään** poistettavan noden.  
Jos halutaan poistaa tail, lista voidaan joutua käymään läpi loppuun asti, jolloin aikavaativuus on **O(n)**.

`pop()` on parempi, koska se poistaa päästä suoraan ilman etsimistä. :contentReference[oaicite:12]{index=12}

---

## 10. Queue-rakenteen vähimmäisoperaatiot

### Missä meni väärin
Vastasin `push` ja `pop`.

### Oikea / täydellinen vastaus
Queue-rakenteen vähimmäisoperaatiot ovat:
- `enqueue`
- `dequeue`

Niiden tehtävä:
- `enqueue` lisää alkion jonoon
- `dequeue` poistaa ja palauttaa jonosta vanhimman alkion FIFO-periaatteella :contentReference[oaicite:13]{index=13} :contentReference[oaicite:14]{index=14}

---

## 11. Parillisten ja parittomien paritus kahdella queueella

### Missä meni osittain väärin
Sanoin, että kaikki luvut lisätään ensin jonoihin ja vasta sen jälkeen tehdään parit.

### Oikea / täydellinen vastaus
Perusidea on:
- käytetään kahta queuea: yksi parillisille ja yksi parittomille
- käydään luvut läpi järjestyksessä
- jos nykyiselle luvulle löytyy vastakkaisesta jonosta pari valmiina, muodostetaan pari heti
- jos ei löydy, nykyinen luku laitetaan omaan jonoon odottamaan

Parit siis muodostetaan **järjestyksessä heti kun mahdollista**, ei vasta aivan lopuksi. :contentReference[oaicite:15]{index=15}

---

## 12. Stack vs Queue poistumisjärjestys

### Missä meni väärin
Kirjoitin stackista “eka sisään vika ulos”.

### Oikea / täydellinen vastaus
- **Stack = LIFO** = viimeisenä sisään, ensimmäisenä ulos
- **Queue = FIFO** = ensimmäisenä sisään, ensimmäisenä ulos :contentReference[oaicite:16]{index=16} :contentReference[oaicite:17]{index=17}

---

## 13. Oikea pseudokoodi sulkeiden tasapainotukseen

### Missä meni väärin
Rakensin logiikan kahden stackin varaan.

### Oikea / täydellinen vastaus
Oikea idea on yksi stack:

```python
def balanced(text):
    stack = []

    pairs = {
        ')': '(',
        ']': '[',
        '}': '{'
    }

    for ch in text:
        if ch in '([{':
            stack.append(ch)

        elif ch in ')]}':
            if len(stack) == 0:
                return False

            top = stack.pop()

            if top != pairs[ch]:
                return False

    return len(stack) == 0