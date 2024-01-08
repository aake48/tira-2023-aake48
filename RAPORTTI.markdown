# Raportit tehtävistä

Kirjaa tähän tiedostoon **jokaiseen** tehtävään liittyvät omat raporttisi ja analyysisi. Muista että raportti on myös kurssilla **arvosteltava tehtävä**.

Voit sisällyttää raporttiin tekstimuotoisia taulukoita (tasaukset välilyönnein):

```
n     Fill     Search   Total
500   7        700      707
1000  9        288      297
```

Ja näihin liittyviä kuvatiedostoja:

![Esimerkkikuva](report-sample-image.png)

Nämä näkyvät sitten VS Coden Preview -näkymässä (tai oman repositorysi webbisivulla) oikein muotoiltuna. Käytä tässä dokumentissa olevia muotoiluja esimerkkinä kun kirjoitat raporttiasi. 

Huomaa että jos laitat kuvatiedostot vaikka omaan alihakemistoonsa, Markdown -muotoilussa on oltava suhteellinen polku tiedostoon, esimerkiksi `images/report-sample-image.png`. **Älä** käytä absoluuttisia polkuja `C:\Users\tippaleipa\kurssit\TIRA\kuva.png`, koska nämä eivät tietenkään toimi opettajan koneella. Ei kannata laittaa linkkiä etärepoosikaan, vaan nimenomaan paikalliseen tiedostoon.

Voit myös sisällyttää *lyhyitä* koodinpätkiä vaikkapa Java -formaatilla:

```Java
	@Override
	public int hashCode() {
		// Oma nerokas hajautufunktioni!
	}
```
Tarvittaessa käytä myös paremmin muotoiltuja taulukoita:

| n	| Fill	| Search	| Total |
|-----|--------|--------|-------|
| 500	 | 7	| 700	| 707 |
| 1000 |	9	| 288	| 297 | 

Alaluvut jokaisen tehtävän raportille löydät alta.


## 01-TASK


* Mitä opin, mikä oli vaikeaa, mikä helppoa jne.

Tehtävässä opin muodostamaan yksinkertaisen lajittelualgoritmin. Helppoa tehtävässä oli perusasiat, eli toistorakenteiden käyttö jne. Mielestäni vaikeinta oli hahmottaa miten algoritmi tarkalleen ottaen toimii, ja sen takia minulla piti monta kertaa hahmotella paperille, mitä taulukossa tapahtuu lajittelun aikana. Vaikka kyseinen algoritmi on toteutettu aikaisemmalla kurssilla, niin kesän aikana koodaus on jäänyt vähemmälle, ja tämän takia piti tehdä suhteellisen paljon mieleen palauttelua että pääsin asiasta jyvälle ja sisäistin sen. Tehtävässä korostui myös hyvin koodin uudelleenkäytettävyys, esimerkiksi swap algoritmin käyttäminen muissa algoritmeissa sekä ensin tekemällä insertionSort(T[] array, int fromIndex, int toIndex) algoritmi, jonka jälkeen sitä pystyi hyödyntämään insertionSort(T[] array) algoritmissa. Reverse algoritmin pystyi myös toteuttamaan samalla tavalla.

* Mikä on toteuttamasi lajittelualgortmin aikakompleksisuusluokka?

Lajittelualgoritmin aikakompleksisuusluokka on neliöllinen eli O(n^2). Eli tietomäärän kasvaessa tarpeeksi, kasvaa algoritmin suoritusaika neliöllisesti. Algoritmi toimii sujuvasti pienien tietomäärien kanssa ja tällöin suoritusaika on lineaarinen, eikä se vaadi lisämuistia tehden siitä hyvän vaihtoehdon jos tietomäärät ovat pieniä. Jos tietomäärät ovat suuria, menee algoritmilla paljon aikaa lajitteluun eikä tämän takia välttämättä sovellu hyvin käyttöön niiden kanssa.
```
      public static <T extends Comparable<T>> void insertionSort(T[] array, int fromIndex, int toIndex) {
         if (array != null && fromIndex >= 0 && toIndex <= array.length){
         for (int currentIndex = fromIndex; currentIndex < toIndex; currentIndex++) {
            T currentElement = array[currentIndex];
            int previousIndex = currentIndex - 1;

            while (previousIndex >= fromIndex && array[previousIndex].compareTo(currentElement) > 0) {
               swap(array, previousIndex, previousIndex + 1);
               previousIndex--;
            }
         }
      }
}
```

