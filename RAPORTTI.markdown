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

* Mikä on toteuttamasi reverse -algoritmin aikakompleksisuusluokka?

Reverse -algoritmin aikakompleksisuusluokka on lineaarinen O(n) eli tietomäärän kasvaessa, algoritmin suoritusaika kasvaa lineaarisesti suhteessa tietomäärään

* Jos taulukko on jo valmiiksi järjestyksessä nousevaan järjestykseen, ja se aiotaan lajitella laskevaan järjestykseen, kannattaako taulukko lajitella vai kääntää sen järjestys? Miksi, perustele?

Koska taulukko on jo valmiiksi järjestyksessä nousevaan järjestykseen, niin ei ole tarvetta tehdä taulukon alkioiden vertailua. Tämän takia taulukko kannattaa kääntää lajittelun sijasta, koska se on aikatehokkaampaa, koska reverse algoritmin aikakompleksisuus on pienempi kuin lajittelualgoritmin.

## 02-TASK

Tässä tehtävässä opin lisää lajittelusta, Comparator rajapinnasta sekä Predicate rajapinnasta. Pystyin hyödyntämään opittua TIRA Codersin koodareiden lajittelussa. Opin myös tekemään lineaarisen hakualgoritmin, sekä elementtien etsimiseen tarkoitettuja algoritmeja.

[Hakuaika](TIRA_TASK02_Hakuaika.png)
[Tayttoaika](TIRA_TASK02_Tayttoaika.png)

## 03-TASK

## 04-TASK

## 05-TASK

## 06-TASK

## 07-TASK

## 08-TASK

## 09-TASK