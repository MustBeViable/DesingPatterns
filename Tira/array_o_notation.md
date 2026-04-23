# Muistiinpanot – Algorithm performance basics / arrayt / Big O

Tässä ovat ne kohdat, joihin vastasin väärin tai osittain oikein, sekä niiden oikeat tai täydemmät vastaukset.

---

## 1. Mitä tarkoittaa `O(1)`?

### Missä vastaukseni oli puutteellinen
Sanoin, että se on “paras mahdollinen Big O nopeus” ja että suoritus tapahtuu “heti”.

### Oikea / täydellinen vastaus
`O(1)` tarkoittaa **vakioaikaista** tai **vakiotilaista** toimintaa.  
Sen kustannus **ei kasva syötteen koon mukana**.

Tämä ei tarkoita:
- että se tapahtuisi kirjaimellisesti heti
- että aika olisi nolla
- eikä sitä kannata ilmaista vain “parhaana mahdollisena”

Parempi muoto:
> `O(1)` tarkoittaa, että operaation kustannus pysyy vakiona riippumatta siitä, kuinka suuri syöte on.

### Esimerkkejä materiaalista
- arrayn luonti: `O(1)`
- arvon lukeminen tunnetulla indeksillä: `O(1)`

---

## 2. Staattinen vs dynaaminen array

### Missä vastaukseni oli puutteellinen
Sanoin oikein, että staattinen on kiinteän kokoinen ja dynaamisessa on extraslotteja, mutta vastaus jäi hieman vajaaksi.

### Oikea / täydellinen vastaus
**Staattinen array**
- koko määritellään luodessa
- kokoa ei voi muuttaa
- jos halutaan lisää tilaa, pitää luoda uusi array ja kopioida vanhat alkiot

**Dynaaminen array**
- sisältää ylimääräistä kapasiteettia kasvua varten
- pitää yllä kahta kokoa:
    - **logical size** = käytössä olevien alkioiden määrä
    - **physical size** = muistissa varattu kokonaiskapasiteetti
- kun tila loppuu, luodaan uusi suurempi array ja kopioidaan vanhat alkiot

---

## 3. Logical size ja physical size

### Missä vastaukseni oli puutteellinen
Sanoin “sillä hetkellä oleva array”, mikä oli vähän epätarkka.

### Oikea / täydellinen vastaus
- **Logical size** = kuinka monta alkiota arrayssa on oikeasti käytössä
- **Physical size** = kuinka paljon muistia arraysle on varattu yhteensä, myös tyhjät kasvupaikat mukaan lukien

Parempi muoto:
> Logical size on käytössä olevien alkioiden määrä, physical size on koko varattu kapasiteetti.

---

## 4. Growth factor

### Missä vastaukseni oli puutteellinen
Ajatus oli oikeansuuntainen, mutta selitin sen liikaa oman esimerkin kautta enkä materiaalin tavalla.

### Oikea / täydellinen vastaus
**Growth factor** kertoo, kuinka paljon ylimääräistä tilaa varataan, kun dynaaminen array luodaan tai sitä kasvatetaan.

Materiaalin esimerkki:
- logical size = `5`
- growth factor = `2`
- varataan toiset `5` paikkaa lisää
- physical size = `10`

Eli growth factor kuvaa lisäkapasiteetin määrää suhteessa käytössä olevaan kokoon.

---

## 5. Amortized `O(1)`

### Missä vastaukseni oli puutteellinen
Sanoin oikein, että joskus operaatio on `O(1)` ja joskus `O(n)`, mutta jätin keskimääräisen idean vajaaksi.

### Oikea / täydellinen vastaus
**Amortized `O(1)`** tarkoittaa, että vaikka yksittäinen operaatio ei aina ole `O(1)`,  
**pitkällä aikavälillä keskimääräinen kustannus per operaatio on `O(1)`**.

Esimerkiksi dynaamisessa arrayssa loppuun lisääminen:
- useimmiten `O(1)`, jos tilaa on vielä
- joskus `O(n)`, jos pitää kasvattaa array ja kopioida sisältö

Silti monen lisäyksen keskimääräinen kustannus per lisäys on `O(1)`.

---

## 6. Miksi keskelle lisääminen on dynaamisessakin arrayssa `O(n)`?

