# Muistiinpanot – Algorithm design techniques

Nämä muistiinpanot käsittelevät kohdat, joissa vastaus oli väärin tai osittain oikein. Jokaisessa kohdassa on lyhyt korjaus ja ytimekäs mallivastaus.

---

## 1. Rekursion base case

### Mikä meni pieleen?
Base case ei tarkoita ensimmäistä funktiokutsua, kuten `fib(100)`. Se tarkoittaa ehtoa, jossa rekursio pysähtyy.

### Oikea vastaus
**Base case** on rekursion pysäytysehto. Kun base case saavutetaan, funktio ei enää kutsu itseään uudelleen.

```python
def factorial(n):
    if n == 1:      # base case
        return 1
    return n * factorial(n - 1)
```

Jos kutsutaan `factorial(5)`, ensimmäinen kutsu on `factorial(5)`, mutta base case on `factorial(1)`.

---

## 2. Backtracking

### Mikä meni osittain pieleen?
Backtracking liittyy kyllä rekursion kutsupinoon ja LIFO-ajatteluun, mutta se ei tarkoita pelkästään kutsupinon purkamista.

### Oikea vastaus
**Backtracking** tarkoittaa, että kokeillaan yhtä mahdollista ratkaisupolkua. Jos se ei toimi tai kaikki vaihtoehdot siitä kohdasta on kokeiltu, palataan taaksepäin ja kokeillaan toista vaihtoehtoa.

Lyhyesti:

> Backtracking on rekursion muoto, jossa kokeillaan valintoja yksi kerrallaan ja palataan taaksepäin, jos valittu polku ei johda ratkaisuun.

Esimerkkejä:
- graafin läpikäynti
- labyrintin ratkaiseminen
- permutaatiot
- sudoku-tyyppiset ongelmat

---

## 3. Merge sortin aikavaativuus

### Mikä meni pieleen?
Vastaus `log2(log2(n))` ei kuvaa merge sortin aikavaativuutta.

### Oikea vastaus
Merge sortin aikavaativuus on:

| Tapaus | Aikavaativuus |
|---|---|
| Paras | `O(n log n)` |
| Keskimääräinen | `O(n log n)` |
| Pahin | `O(n log n)` |

### Miksi?
Merge sort jakaa listan puoliksi noin `log n` tasoa. Jokaisella tasolla kaikki alkiot käsitellään yhdistämisessä yhteensä noin kerran, eli työmäärä yhdellä tasolla on `O(n)`.

Siksi:

```text
tasojen määrä * työ per taso
= log n * n
= O(n log n)
```

Lyhyesti:

> Merge sort on aina `O(n log n)`, koska lista jaetaan puoliksi ja jokaisella tasolla yhdistetään kaikki alkiot.

---

## 4. Merge sort ei ole yleensä in-place

### Mikä meni osittain pieleen?
Ajatus uusien listojen luomisesta oli oikein. Tärkein syy on kuitenkin tarkemmin se, että yhdistämisvaihe tarvitsee ylimääräistä muistia.

### Oikea vastaus
Merge sort ei yleensä ole **in-place**, koska se tarvitsee väliaikaisen apulistan tai apurakenteen kahden järjestetyn puoliskon yhdistämiseen.

Lyhyesti:

> Merge sort tarvitsee yleensä `O(n)` lisämuistia, joten se ei ole tavallisella array/lista-toteutuksella in-place-algoritmi.

---

## 5. Tavallinen rekursiivinen Fibonacci

### Mikä meni pieleen?
Tavallisen rekursiivisen Fibonaccin aikavaativuus ei ole `O(n!)`, vaan noin `O(2^n)`.

### Oikea vastaus
Tavallinen rekursiivinen Fibonacci on hidas, koska jokainen kutsu haarautuu kahdeksi uudeksi kutsuksi:

```python
fib(n) = fib(n - 1) + fib(n - 2)
```

Sama arvo lasketaan monta kertaa uudelleen.

Esimerkiksi:

```text
fib(5)
├── fib(4)
│   ├── fib(3)
│   └── fib(2)
└── fib(3)
    ├── fib(2)
    └── fib(1)
```

Tässä esimerkiksi `fib(3)` ja `fib(2)` lasketaan useaan kertaan.

Lyhyesti:

