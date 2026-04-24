# Muistiinpanot: Sorting-algoritmit – korjaukset ja täydelliset vastaukset

## 1. Milloin lajittelu ennen hakua voi olla turhaa?

### Oma vastaus
> Jos lista on pieni tai jo järjestyksessä.

### Korjaus
Pieni lista voi olla hyvä syy sille, ettei lajittelusta ole paljon hyötyä.  
Mutta jos lista on **jo järjestyksessä**, lajittelu ei ole enää tarpeen, ja tehokkaita hakualgoritmeja kuten binary search voidaan käyttää suoraan.

Tärkein kohta: lajittelu ennen hakua voi olla turhaa, jos tehdään vain **yksi tai muutama haku**.

### Oikea vastaus
Lajittelu auttaa hakua, koska järjestetystä listasta voidaan hakea tehokkaammin esimerkiksi binary searchilla. Jos etsitään vain yhtä arvoa, lajittelu ensin on usein turhaa, koska lajittelun kustannus voi olla suurempi kuin suora lineaarinen haku. Jos hakuja tehdään paljon samaan dataan, lajittelu kannattaa.

---

## 2. Insertion sortin toiminta

### Oma vastaus
> Insertion sortissa valitaan kierroksen verrattava indeksi ja se on yleensä listan eka...

### Korjaus
Insertion sortissa ensimmäinen alkio ajatellaan valmiiksi järjestetyksi, mutta varsinainen käsiteltävä arvo eli `key` aloitetaan yleensä **toisesta alkiosta**.

Tärkeä korjaus: jos uusi arvo on pienempi kuin edellinen, oikea paikka ei ole vielä löytynyt. Silloin pitää jatkaa taaksepäin ja siirtää suurempia arvoja oikealle. Oikea paikka löytyy, kun vastaan tulee arvo, joka on pienempi tai yhtä suuri kuin `key`, tai listan alku tulee vastaan.

### Oikea vastaus
Insertion sort jakaa listan kahteen osaan: vasemmalla oleva järjestetty osa ja oikealla oleva käsittelemätön osa. Algoritmi ottaa seuraavan arvon eli `keyn`, etsii sille oikean paikan järjestetystä osasta vertaamalla taaksepäin, siirtää tarvittaessa suurempia alkioita oikealle ja lisää `keyn` oikeaan kohtaan.

---

## 3. Selection sortin aikavaativuus

### Oma vastaus
> O(n), kun järjestyksessä, O(n²) muuten vaikka nopeempi kuin insertion sort.

### Korjaus
Selection sortin aikavaativuus on **aina `O(n²)`**, myös parhaassa tapauksessa.

Vaikka lista olisi jo järjestyksessä, Selection sort etsii silti jokaisella kierroksella pienimmän alkion koko jäljellä olevasta järjestämättömästä osasta. Se ei siis lopeta aikaisin.

Selection sort ei myöskään ole yleensä nopeampi kuin Insertion sort. Sen etu on lähinnä vähäinen määrä vaihtoja/kirjoituksia.

### Oikea vastaus
Selection sortin aikavaativuus on parhaassa, keskimääräisessä ja pahimmassa tapauksessa `O(n²)`, koska se käy jokaisella kierroksella läpi jäljellä olevan järjestämättömän osan löytääkseen pienimmän alkion.

---

## 4. Quicksortin toiminta

### Oma vastaus
> Quicksort on divide and conquer algoritmi eli jaetaan lista valitun pivotin mukaan pivotista pienempiin ja suurempiin...

### Korjaus
Perusidea oli oikein, mutta pari kohtaa vaati tarkennusta.

Pivot ei ole aina “yleensä” ensimmäinen tai viimeinen alkio. Ne ovat yksinkertaisia vaihtoehtoja, mutta eivät aina hyviä. Erityisesti ensimmäinen alkio pivotina voi olla huono, jos lista on jo järjestyksessä.

Quicksort ei jatku siihen asti, että “ei ole enää pivotia isompia tai pienempiä”, vaan siihen asti, että aliosat ovat kooltaan `0` tai `1`.