Neliöllisyys näkyy koodissa kahtena toistorakenteena, joista toinen on ensimmäisen toistorakenteen sisällä.

* Mikä on toteuttamasi reverse -algoritmin aikakompleksisuusluokka?

Reverse -algoritmin aikakompleksisuusluokka on lineaarinen O(n) eli tietomäärän kasvaessa, algoritmin suoritusaika kasvaa lineaarisesti suhteessa tietomäärään

* Jos taulukko on jo valmiiksi järjestyksessä nousevaan järjestykseen, ja se aiotaan lajitella laskevaan järjestykseen, kannattaako taulukko lajitella vai kääntää sen järjestys? Miksi, perustele?

Koska taulukko on jo valmiiksi järjestyksessä nousevaan järjestykseen, niin ei ole tarvetta tehdä taulukon alkioiden vertailua. Tämän takia taulukko kannattaa kääntää lajittelun sijasta, koska se on aikatehokkaampaa, koska reverse algoritmin aikakompleksisuus on pienempi kuin lajittelualgoritmin.

## 02-TASK

Tässä tehtävässä opin lisää lajittelusta, Comparator rajapinnasta sekä Predicate rajapinnasta. Pystyin hyödyntämään opittua TIRA Codersin koodareiden lajittelussa. Opin myös tekemään lineaarisen hakualgoritmin, sekä elementtien etsimiseen tarkoitettuja algoritmeja.

TIRA Coders -sovelluksen lajittelutapojen testaaminen isoilla tiedostoilla, sekä lajittelutapojen analysointi.

Pätkä testailun tuloksista:

     PhoneBookArray: Sorting took 619 ms
     PhoneBookArray: Sorting took 2559 ms
     PhoneBookArray: Sorting took 620 ms
     PhoneBookArray: Sorting took 2625 ms

Kun aikaa menee ~600 ms on vaihto tehty Full name -> Coder name
Kun aikaa menee ~2500ms, niin vaihto on tehty Coder name -> Full name

Syy on siinä, että monella koodarilla saattaa olla sama Coder name, jolloin osa tiedoista on jo oikeassa paikassa, jolloin lajittelussa menee vähemmän aikaa ja päinvastoin koska koodareiden koko nimet eroavat paljon, joutuu lajitteluun käyttämään myös enemmän aikaa, kun pienempi osa tiedoista on oikealla kohdalla.

Aikatehokkuus testien tulokset lineaarisessa haku algoritmissä sekä add metodissa:
x-akselilla on tietomäärä, y-akselilla aika.

![Hakuaika](TIRA_TASK02_Hakuaika.png)
![Tayttoaika](TIRA_TASK02_Tayttoaika.png)

Käyristä voi nähdä, että ne ovat lineaarisesti kasvavia, eli tietomäärän kasvaessa, kasvaa myös suoritusaika lineaarisesti

* Miksi toteutettuja hakualgoritmeja kutsutaan lineaarisiksi?
	Hakualgoritmeja kutsutaan lineaarisiksi, koska niiden suoritusaika kasvaa lineaarisesti suhteessa tietomäärään jota käsitellään. Ns. "optimiin" lineaariseen käyrään ei päästä, johtuen siitä ettei prosessori käytä kaikkea tehoansa prosessin suorittamiseen, toisaalta myös käyttöjärjestelmä voi keskeyttää säikeen (thread) suoritusvuoron antaakseen sen jollekkin toiselle säikeelle. Myös tietokoneen muistilla voi olla vaikutusta asiaan. 

* Mikä niiden aikakompleksisuusluokka on big-O -notaatiolla esiteltynä?
	Lineaarisilla algoritmeilla aikakompleksisuus luokka big-O notaatiolla esiteltynä on O(N)

## 03-TASK

Tässä tehtävässä opin tekemään puolitushakualgoritmin. Koin että algoritmin toiminta oli helppo ymmärtää luentovideoiden ja cs.usfca.edu sivun animaation myötä.