> Tavallinen rekursiivinen Fibonacci on noin `O(2^n)`, koska kutsupuu kasvaa nopeasti ja samoja osaongelmia lasketaan uudelleen.

---

## 6. Greedy algorithm

### Mikä meni osittain pieleen?
Greedy ei tarkoita varsinaisesti “ensimmäisen ratkaisun” etsimistä. Tarkemmin greedy tekee jokaisessa vaiheessa paikallisesti parhaalta näyttävän valinnan.

### Oikea vastaus
**Greedy-algoritmi** tekee jokaisessa vaiheessa sillä hetkellä parhaalta vaikuttavan valinnan.

Ongelma on, että paikallisesti paras valinta ei aina johda parhaaseen kokonaisratkaisuun.

Esimerkki kolikko-ongelmasta:

```text
Kolikot: 8, 5, 1
Summa: 12
```

Greedy valitsee:

```text
8 + 1 + 1 + 1 + 1 = 5 kolikkoa
```

Parempi ratkaisu olisi:

```text
5 + 5 + 1 + 1 = 4 kolikkoa
```

Lyhyesti:

> Greedy-algoritmi valitsee jokaisessa vaiheessa paikallisesti parhaan vaihtoehdon, mutta se ei aina tuota globaalisti parasta ratkaisua.

---

## 7. Miksi Dijkstra on greedy-algoritmi?

### Mikä meni osittain pieleen?
Dijkstra kyllä ylläpitää lyhimpiä tunnettuja etäisyyksiä, mutta greedy-ajatus näkyy erityisesti siinä, miten seuraava vertex valitaan.

### Oikea vastaus
Dijkstra on greedy-algoritmi, koska se valitsee jokaisella kierroksella seuraavaksi käsiteltäväksi sen vierailemattoman vertexin, jolla on pienin tunnettu etäisyys lähtövertexistä.

Lyhyesti:

> Dijkstra on greedy, koska se tekee jokaisessa vaiheessa paikallisesti parhaan valinnan: valitsee lähimmän vielä käsittelemättömän vertexin.

Tämä toimii oikein, kun graafin edge-painot eivät ole negatiivisia.

---

## 8. Dijkstra ja negatiiviset edge-painot

### Mikä meni osittain pieleen?
Negatiivinen edge on kyllä “pieni” arvo, mutta varsinainen ongelma on se, että Dijkstra lukitsee vertexejä liian aikaisin.

### Oikea vastaus
Dijkstra olettaa, että kun vertex valitaan pienimmän tunnetun etäisyyden perusteella, sen lyhin etäisyys on lopullinen.

Negatiivinen edge voi kuitenkin myöhemmin tuottaa vielä lyhyemmän reitin jo käsiteltyyn vertexiin.

Esimerkki:

```text
A -> B = 2
A -> C = 5
C -> B = -10
```

Aluksi näyttää siltä, että lyhin reitti B:hen on:

```text
A -> B = 2
```

Mutta myöhemmin löytyisi:

```text
A -> C -> B = -5
```

Jos B on jo käsitelty, Dijkstra ei välttämättä korjaa tulosta oikein.

Lyhyesti:

> Dijkstra ei toimi luotettavasti negatiivisilla painoilla, koska negatiivinen edge voi myöhemmin parantaa jo lukitun vertexin etäisyyttä.

---

## 9. Dijkstran shortest_path_table

### Mikä meni osittain pieleen?
`shortest_path_table` ei yleensä säilytä tietoa siitä, onko vertex käyty. Se tieto pidetään usein erillisessä rakenteessa, kuten `unvisited_vertices`.

### Oikea vastaus
Dijkstran `shortest_path_table` säilyttää jokaiselle vertexille yleensä:

| Kenttä | Merkitys |
|---|---|
| `shortest` | Lyhin tähän asti tunnettu etäisyys lähtövertexistä |
| `previous` | Edellinen vertex tällä lyhimmällä reitillä |

Esimerkki:

```python
{
    A: {"shortest": 0, "previous": None},
    B: {"shortest": 5, "previous": A},
    C: {"shortest": 8, "previous": B}
}
```

Lyhyesti:

> `shortest_path_table` säilyttää lyhimmän tunnetun etäisyyden ja edellisen vertexin, jonka kautta tämä reitti kulkee.

---

## 10. Dijkstran lopullisen reitin muodostaminen

