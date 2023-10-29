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

Lajittelualgoritmin aikakompleksisuusluokka on neliöllinen eli O(n^2). Eli tietomäärän kasvaessa tarpeeksi, kasvaa algoritmin suoritusaika jopa eksponentiaalisesti. Algoritmi toimii sujuvasti pienien tietomäärien kanssa ja tällöin suoritusaika on lineaarinen, eikä se vaadi lisämuistia tehden siitä hyvän vaihtoehdon jos tietomäärät ovat pieniä. Jos tietomäärät ovat suuria, menee algoritmilla paljon aikaa lajitteluun eikä tämän takia välttämättä sovellu hyvin käyttöön niiden kanssa.
`
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
}`

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

Översti Aiden-Jack Arnab

Search took 75ms
Fast search took 0 ms

Källi Agnetha Bailie

Search took 23ms
Fast search took 0ms

Aalliniemi Muhammed Tayyib

Search took 0 ms
Fast search took 0 ms

* Mikä on tässä nopeassa haussa keskimäärin suoritusaika suhteessa ensimmäiseen hakuun?
	1. Haussa 75ms
	2. Haussa (nopeammassa) 0ms
	
	Koska toisessa haussa ei saada aikaa mikrosekunteina, voidaan todeta että puolitushaku on ainakin 75 kertaa nopeampi kuin lineaarinen haku.

* Kokeile hakea molemmilla tavoilla koodareita myös listan alusta. Mitä huomaat?
* Miksi jompi kumpi haku on nopeampi, ja onko sillä väliä haetaanko aineiston alusta vai lopusta? Pohdi ja perustele.

Ensimmäinen haku on tehty listan lopusta, toinen haku keskikohdasta ja viimeinen listan alusta, tiedostona on käytetty 50000 koodaria sisältävää listaa. Voidaan huomata, että kun haetaan koodaria lineaarisesti, niin aika joka menee hakemiseen on suurempi listan loppupäässä verrattuna alkupäähän. Tämä johtuu siitä että haku tehdään lineaarisesti, eli käydään alkiot läpi yksi kerrallaan, jolloin listan alussa olevat koodarit löytyvät nopeammin kuin listan loppussa olevat koodarit (tässä tapauksessa on aineisto lajiteltu jonka takia näin käy). Toisaalta taas kun tehdään puolitushaku (binary search), on kaikissa "Fast search" 0 ms. Puolitushaku toimii suurilla tietomäärillä paljon nopeammin kun jokaista yksittäistä alkiota ei käydä läpi, vaan jokaisella haku kerralla hakualue jaetaan kahteen osaan.

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


![ms/element](ms/element.png)


Taulukosta voidaan nähdä, että quicksortilla ja heapsortilla 1000 elementin aineistolla on isompi suoritusaika per elementti (0,23 ja 0,27) kuin 5000 elementin aineistolla (0,007 ja 0,009). Voidaan siis todeta että nämä lajittelualgoritmit toimivat paremmin isommalla aineistolla kuin pienellä.

Voidaan huomata että tällä aineistolla ja näillä testeillä heapsort on hitaampi kuin quicksort, johtuen esim. siitä että heapsortilla keon rakentaminen ja uudelleen järjestely vie aikaa, kun taas quicksortissa lajittelu tapahtuu jakamalla joka on nopeampaa. Pahimmassa tapauksessa quicksortin aikakompleksisuus on Big-O notaatiolla O(n^2) kun taas heapsortilla se on O(n log n). Pahin tapaus tapahtuu quicksortilla silloin, kun pivottina toimii taulukon pienin tai suurin arvo, ja tämä arvo on oikealla paikallaan eli taulukon alussa tai lopussa. Ongelmaa pystyy kuitenkin "väistämään" suhteellisen hyvin ottamalla esimerkiksi taulukon alusta, keskeltä ja lopusta arvot, vertaamalla näitä keskenään ottamalla mediaani, jota käytetään sitten pivottina. Heapsortin hyvänä puolena taas on se, että pahimman tapauksen aikakompleksisuus on sama kuin quicksortin paras eli O(n log n), eli jos lajittelua tehdään usein ja siihen tarvitaan vakautta, kannattaa sillon valita heapsort.

Vaikka insertionsort toimii huonosti isoilla aineistoilla, se on hyvä valinta jos aineisto on pieni ja suurimmaksi osiksi valmiiksi lajiteltu. Heapsort ja quicksort käyttävät myös enemmän tietokoneen resursseja verrattuna insertionsortiin.

## 07-TASK

## 08-TASK

## 09-TASK