### Oikea vastaus
Quicksort valitsee pivot-alkion ja jakaa nykyisen listan osan niin, että pivotia pienemmät tai yhtä suuret arvot menevät pivotin toiselle puolelle ja suuremmat toiselle puolelle. Kun pivot asetetaan paikalleen, se on lopullisesti oikeassa kohdassa. Sen jälkeen quicksort kutsutaan rekursiivisesti pivotin vasemmalle ja oikealle puolelle jääville osille, kunnes osat ovat kooltaan `0` tai `1`.

---

## 5. Miksi pivotin valinta vaikuttaa Quicksortin suorituskykyyn?

### Oma vastaus
> Jos pivot on vaikea laskea partition arraysta se hidastaa algoritmia.

### Korjaus
Pivotin laskemisen kustannus voi vaikuttaa vähän, mutta tärkein asia on se, **kuinka tasaisesti pivot jakaa listan osiin**.

Jos pivot jakaa listan tasaisesti, Quicksort on tehokas. Jos pivot on jatkuvasti pienin tai suurin alkio, jako on erittäin epätasainen ja algoritmi hidastuu pahimmillaan `O(n²)`-tasolle.

### Oikea vastaus
Pivotin valinta vaikuttaa suorituskykyyn, koska hyvä pivot jakaa listan suunnilleen kahteen yhtä suureen osaan. Silloin Quicksort toimii ajassa `O(n log n)`. Huono pivot voi jättää toisen osan lähes tyhjäksi ja toisen lähes koko listan kokoiseksi, jolloin pahin tapaus on `O(n²)`.

---

## 6. Naive Heapsort

### Oma vastaus
> Heapsort käyttää max heapia apuna. Ensin listalle tehdään heapify eli muodostetaan max heap...

### Korjaus
Vastaus kuvasi hyvin **in-place Heapsortia**, mutta kysymys koski **naive Heapsortia**, jossa käytetään erillistä heap-rakennetta.

Naive-versiossa ei tehdä heapifya suoraan alkuperäiseen arrayhin, vaan luodaan erillinen heap.

### Oikea vastaus
Naive Heapsort toimii näin:

1. Luodaan uusi tyhjä heap.
2. Lisätään kaikki listan arvot heapiin.
3. Poistetaan arvot heapista yksi kerrallaan.
4. Poistetut arvot muodostavat järjestetyn listan.

Naive Heapsortin aikavaativuus on `O(n log n)`, mutta muistinkäyttö on `O(n)`, koska se käyttää erillistä heap-rakennetta.

---

## 7. Miksi in-place Heapsortissa käytetään usein max heapia?

### Oma kysymys
> Miksi muuten ei käytetä min heapia tässä vaan max heap?

### Selitys
Max heap sopii nousevaan lajitteluun in-place-version kanssa, koska suurin arvo on aina rootissa eli indeksissä `0`. Se voidaan vaihtaa heapin viimeiseen kohtaan, jolloin suurin arvo menee heti lopulliseen paikkaansa listan oikeaan reunaan.

Sen jälkeen heapin kokoa pienennetään yhdellä, eikä järjestettyä loppuosaa enää käsitellä heapin osana.

### Oikea vastaus
In-place Heapsortissa käytetään usein max heapia, koska suurin arvo voidaan siirtää suoraan arrayn loppuun oikealle lopulliselle paikalleen. Näin lista rakentuu nousevaan järjestykseen oikealta vasemmalle ilman erillistä muistirakennetta.

---

## 8. `sift_down` / sink Heapsortissa

### Oma vastaus
> Sift_down eli sink on että etsitään uusin suurin arvo.

### Korjaus
`sift_down` ei tarkoita koko heapin suurimman arvon etsimistä. Se tarkoittaa yhden solmun siirtämistä alaspäin heapissa, kunnes heap-ominaisuus on taas kunnossa.

Max heapissa parentin pitää olla suurempi tai yhtä suuri kuin sen lapset.

### Oikea vastaus
`sift_down` vertaa tietyn indeksin arvoa sen lapsiin. Jos jompikumpi lapsista on suurempi, arvo vaihdetaan suuremman lapsen kanssa. Tätä jatketaan alaspäin, kunnes arvo on suurempi kuin lapsensa tai se päätyy lehteen. Sitä tarvitaan heapifyn aikana ja aina sen jälkeen, kun root vaihdetaan heapin viimeisen arvon kanssa.