Testien tuloksien muuttaminen käyriksi:

![Hakuaika](TIRA_TASK02_Hakuaika.png)
Ylhäällä oleva käyrä on TASK02 tehty käyrä, jossa näkyy lineaarisen haun hakuaika
![Hakuaika](TIRA_TASK03_Hakuaika.png)
Tässä taas on puolitushaun hakuaika. Kuvista voidaan nähdä että puolitushaku toimii paljon nopeammin myös isommilla tietomäärillä.
![Lajitteluaika](TIRA_TASK03_Lajitteluaika.png)
![Tayttoaika](TIRA_TASK03_Tayttoaika.png)



TIRA Codersissa tehdyt havainnot:

Log viewin tulokset:
```
      Översti Aiden-Jack Arnab

      Search took 75ms
      Fast search took 0 ms

      Källi Agnetha Bailie

      Search took 23ms
      Fast search took 0ms

      Aalliniemi Muhammed Tayyib

      Search took 0 ms
      Fast search took 0 ms
```
* Mikä on tässä nopeassa haussa keskimäärin suoritusaika suhteessa ensimmäiseen hakuun?
	1. Haussa 75ms
	2. Haussa (nopeammassa) 0ms
	
	Koska toisessa haussa ei saada aikaa mikrosekunteina, voidaan todeta että puolitushaku on ainakin 75 kertaa nopeampi kuin lineaarinen haku.

* Kokeile hakea molemmilla tavoilla koodareita myös listan alusta. Mitä huomaat?
* Miksi jompi kumpi haku on nopeampi, ja onko sillä väliä haetaanko aineiston alusta vai lopusta? Pohdi ja perustele.

Ensimmäinen haku on tehty listan lopusta, toinen haku keskikohdasta ja viimeinen listan alusta, tiedostona on käytetty 50000 koodaria sisältävää listaa. Voidaan huomata, että kun haetaan koodaria lineaarisesti, niin aika joka menee hakemiseen on suurempi listan loppupäässä verrattuna alkupäähän. Tämä johtuu siitä että haku tehdään lineaarisesti, eli käydään alkiot läpi yksi kerrallaan, jolloin listan alussa olevat koodarit löytyvät nopeammin kuin listan loppussa olevat koodarit (tässä tapauksessa aineisto on lajiteltu jonka takia näin käy). Toisaalta taas kun tehdään puolitushaku (binary search), on kaikissa "Fast search" 0 ms. Puolitushaku toimii suurilla tietomäärillä paljon nopeammin kun jokaista yksittäistä alkiota ei käydä läpi, vaan jokaisella haku kerralla hakualue puolitetaan.

Pienemmillä tietomäärillä hakuajat eivät eroa paljoa, jolloin ei periaatteessa ole väliä kumpaa hakualgoritmia käyttää. Toisaalta pitää ottaa huomioon, että puolitushaun toimiminen vaatii sen, että lista on järjestelty, kun taas lineaarinen haku toimii millä tahansa järjestyksellä, mutta tietomäärän kasvaessa sen suoritusaika kasvaa myös. Eli periaatteessa jos tietomäärä on suuri ja se on lajiteltu, on silloin aikatehokkaampaa käyttää puolitushakua.




Lineaarisen haun aikakompleksisuusluokka on big-O notaatiolla O(n), jossa n = tiedon määrä.
Puolitushaun aikakompleksisuusluokka on big-O notaatiolla O(log n) jossa n = tiedon määrä.



## 04-TASK

* Mitä opin tehtävän tekemisessä
Opin muodostamaan pinotietorakenteen ja hyödyntämään sitä rakenteellisen tekstin oikeellisuuden tarkistuksessa. Vaikeaa mielestäni oli merkkijonon tarkistuksen logiikan luominen sekä aluksi StackImplementation luokan luominen, mutta materiaaleja sekä demoa kertaamalla ymmärsin lopuksi asian.

* Toteutuksen aikakompleksisuusvaatiumukset
Toteutukseni vastaa alussa esiteltyjä aikakompleksisuusvaatimuksia, koska en käytä toistorakenteita missään metodissa, jossa aikakompleksisuusluokka on O(1) (poikkeuksena push(), jossa reallokoidessa on pakko käyttää)

