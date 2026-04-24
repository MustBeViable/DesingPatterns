# Tietorakenteet ja algoritmit – O-notaatiot

## 1. Tietorakenteet materiaalin järjestyksessä

## Chapter 2 – Arrayt ja Big O

| Tietorakenne / operaatio | Aikavaatimus | Yhden lauseen selitys |
|---|---:|---|
| Staattinen array: luonti | O(1) | Luonti on vakioaikainen, koska taulukolle varataan kiinteä rakenne ja perusarvot. |
| Staattinen array: lisäys loppuun | O(n) | Staattisen arrayn kokoa ei voi kasvattaa suoraan, joten pitää luoda uusi array ja kopioida vanhat arvot. |
| Staattinen array: poisto lopusta | O(n) | Poisto vaatii uuden pienemmän arrayn ja vanhojen arvojen kopioinnin. |
| Staattinen array: lisäys keskelle | O(n) | Uusi array pitää luoda ja elementtejä pitää kopioida tai siirtää. |
| Staattinen array: poisto keskeltä | O(n) | Elementtejä pitää kopioida uuteen arrayhin ilman poistettua arvoa. |
| Staattinen array: indeksillä haku | O(1) | Indeksin perusteella muistipaikka voidaan laskea suoraan. |
| Staattinen array: arvolla haku | O(n) | Pahimmassa tapauksessa koko array käydään läpi. |
| Dynaaminen array: luonti | O(1) | Dynaamisen arrayn perusrakenne luodaan vakioajassa. |
| Dynaaminen array: lisäys loppuun | O(1) amortized | Yleensä lisäys menee suoraan vapaaseen tilaan, mutta joskus array pitää kasvattaa ja kopioida. |
| Dynaaminen array: poisto lopusta | O(1) amortized | Yleensä viimeinen alkio voidaan poistaa suoraan, mutta joskus taulukkoa pienennetään. |
| Dynaaminen array: lisäys keskelle | O(n) | Elementtejä pitää siirtää oikealle, jotta uudelle arvolle saadaan paikka. |
| Dynaaminen array: poisto keskeltä | O(n) | Elementtejä pitää siirtää vasemmalle, jotta tyhjä kohta poistuu. |
| Dynaaminen array: indeksillä haku | O(1) | Indeksi antaa suoran pääsyn muistipaikkaan. |
| Dynaaminen array: arvolla haku | O(n) | Pahimmassa tapauksessa jokainen alkio pitää tarkistaa. |

## Chapter 3 – Linkitetyt listat

| Tietorakenne / operaatio | Aikavaatimus | Yhden lauseen selitys |
|---|---:|---|
| Singly linked list: luonti | O(1) | Luodaan vain head-viite, joten työmäärä ei riipu listan koosta. |
| Singly linked list: lisäys alkuun | O(1) | Uusi node voidaan liittää suoraan headin eteen. |
| Singly linked list: poisto alusta | O(1) | Head voidaan siirtää seuraavaan nodeen ilman listan läpikäyntiä. |
| Singly linked list: lisäys loppuun ilman tailia | O(n) | Viimeinen node pitää etsiä kulkemalla lista läpi. |
| Singly linked list: lisäys loppuun tailin kanssa | O(1) | Tail-viite kertoo suoraan listan viimeisen noden. |
| Singly linked list: poisto lopusta | O(n) | Poistossa pitää löytää myös viimeistä edeltävä node. |
| Singly linked list: haku arvolla | O(n) | Arvoa etsitään node kerrallaan alusta loppuun. |
| Singly linked list: indeksillä haku | O(n) | Indeksiin ei voi hypätä suoraan, vaan lista pitää kulkea alusta asti. |
| Doubly linked list: lisäys alkuun | O(1) | Prev- ja next-viitteet voidaan päivittää suoraan listan alussa. |
| Doubly linked list: poisto alusta | O(1) | Head voidaan siirtää ja uuden headin prev päivittää. |
| Doubly linked list: lisäys loppuun | O(1) | Tail-viite mahdollistaa suoran lisäyksen loppuun. |
| Doubly linked list: poisto lopusta | O(1) | Tailin prev-viite kertoo suoraan uuden viimeisen noden. |
| Doubly linked list: lisäys tai poisto tunnetusta nodesta | O(1) | Kun node tiedetään valmiiksi, viitteet voidaan vaihtaa suoraan. |
| Doubly linked list: haku arvolla | O(n) | Haluttu node pitää yleensä etsiä kulkemalla listaa. |