### Mikä jäi puuttumaan?
Kun taulukko on laskettu, itse reitti täytyy vielä rakentaa `previous`-viitteiden avulla.

### Oikea vastaus
Reitti muodostetaan aloittamalla kohdevertexistä ja seuraamalla `previous`-viitteitä taaksepäin lähtövertexiin asti.

Pseudokoodi:

```python
path = []
current = destination

while current is not None:
    path.append(current)
    current = table[current]["previous"]

path.reverse()
```

Lyhyesti:

> Dijkstran reitti rakennetaan kulkemalla kohteesta taaksepäin `previous`-viitteitä pitkin ja kääntämällä lopuksi saatu lista.

---

## 11. Dijkstran aikavaativuus Python-listalla

### Mikä jäi puuttumaan?
Jos vierailemattomat vertexit säilytetään tavallisessa listassa ja pienin etäisyys haetaan `min()`-funktiolla, aikavaativuus on `O(n²)`.

### Oikea vastaus
Kun pienin vertex etsitään listasta joka kierroksella:

```text
min() = O(n)
kierroksia noin n
```

Siksi:

```text
n * O(n) = O(n²)
```

Lyhyesti:

> Dijkstra on Python-listalla toteutettuna yleensä `O(n²)`, koska pienimmän etäisyyden vertex etsitään lineaarisesti jokaisella kierroksella.

Priority queue / heap -toteutuksella se voi olla tehokkaampi:

```text
O((n + m) log n)
```

missä:
- `n` = vertexien määrä
- `m` = edgejen määrä

---

## 12. Memoization vs cache

### Mikä jäi puuttumaan?
Memoization ja cache liittyvät vahvasti toisiinsa, mutta ne eivät ole täysin sama asia.

### Oikea vastaus
**Cache** on yleinen välimuisti: tallennetaan aiemmin laskettua tai haettua dataa myöhempää käyttöä varten.

**Memoization** on tietty cache-tekniikka, jossa funktion tulos tallennetaan sen syötteen perusteella.

Esimerkki:

```python
cache = {}

def fib(n):
    if n in cache:
        return cache[n]

    if n < 2:
        result = 1
    else:
        result = fib(n - 1) + fib(n - 2)

    cache[n] = result
    return result
```

Lyhyesti:

> Cache on yleinen välimuisti. Memoization on cache-tekniikka, jossa funktion tulokset tallennetaan syötteen perusteella.

---

## 13. Tabulation-Fibonacci

### Mikä meni osittain pieleen?
Ratkaisun rakenne oli lähes oikein, mutta rivillä

```python
value += prev_prev + prev
```

käytettiin yhteenlaskun päälle lisäämistä. Fibonaccissa uusi arvo pitää asettaa kahden edellisen summaksi, ei lisätä vanhan `value`-arvon päälle.

### Oikea vastaus

```python
def fib(n):
    if n < 2:
        return 1

    prev_prev = 1
    prev = 1

    for _ in range(n - 1):
        result = prev_prev + prev
        prev_prev, prev = prev, result

    return prev
```

Lyhyesti:

> Tabulation-Fibonacci lasketaan iteratiivisesti alhaalta ylöspäin pitäen muistissa vain kaksi edellistä arvoa.

---

# Tiivistelmä tärkeimmistä korjauksista

| Aihe | Muista tämä |
|---|---|
| Base case | Rekursion pysäytysehto, ei ensimmäinen kutsu |
| Backtracking | Kokeillaan polkua, peruutetaan ja kokeillaan toista |
| Merge sort | Aikavaativuus aina `O(n log n)` |
| Merge sort memory | Tarvitsee yleensä `O(n)` lisämuistia |
| Recursive Fibonacci | Tavallinen versio on noin `O(2^n)`, ei `O(n!)` |
| Greedy | Valitsee paikallisesti parhaan vaihtoehdon |
| Dijkstra greedy | Valitsee aina lähimmän vierailemattoman vertexin |
| Negative edges | Dijkstra voi lukita vertexin liian aikaisin |
| shortest_path_table | Säilyttää `shortest` ja `previous` |
| Dijkstra path | Seurataan `previous`-viitteitä kohteesta lähtöön |
| Dijkstra listalla | `O(n²)` |
| Memoization | Funktion tulosten cachettaminen |
| Tabulation | Bottom-up, usein iteratiivinen |