* Lainausmerkit väärin, onko algoritmi oikeellinen?
Tällä hetkellä algoritmi ei toimi oikeellisesti lainausmerkkien kanssa, koska algoritmi "olettaa" että lainausmerkkejä on aina parillinen määrä jonka takia siinä ei ole minkäänlaista tarkistusta tai virheenkäsittelyä.
Tapauksessa jossa lainausmerkkejä on liikaa esim. pelkästään 1 lainausmerkki tiedoston alussa, ja toista merkkiä ei ollenkaan, ei tiedostosta huomioida yhtäkään merkkiä ensimmäisen lainausmerkin jälkeen koska algoritmi odottaa toista lainausmerkkiä. Algoritmiin pitäisi siis luoda virheenkäsittely ja tarkistukset tällaista tilannetta varten.
## 05-TASK

* Mitä opin tehtävän tekemisessä
Tehtävässä opin tekemään jono tietorakenteen, jonka sisäisenä tietorakenteena toimii taulukko. Opin myös teoriassa miten linkitetty lista toteutus toimii, vaikken sitä tässä tehtävässä toteuttanut. Koin jono tietorakenteen perusidean helpoksi ymmärtää, kun sitä mallasi paperilla, mutta tietorakenteen toteuttaminen koodiin oli kuitenkin hieman vaikeaa.

* Missä asioissa linkitetty lista on parempi kuin taulukkopohjainen toteutus, muistin käytön (muistikompleksisuus) ja aikatehokkuuden (aikakompleksisuus) suhteen? Ja missä asioissa taas taulukkopohjainen toteutus on parempi?

Linkitettyä listaa ei tarvitse reallokoida, koska tässä toteutuksessa ei ole taulukkoa joka täyttyisi. Aina kun listaan lisätään uusi elementti, luodaan vain uusi node ja linkitetään se. Tällöin aikakompleksisuus on O(1).
Taulukon täytyttyä, pitää taulukkoa reallokoida, jolloin toteutuksen aikakompleksisuus nousee O(1) -> O(n).

Kun taulukosta haetaan tiettyä elementtiä indeksillä, on aikakompleksisuus O(1), kun taas linkitetyssä listassa pitää listaa käydä silmukalla läpi, jolloin aikakompleksisuus on O(n). Taulukossa elementit ovat yhtäjaksoisella muistialueella RAM-muistissa jolloin taulukkoa on nopea käsitellä, kun taas linkitetyssä listassa tilanne on päinvastainen: elementit ovat hajallaan RAM-muistissa. Nykyaikaiset prosessit ja muistiarkkitehtuurit suosii taulukoiden käyttöä, koska esim. lukeminen taulukosta on paljon nopeampaa kuin linkitetystä listasta
## 06-TASK

* Mitä opin tehtävän tekemisessä
Opin muodostamaan kaksi erilaista nopeaa lajittelualgoritmia, quicksortin (Hoaren partitiointi algoritmilla) ja heapsortin. Mielestäni quicksort oli helpompi tehdä, kun taas heapsort oli yksinkertainen paperilla, mutta koodin muodostamisessa ilmeni hieman vaikeuksia. 

![Hidas_lajittelu](task06_insertionsort_lajitteluaika.png)![Insertionsort2](task06_insertionsort_lajittelu_per_elementti.png)

Insertionsortilla tehtyjen testien tulokset. Algoritmi on todella hidas, ja 100 000 elementin kokoisen aineiston lajitteluun meni melkein 800 sekuntia

![Quicksort](task06_quickSort_lajitteluaika.png)![Quicksort2](task06_quicksort_lajittelu_per_elementti.png)

Quicksort on näistä algoritmeista nopein, ja 2 000 000 elementin kokoisen aineiston lajitteluun meni vain hieman reilu 20 000 millisekuntia eli vähän yli 20 sekuntia 

![Heapsort](task06_heapSort_lajitteluaika.png)![Heapsort2](task06_heapsort_lajittelu_per_elementti.png)