### Missä vastaukseni oli puutteellinen
Sanoin, että pitää kopioida kaikki alkiot, vaikka aina ei tarvitse tehdä uutta taulukkoa.

### Oikea / täydellinen vastaus
Keskelle lisääminen on `O(n)`, koska lisäyskohdan jälkeen olevia alkioita pitää **siirtää oikealle**, jotta uudelle alkiolle saadaan tilaa.

Tärkeä pointti:
- ongelma ei ole aina uuden arrayn luominen
- ongelma on usein **alkioiden siirtäminen**

Parempi muoto:
> Keskelle lisääminen on `O(n)`, koska pahimmassa tapauksessa lähes kaikki lisäyskohdan jälkeiset alkiot pitää siirtää.

---

## 7. Miksi `find_pair` on `O(n²)`?

### Missä vastaukseni oli puutteellinen
Sanoin “lista käydään 2 kertaa läpi”, mikä voi kuulostaa kahdelta peräkkäiseltä silmukalta.

### Oikea / täydellinen vastaus
`find_pair` on `O(n²)`, koska siinä on **kaksi sisäkkäistä silmukkaa**:
- ulompi silmukka käy `n` kertaa
- sisempi silmukka käy jokaisella kierroksella myös `n` kertaa

Siksi kokonaismäärä on:
`n * n = n²`

Tärkeä ero:
- **peräkkäiset silmukat** → yleensä `O(n)`
- **sisäkkäiset silmukat** → tässä `O(n²)`

---

## 8. Miksi `f(n) = c·n² + d` → `O(n²)`?

### Missä vastaukseni oli puutteellinen
Sanoin, että katsotaan vain suurinta n:n potenssia. Se toimii tässä, mutta ei ole kaikkein täsmällisin yleissääntö.

### Oikea / täydellinen vastaus
Big O:ssa katsotaan **hallitsevaa termiä**, eli sitä osaa funktiosta, joka kasvaa nopeimmin suurilla syötteillä.

Esimerkissä:
- `c·n² + d`
- vakio `d` ei vaikuta kasvuun olennaisesti
- kerroin `c` jätetään pois
- jäljelle jää `n²`

Siksi Big O on:
`O(n²)`

Parempi sääntö:
> Big O:ssa kiinnostaa nopeimmin kasvava termi, ei pelkästään suurin potenssi kaikissa mahdollisissa tapauksissa.

---

## 9. Staattisesta arraysta poistaminen mistä tahansa kohdasta

### Missä vastaukseni oli puutteellinen
Selitin idean vähän epätarkasti enkä sanonut heti selvästi aikavaativuutta.

### Oikea / täydellinen vastaus
Staattisessa arrayssa poistaminen mistä tahansa kohdasta on materiaalin mukaan:

`O(n)`

Syy:
- arrayn kokoa ei voi muuttaa suoraan
- pitää luoda uusi array
- vanhat alkiot pitää kopioida uuteen arrayhin ilman poistettua alkiota

---

## 10. Kumpi on yleensä nopeampi: staattinen vai dynaaminen array?

### Missä vastaukseni oli puutteellinen
Sanoin osittain oikein, mutta liioittelin vähän staattisen arrayn hitautta.

### Oikea / täydellinen vastaus
Materiaalin mukaan **dynaaminen array on yleensä nopeampi** kuin staattinen array, koska:
- loppuun lisääminen on amortized `O(1)`
- lopusta poistaminen on amortized `O(1)`

Staattisessa arrayssa nämä ovat `O(n)`.

Mutta vastapainona:
- dynaaminen array käyttää enemmän muistia
- koska siihen varataan ylimääräistä kapasiteettia

Tärkeä tarkennus:
- staattinen array ei ole “aina `O(n)`”
- esimerkiksi:
    - luonti voi olla `O(1)`
    - indeksillä luku on `O(1)`

---

## 11. Miksi UTF-8 on hankala arrayn kannalta?

### Missä vastaukseni oli puutteellinen
Sanoin “bittien määrä vaihtelee”, mutta oikeampi yksikkö tässä yhteydessä on tavut.

### Oikea / täydellinen vastaus
UTF-8 on hankala arrayn kannalta, koska merkit voivat olla **eri pituisia tavuina**:
- jotkut 1 tavu
- jotkut 2 tavua
- jotkut 3 tavua
- jotkut 4 tavua

