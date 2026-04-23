# Hashing – muistiinpanot omista virheistä

## 1. Hashingin perusidea

### Missä meni pieleen
Vastauksessa painottui se, että sama avain antaa saman hashin, mutta itse hashingin päätarkoitus jäi puuttumaan.

### Oikea ajatus
Hashingin idea on käyttää avainta laskemaan hash-arvo, jonka avulla dataan päästään nopeasti käsiksi ilman lineaarista hakua.

### Lyhyt oikea vastaus
Hashingissa avaimesta lasketaan hash-funktion avulla arvo, jonka perusteella data voidaan hakea nopeasti ilman että koko rakenne täytyy käydä läpi.

---

## 2. Hyvän hash-funktion ominaisuudet

### Missä meni pieleen
Vastauksessa oli mukana kaksi oikeaa ideaa:
- sama avain -> sama tulos
- mahdollisimman paljon erilaisia hasheja

Mutta siitä puuttui vielä muita tärkeitä ominaisuuksia.

### Oikea ajatus
Hyvän hash-funktion pitää:
- olla nopea, mielellään O(1)
- antaa samasta avaimesta aina sama tulos
- tuottaa rajatulta alueelta arvoja
- jakaa tulokset tasaisesti, jotta collisioneja tulee vähän

### Lyhyt oikea vastaus
Hyvä hash-funktio on nopea, deterministinen, tuottaa arvoja rajatulta alueelta ja jakaa tulokset mahdollisimman tasaisesti.

---

## 4. Miksi collisioneja ei voi täysin välttää

### Missä meni pieleen
Vastauksessa ei tullut esiin tärkein syy collisioneille.

### Oikea ajatus
Collisioneja ei voi välttää, koska mahdollisia avaimia on yleensä paljon enemmän kuin hash-funktion mahdollisia tuloksia tai hash-taulun paikkoja.

### Lyhyt oikea vastaus
Collisioneja syntyy väistämättä, koska eri avaimia on enemmän kuin mahdollisia hash-arvoja.

---

## 5. Open addressing

### Missä meni pieleen
Perusidea oli oikein, mutta lopussa tuli virheellinen ajatus siitä, että elementit "pysyvät samassa lokerossa".

### Oikea ajatus
Open addressingissa collision ratkaistaan etsimällä samasta hash-taulusta toinen vapaa paikka probing-menetelmällä.

### Lyhyt oikea vastaus
Open addressing tarkoittaa, että collisionin tapahtuessa avain–arvo-parille etsitään toinen vapaa paikka samasta hash-taulusta.

---

## 7. `_find_key`-metodin tarkoitus

### Missä meni pieleen
Vastaus kuvasi enemmän `put`-metodia kuin `_find_key`-metodia.

### Oikea ajatus
`_find_key` etsii, löytyykö annettu avain hash-taulusta probingin avulla. Se ei lisää eikä päivitä mitään.

### Lyhyt oikea vastaus
`_find_key` etsii avaimen hash-taulusta ja palauttaa sen indeksin tai `None`, jos avainta ei löydy.

---

## 8. `_find_free_slot`-metodin tarkoitus

### Missä meni pieleen
Vastaukseen tuli mukaan `MemoryError`, vaikka se ei kuulu tämän metodin vastuulle.

### Oikea ajatus
`_find_free_slot` etsii annetusta aloituskohdasta seuraavan vapaan slotin probingilla.

### Lyhyt oikea vastaus
`_find_free_slot` palauttaa seuraavan vapaan slotin indeksin tai `None`, jos vapaata paikkaa ei löydy.

---

## 11. Miksi poistaminen on hankalaa open addressingissa

### Missä meni pieleen
Ajatus oli oikeansuuntainen, mutta tärkein syy jäi vähän epätarkaksi.

### Oikea ajatus
Poistaminen on hankalaa, koska jos slotti vain tyhjennetään, probing-ketju voi katketa ja jotkut myöhemmin siirretyt avaimet eivät enää löydy haussa.

### Lyhyt oikea vastaus
Poistaminen on vaikeaa, koska tyhjäksi tehty slotti voi katkaista probing-ketjun ja estää joidenkin avainten löytymisen.

---

## 15. Chainingin etu verrattuna open addressingiin

### Missä meni pieleen
Vastaus oli liian suppea ja painotti vain täyttöastetta.

### Oikea ajatus
Chainingin etuja ovat:
- collisionien käsittely on yksinkertaisempaa
- vapaita slotteja ei tarvitse etsiä
- taulu ei tule täyteen samalla tavalla kuin open addressingissa

### Lyhyt oikea vastaus
Chaining on yksinkertaisempi collisionien käsittelyssä, eikä siinä tarvitse etsiä vapaita slotteja samalla tavalla kuin open addressingissa.

---

## 19. Hash-taulun tavoiteaikavaativuus

### Missä meni pieleen
Vastauksessa sanottiin `O(n)`, vaikka hash-taulun perusidea on nopeampi haku ja lisäys.

### Oikea ajatus
Hash-taulun tavoiteaikavaativuus on yleensä:
- haku: O(1)
- lisäys: O(1)

Mutta käytännössä:
- collisionit voivat hidastaa toimintaa
- uudelleenhashaus suurempaan tauluun on O(n)

### Lyhyt oikea vastaus
Hash-taulun tavoiteaikavaativuus haulle ja lisäykselle on yleensä O(1), vaikka pahimmissa tilanteissa se voi hidastua.

---

# Nopea kertaus

## Muista ainakin nämä
- Hashingin tavoite on nopea avainpohjainen haku.
- Hyvä hash-funktio on nopea, deterministinen ja jakaa arvot tasaisesti.
- Collision syntyy, kun eri avaimet saavat saman hash-arvon.
- Collisioneja ei voi täysin välttää.
- Open addressing etsii uuden paikan samasta taulusta.
- Chaining tallentaa collisionit samaan slottiin listana tai ketjuna.
- `_find_key` etsii avaimen.
- `_find_free_slot` etsii vapaan paikan.
- Poistaminen open addressingissa on hankalaa, koska probing-ketju voi rikkoutua.
- Hash-taulun tavoiteaikavaativuus on yleensä O(1).