Heapsortissa 2 000 000 elementin kokoisen aineiston lajitteluun meni hieman yli 40 000 millisekuntia eli hieman yli 40 sekuntia eli heapsort on tällä aineistolla hitaampi kuin quicksort.


![Alt text](quicksort_heapsort_insertionsort.png)


Taulukosta voidaan nähdä, että quicksortilla ja heapsortilla 1000 elementin aineistolla on isompi suoritusaika per elementti (0,23 ja 0,27) kuin 5000 elementin aineistolla (0,007 ja 0,009). Voidaan siis todeta että nämä lajittelualgoritmit toimivat paremmin hieman isommilla aineistoilla kuin todella pienillä.

Voidaan huomata että tällä aineistolla ja näillä testeillä heapsort on hitaampi kuin quicksort, johtuen esim. siitä että heapsortilla keon rakentaminen ja uudelleen järjestely vie aikaa, kun taas quicksortissa lajittelu tapahtuu jakamalla joka on nopeampaa. Pahimmassa tapauksessa quicksortin aikakompleksisuus on Big-O notaatiolla O(n^2) kun taas heapsortilla se on O(n log n). Pahin tapaus tapahtuu quicksortilla silloin, kun pivottina toimii taulukon pienin tai suurin arvo, ja tämä arvo on oikealla paikallaan eli taulukon alussa tai lopussa. Ongelmaa pystyy kuitenkin "väistämään" suhteellisen hyvin ottamalla esimerkiksi taulukon alusta, keskeltä ja lopusta arvot, vertaamalla näitä keskenään ottamalla mediaani, jota käytetään sitten pivottina. Heapsortin hyvänä puolena taas on se, että pahimman tapauksen aikakompleksisuus on sama kuin quicksortin paras eli O(n log n), eli jos lajittelua tehdään usein ja siihen tarvitaan vakautta, kannattaa sillon valita heapsort.

Vaikka insertionsort toimii huonosti isoilla aineistoilla, se on hyvä valinta jos aineisto on pieni ja suurimmaksi osiksi valmiiksi lajiteltu. Heapsort ja quicksort käyttävät myös enemmän tietokoneen resursseja verrattuna insertionsortiin.

## 07-TASK

* Mitä opin, mikä oli vaikeaa jne.
Tässä tehtävässä opin miten tietorakenne nimeltä binäärinen hakupuu toimii, ja miten semmoinen voidaan toteuttaa koodissa. Koin että aikaisempiin tehtäviin verrattuna, alkoi tehtävä olla jo melko monimutkainen, ja erinäisiä vaikeuksia ilmenikin kun tein omaa toteutustani. 

Tein suurimman osan metodeista iteratiivisesti hyödyntäen aikaisemmin tehtyä pinotietorakennetta, mutta toArray metodin tein rekursiivisesti. Käytin suurimassa osassa metodeista pinotietorakennetta (ja iteratiivista toteutusta), koska koin että se on mielekkäämpi toteuttaa kuin rekursiivinen toteutus.
Binäärisen hakupuun algoritmien aikakompleksisuudet ovat seuraavat:
n = aineiston koko (puun korkeus)

add(K key, V value) = O(n)

V get(K key) = O(n)

V find(Predicate<V> searcher) = O(n)

int size() = O(1)

int capacity() = O(1)

clear() = O(1)

Pair<K, V>[] toArray() = O(n), rekursiivinen toteutus, navigointi puun solmujen läpi

int indexOf(K itemkey) = O(n), joudutaan käyttämään silmukkaa

Pair<K,V> getIndex(int index) = O(n), joudutaan käyttämään silmukkaa

int findIndex(Predicate <V> searcher) = O(n), joudutaan käyttämään silmukkaa

Algoritmit ovat oikeellisia, koska esim. kun navigoidaan puun solmujen läpi, ja oikea tieto löytyy, niin se palautetaan. Jos oikeaa tietoa ei löydy niin palautetaan null, eli algoritmit eivät jää solmuihin "jumiin" tai ikuiseen silmukkaan. 