---

## 9. Miksi heapify aloitetaan indeksistä `len(array)//2 - 1`?

### Oma vastaus
> Kerro.

### Selitys
Heap-arrayn jälkimmäinen puolikas koostuu lehdistä. Lehdillä ei ole lapsia, joten niitä ei tarvitse sinkata.

`sift_down` tarvitaan vain nodeille, joilla voi olla lapsia. Siksi heapify aloitetaan viimeisestä parent-nodesta.

### Oikea vastaus
Heapify voidaan aloittaa indeksistä `len(array)//2 - 1`, koska se on viimeinen parent-node. Kaikki sen jälkeiset nodet ovat lehtiä, eikä niitä tarvitse käsitellä. Heapify tehdään tästä indeksistä taaksepäin kohti rootia.

Esimerkki:

```python
array = [6, 8, 5, 1, 2]
len(array) = 5

viimeinen parent = len(array)//2 - 1
                 = 5//2 - 1
                 = 1
```
Child-kaavat:
```python
left_child = 2*i + 1
right_child = 2*i + 2
```
---

## 10. Algoritmien vertailu

### Oma vastaus

> Bubble, insertion ja selection sortit toimivat hyvin pienissä listoissa joista nopein keskikokoisille listoille on selection sort...

### Korjaus

Bubble sort on yleensä huonoin näistä käytännössä. Sitä käytetään lähinnä opetteluun.

Insertion sort on usein paras pienille tai lähes järjestetyille listoille.

Selection sort ei ole yleensä nopein keskikokoisille listoille. Sen vahvuus on vähäinen kirjoitusten/vaihtojen määrä.

Quicksort on usein todella nopea käytännössä, mutta pahimmillaan `O(n²)`.

Heapsort on turvallisempi siinä mielessä, että sen aikavaativuus pysyy `O(n log n)` myös pahimmassa tapauksessa.

Muistin suhteen in-place Heapsort käyttää yleensä vähemmän lisämuistia kuin Quicksort, koska Quicksort käyttää rekursiopinoa.

---

### Oikea vastaus

#### Bubble sort

- Toiminta: Verrataan vierekkäisiä alkioita ja vaihdetaan ne, jos ne ovat väärässä järjestyksessä. Jokaisella kierroksella suurin järjestämätön alkio siirtyy listan loppuun.
- Helppo ymmärtää.
- Käytännössä hidas.
- Paras tapaus `O(n)`, keskimäärin ja pahin `O(n²)`.
- Sopii lähinnä opetteluun.

#### Insertion sort

- Toiminta: Ensimmäinen alkio ajatellaan järjestetyksi. Sen jälkeen otetaan seuraava alkio eli `key`, etsitään sille oikea paikka vasemmalta järjestetystä osasta ja siirretään tarvittaessa suurempia alkioita oikealle.
- Hyvä pienille listoille.
- Hyvä lähes järjestetylle datalle.
- Paras tapaus `O(n)`, keskimäärin ja pahin `O(n²)`.
- Usein parempi käytännössä kuin Bubble sort ja Selection sort pienillä listoilla.

#### Selection sort

- Toiminta: Etsitään järjestämättömästä osasta pienin alkio ja vaihdetaan se järjestämättömän osan ensimmäiseen paikkaan. Tätä jatketaan vasemmalta oikealle.
- Aina `O(n²)`, myös parhaassa tapauksessa.
- Tekee vähän vaihtoja/kirjoituksia.
- Voi olla järkevä, jos kirjoitusoperaatiot ovat kalliita tai rajoitettuja.

#### Quicksort

- Toiminta: Valitaan pivot ja jaetaan lista pivotia pienempiin tai yhtä suuriin sekä pivotia suurempiin arvoihin. Pivot päätyy oikealle paikalleen, ja sama tehdään rekursiivisesti vasemmalle ja oikealle osalle.
- Divide and conquer -algoritmi.
- Keskimäärin ja parhaassa tapauksessa `O(n log n)`.
- Pahimmillaan `O(n²)`.
- Usein erittäin nopea käytännössä, jos pivot valitaan hyvin.
- Huono pivot-valinta voi tehdä siitä hitaan.