## Chapter 4 – Stack ja Queue

| Tietorakenne / operaatio | Aikavaatimus | Yhden lauseen selitys |
|---|---:|---|
| Stack: push | O(1) | Uusi alkio lisätään suoraan pinon päälle. |
| Stack: pop | O(1) | Pinon päällimmäinen alkio poistetaan suoraan. |
| Stack: peek | O(1) | Päällimmäinen alkio luetaan ilman poistoa. |
| Queue: enqueue | O(1) | Uusi alkio lisätään jonon loppuun tail-viitteen avulla. |
| Queue: dequeue | O(1) | Ensimmäinen alkio poistetaan head/front-viitteen avulla. |
| Queue: peek/front | O(1) | Jonon ensimmäinen alkio voidaan lukea suoraan. |

## Chapter 5 – Puut ja BST

| Tietorakenne / operaatio | Aikavaatimus | Yhden lauseen selitys |
|---|---:|---|
| Tavallinen puu: solmun lasten läpikäynti | O(k) | Aika riippuu siitä, kuinka monta lasta kyseisellä solmulla on. |
| Binary tree: solmun vasen/oikea lapsi | O(1) | Solmulla on suorat viitteet vasempaan ja oikeaan lapseen. |
| BST: haku tasapainoisessa puussa | O(log n) | Jokaisella askeleella voidaan sulkea pois noin puolet jäljellä olevista arvoista. |
| BST: lisäys tasapainoisessa puussa | O(log n) | Uuden noden paikka löytyy kulkemalla puun korkeuden verran. |
| BST: poisto tasapainoisessa puussa | O(log n) | Poisto vaatii ensin noden etsimisen ja sen jälkeen viitteiden korjauksen. |
| BST: haku/lisäys/poisto huonosti tasapainotetussa puussa | O(n) | Jos puu muistuttaa linkitettyä listaa, joudutaan kulkemaan pahimmillaan kaikki nodet. |
| BST: inorder-läpikäynti | O(n) | Jokainen node käydään läpi kerran järjestyksessä. |
| BST: preorder-läpikäynti | O(n) | Jokainen node käsitellään kerran ennen sen lapsia. |
| BST: postorder-läpikäynti | O(n) | Jokainen node käsitellään kerran sen lasten jälkeen. |

## Chapter 6 – Hashing ja hash table

| Tietorakenne / operaatio | Aikavaatimus | Yhden lauseen selitys |
|---|---:|---|
| Hash-funktio | O(1) | Hyvän hash-funktion oletetaan tuottavan hajautusarvon vakioajassa. |
| Hash table: lisäys keskimäärin | O(1) | Avain hashataan suoraan taulukon paikkaan ja lisätään ilman pitkää hakua. |
| Hash table: haku keskimäärin | O(1) | Avaimen hash kertoo suoraan, mistä arvoa kannattaa etsiä. |
| Hash table: poisto keskimäärin | O(1) | Poistettava avain löytyy yleensä suoraan hashin avulla. |
| Hash table: lisäys/haku/poisto pahimmillaan | O(n) | Pahimmassa tapauksessa collisionit pakottavat käymään läpi monta tai kaikki alkiot. |
| Open addressing / linear probing | O(1) keskimäärin, O(n) pahimmillaan | Vapaita paikkoja etsitään taulukosta eteenpäin, mikä voi ruuhkautua suurella load factorilla. |
| Chaining | O(1) keskimäärin, O(n) pahimmillaan | Collisionit tallennetaan ketjuun/listaan, jonka pituus ratkaisee pahimman tapauksen. |
| Rehashing | O(n) | Taulukon kasvatus vaatii kaikkien vanhojen avainten sijoittamisen uudelleen. |