* Testeistä tulleet tulokset
![Alt text](BST_MITTAUKSET.png)
![Alt text](SIMPLECONTAINER_MITTAUKSET.png)
En ajanut BST:n testejä kokonaan loppuun enkä simplecontainerin 1m ja 2m aineiston testejä, koska pelkästään BST:n mittauksissa meni miljoonan kokoisella aineistolla +4 tuntia.

Puun korkeudet eri kokoisilla aineistoilla:
N = 100, Max depth = 13
N = 1000, Max depth = 22
N = 5000, Max depth = 29
N = 10 000, Max depth = 30
N = 50 000, Max depth = 40
N = 100 000, Max depth = 38
N = 1 000 000, Max depth = 51

* TIRA Codersin testaaminen BST:llä

![Alt text](TIRA_CODERS_BST.png)
![Alt text](TIRA_CODERS_BST2.png)
Ainoa operaatio missä kesti yli 200 ms, oli kun koodareita lajitteli koodari nimen mukaan. Tämä johtuu siitä että on paljon koodareita joilla on sama koodari nimi, ja tässä toteutuksessa jos koodari nimi on sama, niin se laitetaan vasemmanpuoliseksi lapsisolmuksi. Tämän takia puusta muodostuu käytännössä linkitetty lista, jolloin se ei ole tasapainossa ja tämä johtaa lajitteluajan pitenemiseen. Puusta muodostuu siis epämuodostunut (degenerate). Viive voi vaikuttaa käyttäjäkokemukseen negatiivisesti, käyttäjä saattaa ajatella, ettei ohjelma toimi oikein tmv. koska viive on yli 200 ms.

![Alt text](BST_SC_ADDTIME_COMPARISON.png)
Binääriseen hakupuuhun lisääminen on nopeampaa kuin taulukkopohjaiseen simplecontaineriin. Tämä johtuu muun muassa siitä, että taulukossa tilan loppuessa, sitä pitää reallokoida, eli kopioidaan vanhat tiedot uuteen isompaan taulukkoon jolloin aikakompleksisuus on O(n). Binäärisessa hakupuussa ei puuta tarvitse reallokoida, koska ainoa mikä estää puuhun lisäämisen on koneen muistin loppuminen.

![Alt text](BST_SC_GETINDEX_TIME_COMPARISON.png)


Käyristä voidaan nähdä, että indeksillä hakeminen on simplecontainerin taulukkopohjaisessa toteutuksessa nopeampaa kuin binäärisessä hakupuussa. Syynä on se, että taulukosta voidaan hakea suoraan indeksillä, kun taas BST pitää käydä solmuja läpi esimerkiksi in order järjestyksessä, kuten omassa toteutuksessani on tehty. Tämä in order läpi käynti on paljon hitaampaa, varsinkin jos puun korkeus on suuri.

## 08-TASK
* Mitä opin, mikä oli vaikeaa jne.

Opin mikä on hajautustaulu tietorakenne, miten ja mihin sitä voidaan käyttää, sekä miten semmoinen toteutetaan koodissa. Osassa metodeiden toteutuksia oli aluksi hieman vaikeuksia, mutta demoja sekä luentovideoita katsomalla ne selkenivät. 


* Mittausten tulokset ja vertailu BST:n välillä

Vertaa hajautustaulun aikatehokkuutta BST:n aikatehokkuuteen:

missä BST on nopeampi kuin hajautustaulu, ja päinvastoin? Miksi?
onko toinen tietorakenne nopeampi pienemmillä aineistoilla ja hitaampi suuremmilla kuin toinen; kumpi? Milloin ja miksi?

BST nopea toteutus
![Alt text](BST_MITTAUKSET.png)
Simplecontainer hidas taulukkototeutus
![Alt text](SIMPLECONTAINER_MITTAUKSET.png)
Hajautustaulu nopea toteutus
![HAJAUTUSTAULU_MITTAUKSET](HAJAUTUSTAULU_MITTAUKSET.png)
Hajautustaulu hidas taulukkototeutus
![SIMPLECONTAINER_MITTAUKSET](SIMPLECONTAINER_MITTAUKSET2.png)

