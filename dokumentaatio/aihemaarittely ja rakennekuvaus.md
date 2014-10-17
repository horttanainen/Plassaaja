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

Main kaynnistaa Kayttoliittyman, joka vuorostaan luo uuden SitsaajienManagerointiolion. Saitsaajien manageri luo Aveccienparittajan, SitsiIlmon, SitsaajienPisteyttajan, Plassaajan, SitsaajienRyhmittajan ja Kaverienparittajan ja samalla luo näille luokkien väliset yhteydet:

Aveccienparittaja hakee sitsaajat SitsiIlmosta, kuten myös Kaverienparittaja ja SitsaajienPisteyttäjä.

SitsaajienRyhmittäjä hakee SitsaajienPisteyttäjältä pisteytetyt sitsaajat.

Plassaaja hakee SitsaajienRyhmittäjältä kaveriporukat.

Kaikki SitsaajienManageroinnin alaiset luokat tuntevat Sitsaajaluokan, koska ne tekevät muutoksia Sitsaajan ilmentymien attribuutteihin.

Plassaaja tuntee taulukon, koska ohjelman graafinen tulostus tapahtuu plassaajan metodin tulosta() kautta.

Plassaaja tuntee myös pöydän, koska plassaaja plassaa sitsaajat poydan attribuuttiin List<Sitsaaja> poyta.

Myös Poyta tuntee Sitsaajan.

Sitsaajilla on mm attribuutti Sukupuli, jota varten on Enumeration-luokka Sukupuoli. Sitsaaja tuntee Sukupuolienumeraation.

Taulukko tuntee poydan, koska se kayttaa Poydan List<Sitsaaja> poyta attribuuttia hakeakseen sitsaajien paikat graafista versiota varten.
 