## Chapter 7 – Graafit

| Tietorakenne / operaatio | Aikavaatimus | Yhden lauseen selitys |
|---|---:|---|
| Edge list: kaikki vertexin edget | O(n) | Kaikki edget pitää käydä läpi, jotta löydetään tiettyyn vertexiin liittyvät yhteydet. |
| Adjacency list: vertexin naapurit | O(deg(v)) | Naapurit löytyvät vertexin omasta listasta, jonka pituus on vertexin aste. |
| Adjacency list: onko edge u-v olemassa | O(deg(u)) | Vertexin u naapurilista pitää käydä läpi, jotta nähdään löytyykö v. |
| Adjacency map: onko edge u-v olemassa | O(1) expected | Sisempi dictionary/hash map mahdollistaa odotusarvoisesti vakioaikaisen haun. |
| Adjacency matrix: onko edge u-v olemassa | O(1) | Matriisista voidaan tarkistaa suoraan solun [u][v] arvo. |
| Adjacency matrix: muistin käyttö | O(V²) | Jokaiselle vertex-parille varataan paikka, vaikka edgeä ei olisi. |
| Adjacency list/map: muistin käyttö | O(V + E) | Tilaa kuluu vertexeihin ja olemassa oleviin edgeihin. |

## Chapter 8 – Priority queue ja heap

| Tietorakenne / operaatio | Aikavaatimus | Yhden lauseen selitys |
|---|---:|---|
| Priority queue: insert heapillä | O(log n) | Alkio lisätään loppuun ja nostetaan heapissä ylöspäin tarvittaessa. |
| Priority queue: pop heapillä | O(log n) | Root poistetaan ja uusi root upotetaan oikeaan paikkaan. |
| Heap: rootin lukeminen | O(1) | Min-heapissä pienin arvo on aina rootissa. |
| Heap: parent/child-indeksien laskeminen arrayssä | O(1) | Parent ja child -paikat voidaan laskea suoraan indeksikaavoilla. |
| Heap: float/sift-up | O(log n) | Alkio voi liikkua enintään puun korkeuden verran ylöspäin. |
| Heap: sink/sift-down | O(log n) | Alkio voi liikkua enintään puun korkeuden verran alaspäin. |

---

# 2. Algoritmit materiaalin järjestyksessä

## Chapter 8 – Searching

| Algoritmi | Aikavaatimus | Yhden lauseen selitys |
|---|---:|---|
| Linear search, järjestämätön lista | O(n) | Pahimmassa tapauksessa koko lista pitää käydä läpi. |
| Linear search, järjestetty lista | O(n) pahin, O(1) paras | Haku voidaan lopettaa ajoissa, jos nykyinen arvo on jo haettavaa suurempi. |
| Binary search | O(log n) | Järjestetty hakuväli puolitetaan jokaisella askeleella. |
| Interpolation search | O(log log n) keskimäärin, O(n) pahimmillaan | Tasaisesti jakautuneessa datassa arvaus osuu lähelle oikeaa kohtaa, mutta epätasaisessa datassa se voi mennä huonosti. |

## Chapter 9 – Sorting

| Algoritmi | Aikavaatimus | Yhden lauseen selitys |
|---|---:|---|
| Bubble sort | O(n²) keskimäärin/pahin, O(n) paras | Vierekkäisiä arvoja vaihdetaan toistuvasti, kunnes suurimmat kuplivat loppuun. |
| Insertion sort | O(n²) keskimäärin/pahin, O(n) paras | Jokainen uusi key sijoitetaan oikeaan kohtaan jo järjestetyssä listan osassa. |
| Selection sort | O(n²) | Jokaisella kierroksella etsitään jäljellä olevista pienin tai suurin ja asetetaan paikalleen. |
| Quicksort | O(n log n) keskimäärin, O(n²) pahimmillaan | Lista jaetaan pivotin ympärille pienempiin ja suurempiin osiin ja osat lajitellaan rekursiivisesti. |
| Heapsort | O(n log n) | Arvot lisätään heap-rakenteeseen ja poistetaan järjestyksessä heapin pop-operaatioilla. |
| Naive heapsort: lisämuisti | O(n) | Erillinen heap-rakenne vie suunnilleen saman verran lisätilaa kuin alkuperäinen lista. |