BST:n nopeampi toteutus on hitaampi kuin hajautustaulun nopea totetutus, kun katsotaan aikaa joka menee elementin lisäämiseen. 1 000 000 kokoisella aineistolla add time on 4572, kun taas hajautustaululla se on 3119ms. Tämä johtuu siitä, että BST:n korkeuden kasvaessa menee lisäämiseenkin enemmän aikaa, koska lisättäessä joudutaan käymään solmuja läpi. Hajautustaulussa taas lasketaan elementille tiiviste, jonka perusteella se lisätään taulukkoon, joka on O(1) operaatio, olettaen että ei tule paljoa törmäyksiä. Hajautustaulu on myös nopeampi kun haetaan jotain elementtiä, esim. BST:llä 1 000 000 kokoisella aineistolla meni haussa 3374ms ja hajautustaululla 1560ms. Tämä aiheutuu samasta syystä kuin aikaisemmin mainittu: BST:ssä joudutaan käymään solmuja läpi, kun taas hajautustaulussa lasketaan tiiviste, jonka perusteella elementti löydetään.

BST:n ja hajautustaulun välillä on myös ero kun puhutaan elementtien järjestyksestä. BST:ssä elementit ovat järjestyksessä, kun taas hajautustaulussa ei, jolloin BST:n aikakompleksisuus lajittelun suhteen on parempi kuin hajautustaulun (BST 42ms vs HT 30289ms).

Pienillä aineistoilla ainoa merkittävä ero BST:n ja hajautustaulun välillä on lajittelussa, ja se johtuu kuten aikaisemmin mainittu, hajautustaulun lajittelemattomuudesta, kun taas BST on lajiteltu.
![HAJAUTUSTAULU_HAKUAIKA](HAJAUTUSTAULU_HAKUAIKA.png)
![SIMPLECONTAINER_HAKUAIKA](SIMPLECONTAINER_HAKUAIKA.png)



Kun vertaa taulukkopohjaista toteutusta ja hajautustaulua, voidaan huomata että taulukkopohjaisella toteutuksella haku kestää kauemmin (miljoonan kokoisella aineistolla jopa 18ms/item), koska aikakompleksisuus on O(n) kun joudutaan käymään taulukkoa läpi. Hajautustaululla taas aikakompleksisuus on O(1) kun voidaan suoraan hajautusavaimella hakea elementti, eikä tarvitse tehdä läpikäyntiä.

BST:n hidas taulukkototeutus on nopeampi kuin BST:n nopea toteutus indeksillä haettaessa, koska taulukkopohjaisessatoteutuksessa taulukon elementtiin pääsee suoraan käsiksi indeksillä, kun taas nopeassa BST:ssä pitää käydä solmuja läpi.



![Alt text](hashingApp_tulokset.png)

UUID Hash työkalulla tehdyt mittaukset erilaisilla

![Alt text](coder_hashCode.png)

Hashcode metodin lopputulos johon päädyin mittausten jälkeen.
## 09-TASK

* Mitä opin, mikä oli vaikeaa jne.

Tässä tehtävässä opin miten verkko tietorakenne muodostetaan, miten sitä hyödynnetään ja millaisia algoritmeja on olemassa verkon käsittelyyn. Koin että verkko kokonaisuutena oli hieman vaikea ymmärtää aluksi, mutta luentomateriaaleja ja demoja katsomalla teoria selkeni hyvin.

* Ovatko verkot harvoja (sparse) vai tiheitä (dense)

![Alt text](kaava.png)

Ylläolevalla kaavalla voidaan laskea onko verkko tiheä vai ei, tuloksen mukaan määritellään verkon tiheys (mitä lähempänä tulos on 1, sitä tiheämpi verkko on).

Voimme siis laskea testien tuloksilla kun solmuja on 100 000 ja reunoja 557 681 kuten testeissä:

![Alt text](lasku.png)

Koska tulokseksi tulee 0,000111537, ei verkko tällöin ole tiheä.
Lähde: https://en.wikipedia.org/wiki/Dense_graph



* Map vai matriisi, kumpi parempi tietorakenne tässä tehtävässä?

Koska verkko ei ole tiheä, on Map tietorakenne parempi tässä tehtävässä. Map on myös joustava ja sopii hyvin tilanteisiin joissa solmujen määrä voi vaihdella, jolloin se on tehokkaampi muistin ja suorituskyvyn kannalta.

