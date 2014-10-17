Aihemäärittely

Aihe: Sitsiplassaaja. Plassaaja plassaa käyttäjän syöttämät henkilöt avec- ja kaveritoiveiden mukaisesti yhteen pöytään.

Plassaaja tulostaa lopuksi taulukon, jossa sitsaajat istuvat paikallaan.

Käyttäjät: Emännät ja mahdollisesti myöhemmin toteutettava yhteensopiva Sitsi-ilmo.

Emäntien toiminnot:

Sitsaajien syöttö ohjelmaan tietoineen.

Sitsaajien tietojen muokkaus.

Sitsaajan poisto.

Pöytäplassauksen tulostus.

Rakennekuvaus

Main kaynnistaa Kayttoliittyman, joka vuorostaan luo uuden SitsaajienManagerointiolion. SitsaajienManageri luo AveccienParittajan, SitsiIlmon, SitsaajienPisteyttajan, Plassaajan, SitsaajienRyhmittajan ja Kaverienparittajan ja samalla luo näille tarvittavat yhteydet.

Aveccienparittaja hakee sitsaajat SitsiIlmosta, kuten myös Kaverienparittaja ja SitsaajienPisteyttäjä.

SitsaajienRyhmittäjä hakee SitsaajienPisteyttäjältä pisteytetyt sitsaajat.

Plassaaja hakee SitsaajienRyhmittäjältä kaveriporukat.

Kaikki SitsaajienManageroinnin alaiset luokat tuntevat Sitsaajaluokan, koska ne tekevät muutoksia Sitsaajan ilmentymien attribuutteihin.

Plassaaja tuntee taulukon, koska ohjelman graafinen tulostus tapahtuu plassaajan metodin tulosta() kautta.

Plassaaja tuntee myös pöydän, koska plassaaja plassaa sitsaajat poydan attribuuttiin List<Sitsaaja> poyta.

Myös Poyta tuntee Sitsaajan.

Sitsaajilla on mm. attribuutti Sukupuoli, jota varten on enumeration-luokka Sukupuoli. Sitsaaja tuntee Sukupuolienumeraation.

Plassaajan toiminta:

AveccienParittaja ja KaverienParittaja liittävät sitsaajat toisiinsa toiveiden perusteella. Kaksi sitsaajaa ovat avecit vain jos molemmat ovat toivoneet toisiaan. Kaveruksia voi olla vaikka toinen ei olisi toivonutkaan, mutta tämä ei olekaan niin tiukka side plassatessa. Avecit istuvat aina vierekkäin.

SitsaajienPisteyttaja jarjestelee sitsaajat heidän saamien kaveritoiveiden perusteella.

SitsaajienRyhmittaja ottaa pisteytetystä listasta aina ensimmäisen sitsaajan ja plassaa tälle avecin. Kun avec on löydetty rakennetaan kaveriporukka sitsaajan ja avecin ympärille ensin etsimällä sitsaajia jotka olisivat molempien kaveritoiveissa, seuraavaksi vain ryhmän suosituimman toiveissa ja sitten avecin toivessa.

Löydetyistä sitsaajista ensimmäiseksi plassataan ne jotka ovat pyytäneet sekä suosituinta että tämän aveccia kaveriksi. Seuraavaksi ne jotka ovat pyytäneet suosituinta ja lopuksi avecia toivoneet.

Jos pari ei ole toivonut kavereita haetaan sitsaajien joukosta kaikki heitä toivoneet sitsaajat samassa järjestyksessä.

Kun ryhmittäjä on tehnyt kaveriporukat astuu Plassaaja kuvaan. Plassaaja järjestää kaveriporukat siten että suosituin ja tämän avec istuvat aina ryhmän keskellä.

Plassaaja ei hämmästy mahdollisista samaa sukupuolta edustavista pareista ja osaa myös plassata huoneen täydeltä naisia tai miehiä.

Taulukko tuntee poydan, koska se kayttaa Poydan List<Sitsaaja> poyta attribuuttia hakeakseen sitsaajien paikat graafista versiota varten.
 