## Chapter 10 – Algorithm design techniques

| Tekniikka / algoritmi | Aikavaatimus | Yhden lauseen selitys |
|---|---:|---|
| Rekursio | Riippuu ongelmasta | Rekursio ei itsessään määrää O-notaatiota, vaan aika riippuu kutsujen määrästä ja työn määrästä per kutsu. |
| Factorial rekursiivisesti | O(n) | Funktio kutsuu itseään kerran jokaiselle pienemmälle arvolle, kunnes base case saavutetaan. |
| Backtracking | Usein eksponentiaalinen | Eri ratkaisupolkuja kokeillaan ja perutaan, joten vaihtoehtojen määrä voi kasvaa nopeasti. |
| Divide and conquer | Usein O(n log n) | Ongelma jaetaan pienempiin osiin, ratkaistaan osat ja yhdistetään tulokset. |
| Merge sort | O(n log n) paras/keskimäärin/pahin | Lista jaetaan puoliksi log n tasoa ja jokaisella tasolla yhdistäminen käsittelee yhteensä n alkiota. |
| Merge sort: lisämuisti | O(n) | Array-versio tarvitsee väliaikaisia listoja yhdistämistä varten. |
| Fibonacci ilman muistamista | O(2ⁿ) | Samoja Fibonacci-arvoja lasketaan uudelleen monessa rekursiohaarassa. |
| Fibonacci memoizationilla | O(n) | Jokainen Fibonacci-arvo lasketaan kerran ja haetaan myöhemmin cache-rakenteesta. |
| Fibonacci tabulationilla | O(n) | Arvot lasketaan alhaalta ylöspäin silmukassa käyttäen aiempia tuloksia. |
| Fibonacci tabulationin lisämuisti optimoituna | O(1) | Tarvitaan vain kaksi edellistä arvoa seuraavan laskemiseen. |
| Greedy-algoritmi | Riippuu ongelmasta | Jokaisessa vaiheessa valitaan paikallisesti paras vaihtoehto, mutta se ei aina takaa globaalia optimia. |
| Greedy coin change esimerkkitoteutuksella | O(n log n) tai O(n) | Jos kolikot lajitellaan ensin, lajittelu maksaa O(n log n), mutta valmiiksi lajiteltuna läpikäynti on O(n). |
| Dijkstra priority heapillä | O((V + E) log V) | Priority queue nopeuttaa seuraavan lyhimmän tunnetun etäisyyden valintaa. |
| Dijkstra yksinkertaisella listalla | O(V²) | Seuraava käsiteltävä vertex etsitään listasta lineaarisesti jokaisella kierroksella. |

---

# 3. Nopea muistilista

| O-notaatio | Merkitys |
|---|---|
| O(1) | Vakioaika: koko ei juuri vaikuta suoritusaikaan. |
| O(log n) | Logaritminen: ongelma pienenee yleensä puoleen joka askeleella. |
| O(n) | Lineaarinen: jokainen alkio käsitellään kerran. |
| O(n log n) | Tehokas lajittelu-/jakoalgoritmien luokka. |
| O(n²) | Kaksi sisäkkäistä läpikäyntiä tai paljon vertailuja kaikkien parien välillä. |
| O(2ⁿ) | Eksponentiaalinen: vaihtoehtojen määrä kaksinkertaistuu usein jokaisella tasolla. |
| O(n!) | Faktoriaalinen: kaikki permutaatiot tai järjestykset kokeillaan. |