* Miksi verkon täyttäminen on hidasta? Miksi ohjattu "korjaus" paransi tehokkuutta?


![Alt text](pseudokoodi.png)
Pseudokoodi esimerkistä voi hyvin nähdä miksi täyttämisessä kestää kauan. Aluksi on for silmukka kaikille koodareille, jonka jälkeen for -silmukassa haetaan solmu koodarille, tämän jälkeen haetaan koodarin kaverit, jota seuraa uusi for -silmukka kaikille kaikille koodarin kavereille, tämän jälkeen haetaan vielä for -silmukassa solmu koodarikaverille. 

Silmukoita käytetään siis kolmella tasolla silmukkaa, jolloin aikakompleksisuus nousee O(n^3). Javan Set tietorakenne ei tarjoa get() metodia, jolla pystyisi helposti hakemaan tietyn olion, vaan joudutaan käymään koko tietosäiliö läpi silmukalla. Sisäkkäiset silmukat aiheuttavat täytön hitautumisen.

Hajautustaululla tehty korjaus paransi tehokkuutta, koska aikaisemmin koodarin hakeminen oli O(n) aikakompleksisuudeltaan, kun taas hajautustaulu muutti tästä O(1) operaation. Hajautustaulua hyödyntämällä voidaan välttää monta for -silmukkaa, jotka aikaisemmin olivat pakollisia Javan Set rajapintaluokan takia. takia. Kun silmukoita ei ole niin monella tasolla, nopeutuu aikakompleksisuuskin. Korjaus kuitenkin aiheutti sen, että muistikompleksisuus kasvoi, koska verteksien kuluttuma muisti tuplaantui.

* Eri toteutuksien nopeuserojen vertailu
Hashtable toteutuksen mittaukset
![Alt text](TIRA_TASK09_HASHTABLE_MITTAUKSET.png)

HashMap toteutuksen mittaukset
![Alt text](TIRA_TASK09_HASHMAP_MITTAUKSET.png)

Hashtable ja HashMap toteutuksen aikamittauksissa ei ole merkittäviä eroja. Solmujen määrän noustessa 50000, on syvyyshaku hieman nopeampi HashMap toteutuksella, 
![Alt text](TIRA_TASK09_PAREMPI_TAYTTOAIKA.png)


* Algoritmien aikatehokkuuden analysointi

V = vertexit (solmut), E = edget (reunat)

createVertexFor(T) metodin aikakompleksisuus on O(1), koska se ei sisällä silmukoita ja vertexiin ja ArrayListiin sijoittaminen on myös O(1)
![Alt text](createVertexFor.png)


getVertices() aikakompleksisuus on O(1), getVertices() ei sisällä silmukoita.

![Alt text](getVertices.png)

Reunojen lisääminen on O(1) operaatio
![Alt text](addEdge.png)

Reunojen hakeminen on myös O(1) operaatio
![Alt text](getEdges.png)


getVertexFor(T) metodin aikakompleksisuus oli alkuperäisellä toteutuksella (kommentoituna) O(V), koska siinä käytiin kaikki vertexit läpi for -silmukassa. Korjatulla toteutuksella aikakompleksisuus on O(1), koska vertexi haetaan hajautustaulusta hajautusavaimella.
![Alt text](getVertexFor.png)



Leveyshaussa askelten määrä riippuu verkon rakenteesta, aikakompleksisuus on O(V+E), mutta jos melkein kaikki solmut ovat connected (yhdistetty), on E lähellä V^2, jolloin aikakompleksisuus nousee O(V^2).
![Alt text](leveyshaku.png)

Syvyyshaun aikakompleksisuus on O(V+E)
![Alt text](syvyyshaku.png)



![Alt text](isDisconnected.png)

isDisconnected ja disconnectedVertices ovat aikakompleksisuudeltaan myös O(V+E), koska disconnectedVertices metodi käyttää leveyshakua, ja isDisconnected taas käyttää disconnectedVertices metodia. Eli aina kun tarkistetaan onko verkko disconnected, tehdään leveyshakua, jolloin aikakompleksisuus on sama kuin leveyshaulla.
