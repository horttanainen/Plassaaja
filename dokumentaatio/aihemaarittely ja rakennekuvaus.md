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

Main kaynnistaa Kayttoliittyman, joka vuorostaan luo uuden SitsaajienManagerointiolion. SitsaajienManageri luo AveccienParittajan, SitsiIlmon, SitsaajienPisteyttajan, Plassaajan, SitsaajienRyhmittajan ja Kaverienparittajan ja samalla luo n�ille tarvittavat yhteydet.

Aveccienparittaja hakee sitsaajat SitsiIlmosta, kuten my�s Kaverienparittaja ja SitsaajienPisteytt�j�.

SitsaajienRyhmitt�j� hakee SitsaajienPisteytt�j�lt� pisteytetyt sitsaajat.

Plassaaja hakee SitsaajienRyhmitt�j�lt� kaveriporukat.

Kaikki SitsaajienManageroinnin alaiset luokat tuntevat Sitsaajaluokan, koska ne tekev�t muutoksia Sitsaajan ilmentymien attribuutteihin.

Plassaaja tuntee taulukon, koska ohjelman graafinen tulostus tapahtuu plassaajan metodin tulosta() kautta.

Plassaaja tuntee my�s p�yd�n, koska plassaaja plassaa sitsaajat poydan attribuuttiin List<Sitsaaja> poyta.

My�s Poyta tuntee Sitsaajan.

Sitsaajilla on mm. attribuutti Sukupuoli, jota varten on enumeration-luokka Sukupuoli. Sitsaaja tuntee Sukupuolienumeraation.

Plassaajan toiminta:

AveccienParittaja ja KaverienParittaja liitt�v�t sitsaajat toisiinsa toiveiden perusteella. Kaksi sitsaajaa ovat avecit vain jos molemmat ovat toivoneet toisiaan. Kaveruksia voi olla vaikka toinen ei olisi toivonutkaan, mutta t�m� ei olekaan niin tiukka side plassatessa. Avecit istuvat aina vierekk�in.

SitsaajienPisteyttaja jarjestelee sitsaajat heid�n saamien kaveritoiveiden perusteella.

SitsaajienRyhmittaja ottaa pisteytetyst� listasta aina ensimm�isen sitsaajan ja plassaa t�lle avecin. Kun avec on l�ydetty rakennetaan kaveriporukka sitsaajan ja avecin ymp�rille ensin etsim�ll� sitsaajia jotka olisivat molempien kaveritoiveissa, seuraavaksi vain ryhm�n suosituimman toiveissa ja sitten avecin toivessa.

L�ydetyist� sitsaajista ensimm�iseksi plassataan ne jotka ovat pyyt�neet sek� suosituinta ett� t�m�n aveccia kaveriksi. Seuraavaksi ne jotka ovat pyyt�neet suosituinta ja lopuksi avecia toivoneet.

Jos pari ei ole toivonut kavereita haetaan sitsaajien joukosta kaikki heit� toivoneet sitsaajat samassa j�rjestyksess�.

Kun ryhmitt�j� on tehnyt kaveriporukat astuu Plassaaja kuvaan. Plassaaja j�rjest�� kaveriporukat siten ett� suosituin ja t�m�n avec istuvat aina ryhm�n keskell�.

Plassaaja ei h�mm�sty mahdollisista samaa sukupuolta edustavista pareista ja osaa my�s plassata huoneen t�ydelt� naisia tai miehi�.

Taulukko tuntee poydan, koska se kayttaa Poydan List<Sitsaaja> poyta attribuuttia hakeakseen sitsaajien paikat graafista versiota varten.
 
