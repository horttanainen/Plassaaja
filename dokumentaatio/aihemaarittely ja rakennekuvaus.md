Aihem��rittely

Aihe: Sitsiplassaaja. Plassaaja plassaa k�ytt�j�n sy�tt�m�t henkil�t avec- ja kaveritoiveiden mukaisesti yhteen p�yt��n.

Plassaaja tulostaa lopuksi taulukon, jossa sitsaajat istuvat paikallaan.

K�ytt�j�t: Em�nn�t ja mahdollisesti my�hemmin toteutettava yhteensopiva Sitsi-ilmo.

Em�ntien toiminnot:

Sitsaajien sy�tt� ohjelmaan tietoineen.

Sitsaajien tietojen muokkaus.

Sitsaajan poisto.

P�yt�plassauksen tulostus.

Rakennekuvaus

Main kaynnistaa Kayttoliittyman, joka vuorostaan luo uuden SitsaajienManagerointiolion. Saitsaajien manageri luo Aveccienparittajan, SitsiIlmon, SitsaajienPisteyttajan, Plassaajan, SitsaajienRyhmittajan ja Kaverienparittajan ja samalla luo n�ille luokkien v�liset yhteydet:

Aveccienparittaja hakee sitsaajat SitsiIlmosta, kuten my�s Kaverienparittaja ja SitsaajienPisteytt�j�.

SitsaajienRyhmitt�j� hakee SitsaajienPisteytt�j�lt� pisteytetyt sitsaajat.

Plassaaja hakee SitsaajienRyhmitt�j�lt� kaveriporukat.

Kaikki SitsaajienManageroinnin alaiset luokat tuntevat Sitsaajaluokan, koska ne tekev�t muutoksia Sitsaajan ilmentymien attribuutteihin.

Plassaaja tuntee taulukon, koska ohjelman graafinen tulostus tapahtuu plassaajan metodin tulosta() kautta.

Plassaaja tuntee my�s p�yd�n, koska plassaaja plassaa sitsaajat poydan attribuuttiin List<Sitsaaja> poyta.

My�s Poyta tuntee Sitsaajan.

Sitsaajilla on mm attribuutti Sukupuli, jota varten on Enumeration-luokka Sukupuoli. Sitsaaja tuntee Sukupuolienumeraation.

Taulukko tuntee poydan, koska se kayttaa Poydan List<Sitsaaja> poyta attribuuttia hakeakseen sitsaajien paikat graafista versiota varten.
 