#### Heapsort

- Toiminta: Lista muutetaan max heapiksi. Suurin arvo on rootissa, joten se vaihdetaan listan loppuun. Heapin kokoa pienennetään ja uusi root sinkataan oikeaan paikkaan. Tätä jatketaan, kunnes lista on järjestyksessä.
- Perustuu heap-rakenteeseen.
- Aina `O(n log n)`.
- In-place-version lisämuisti on yleensä `O(1)`.
- Hyvä valinta, jos halutaan varma `O(n log n)` -suorituskyky.

---

## Lyhyt koonti tärkeimmistä korjauksista

- Selection sort on **aina `O(n²)`**, myös parhaassa tapauksessa.
- Insertion sortissa `keyn` oikea paikka löytyy, kun vasemmalta löytyy arvo, joka on **pienempi tai yhtä suuri kuin `key`**.
- Quicksortin tehokkuus riippuu siitä, jakaako pivot listan **tasaisesti**.
- Huono pivot-valinta voi tehdä Quicksortista `O(n²)`.
- Naive Heapsort käyttää **erillistä heap-rakennetta** ja vie `O(n)` lisämuistia.
- In-place Heapsort rakentaa heapin suoraan samaan arrayhin ja käyttää yleensä `O(1)` lisämuistia.
- `sift_down` ei etsi koko heapin suurinta arvoa, vaan siirtää yhden arvon alaspäin oikeaan paikkaan.
- Heapify aloitetaan kohdasta `len(array)//2 - 1`, koska sen jälkeen olevat nodet ovat lehtiä.

### Algoritmien vertailu

Bubble sort:
- Toiminta: Verrataan vierekkäisiä alkioita ja vaihdetaan ne, jos ne ovat väärässä järjestyksessä. Jokaisella kierroksella suurin järjestämätön alkio “kuplii” listan loppuun.
- Helppo ymmärtää, mutta käytännössä hidas.
- Paras tapaus O(n), keskimäärin ja pahin O(n²).
- Sopii lähinnä opetteluun, ei yleensä oikeaan käyttöön.

Insertion sort:
- Toiminta: Ensimmäinen alkio ajatellaan järjestetyksi. Sen jälkeen otetaan seuraava alkio eli key ja etsitään sille oikea paikka vasemmalta järjestetystä osasta siirtämällä suurempia alkioita oikealle.
- Hyvä pienille listoille ja lähes järjestetylle datalle.
- Paras tapaus O(n), keskimäärin ja pahin O(n²).
- Käytännössä usein parempi kuin Bubble sort ja Selection sort pienillä datoilla.

Selection sort:
- Toiminta: Etsitään järjestämättömästä osasta pienin alkio ja vaihdetaan se järjestämättömän osan ensimmäiseen paikkaan. Tätä jatketaan vasemmalta oikealle.
- Aina O(n²), myös jos lista on jo järjestyksessä.
- Etuna vähän vaihtoja/kirjoituksia.
- Voi olla järkevä, jos kirjoitusoperaatiot ovat kalliita tai rajoitettuja.

Quicksort:
- Toiminta: Valitaan pivot ja jaetaan lista pivotia pienempiin tai yhtä suuriin sekä pivotia suurempiin arvoihin. Pivot päätyy oikealle paikalleen, ja sama tehdään rekursiivisesti vasemmalle ja oikealle osalle.
- Divide and conquer -algoritmi.
- Keskimäärin ja parhaassa tapauksessa O(n log n), pahimmillaan O(n²).
- Usein erittäin nopea käytännössä, jos pivot valitaan hyvin.
- Huono pivot-valinta voi tehdä siitä hitaan.

Heapsort:
- Toiminta: Lista muutetaan max heapiksi. Suurin arvo on rootissa, joten se vaihdetaan listan loppuun. Heapin kokoa pienennetään ja uusi root sinkataan oikeaan paikkaan. Tätä jatketaan, kunnes lista on järjestyksessä.
- Perustuu heap-rakenteeseen.
- Aikavaativuus O(n log n) myös pahimmassa tapauksessa.
- In-place-version lisämuisti on yleensä O(1).
- Hyvä valinta, jos halutaan varma O(n log n) -suorituskyky.