Arrayssa taas elementtien pitäisi olla **saman kokoisia**, jotta indeksistä voidaan laskea muistiosoite suoraan.

Parempi muoto:
> Ongelma on, että UTF-8:ssa merkkien tavumäärä vaihtelee, mutta array toimii parhaiten, kun kaikki elementit ovat saman kokoisia.

---

## 12. Miten Python ratkaisee merkkijonojen tallennuksen?

### Tämä kohta piti osata täydemmin
Python käyttää koko merkkijonolle sen **suurimman tarvittavan merkkikoon mukaista esitystä**.

Eli:
- jos kaikki merkit mahtuvat pieneen esitykseen, käytetään sitä
- jos mukana on isompi merkki, koko merkkijono voi käyttää suurempaa esitystä

Esimerkiksi:
- yksi emoji voi pakottaa myös tavalliset kirjaimet käyttämään 4 tavun kokoa siinä samassa merkkijonossa

---

## 13. Miksi Pythonin ratkaisu voi olla huono muistille?

### Tämä kohta jäi väliin
### Oikea / täydellinen vastaus
Se voi olla huono muistinkäytön kannalta, koska **yksi iso merkki voi pakottaa koko merkkijonon käyttämään suurempaa tallennuskokoa**.

Esim.:
- melkein kaikki merkit voisivat olla 1 tavun kokoisia
- mutta yksi emoji voi nostaa koko merkkijonon 4 tavuun per merkki

---

## 14. Miksi array sopii tilanteisiin, joissa tarvitaan paljon indeksilukuja?

### Missä vastaukseni oli puutteellinen
Painotin muistinkäytön keveyttä, vaikka materiaalin pääpointti oli indeksihakujen nopeus.

### Oikea / täydellinen vastaus
Array sopii hyvin tällaiseen käyttöön, koska:
- indeksillä lukeminen on `O(1)`
- rakenne on yksinkertainen
- se toimii hyvin, kun dataa ei muokata usein

Tärkein pointti ei ole materiaalissa muistikeveys, vaan:
> array on erittäin nopea tunnetulla indeksillä lukemiseen.

---

## 15. Miksi array ei sovi hyvin usein muokattavaan listaan?

### Missä vastaukseni oli puutteellinen
Vastaus oli muuten hyvä, mutta sanoin liian vahvasti, että poisto lopusta on aina halpa dynaamisessa arrayssa.

### Oikea / täydellinen vastaus
Array ei sovi hyvin usein muokattavaan listaan, koska:
- staattisessa arrayssa pitää usein tehdä uusi taulukko ja kopioida sisältö
- dynaamisessa arrayssa keskelle lisääminen ja poistaminen vaativat alkioiden siirtämistä
- kapasiteetin loppuessa tarvitaan uudelleenallokointi ja kopiointi

Lisäksi:
- loppuun lisäys ja lopusta poisto dynaamisessa arrayssa ovat **amortized**, eivät aina varmasti puhdasta `O(1)`

---

## 16. Arrayn tärkeimmät vahvuudet ja heikkoudet

### Missä vastaukseni oli puutteellinen
Sanoin “luonti” vahvuutena, mutta tärkeämpi käytännön vahvuus on nopea indeksihaku.

### Oikea / täydellinen vastaus

### 2 tärkeintä vahvuutta
1. **Indeksillä lukeminen on `O(1)`**
2. Array on **yksinkertainen rakenne**, joka toimii hyvin melko muuttumattomalle datalle

### 2 tärkeintä heikkoutta
1. **Lisääminen ja poistaminen ovat usein kalliita**
2. **Arvon perusteella etsiminen on `O(n)`**

---

# Pikakertaus

## Muista nämä erityisen hyvin
- `O(1)` = kustannus ei kasva syötteen koon mukana
- arrayn indeksihaku = `O(1)`
- arrayn arvopohjainen haku = `O(n)`
- sisäkkäiset silmukat → usein `O(n²)`
- dynaamisen arrayn loppuun lisäys = **amortized `O(1)`**
- keskelle lisääminen/poistaminen arrayssa = usein `O(n)`
- staattinen array = kiinteä koko
- dynaaminen array = logical size + physical size + growth factor
- Pythonin stringeissä yksi “raskas” merkki voi kasvattaa koko merkkijonon muistinkäyttöä