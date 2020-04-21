export class User  {
  firstName: string;
  lastName: string;
  username: string;
  email: string;
  password: string;
  phone: string;
  brLicneKarte: string;
  izdateU: string;
  city: string;


  constructor(firstName: string, lastName: string, username: string, email: string, password: string, phone: string, city: string, brLicneKarte: string, izdateU: string) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.username = username;
    this.email = email;
    this.password = password;
    this.phone = phone;
    this.city = city;
    this.brLicneKarte = brLicneKarte;
    this.izdateU = izdateU;
  }
}

export class JwtResponse {
  accessToken: string;
  type: string;
  username: string;
}


export class Roba {
  id: number;
  naziv: string;
  opis: string;
  kolicina: number;
  cena: number;
  rokIsporuke: number;
  rokIsporukeMax: number;
  kupacOdgovoran: boolean;
  uputstvo: boolean;
  nesaobraznostZamenom: boolean;
  rokOdPrelaskaRizikaNaKupca: number;
  rokOdustanak: number;
  deoRobe: string;
  rokVracanjaRobe: number;
  rokVracanjaNovca: number;
  izvrsiteljIsporuke: string;
  troskoveSnosi: string;
  troskoviOdustanak: string;
  brojPrimeraka: number;
  brojPrimeraKupac: number;
  vlasnik: User;
  slika: Blob;
  robaIsporucena: Date;
  robaIsporucenaVracena: Date;
  novacIsporucen: Date;
  novacIsporucenVracen: Date;
  pravoSaobraznost: boolean;


  constructor (id: number, naziv: string, opis: string, kolicina: number, cena: number, rokIsporuke: number, rokIsporukeMax: number, kupacOdgovoran: boolean, uputstvo: boolean, nesaobraznostZamenom: boolean, rokOdPrelaskaRizikaNaKupca: number, rokOdustanak: number, deoRobe: string, rokVracanjaRobe: number, rokVracanjaNovca: number, izvrsiteljIsporuke: string, troskoveSnosi: string, troskoviOdustanak: string, brojPrimeraka: number, brojPrimeraKupac: number, vlasnik: User, slika: Blob, robaIsporucena: Date, robaIsporucenaVracena: Date, novacIsporucen: Date, novacIsporucenVracen: Date, pravoSaobraznost: boolean){
    this.id=id;
    this.naziv=naziv;
    this.opis=opis;
    this.kolicina=kolicina;
    this.cena=cena;
    this.rokIsporuke=rokIsporuke;
    this.rokIsporukeMax=rokIsporukeMax;
    this.kupacOdgovoran=kupacOdgovoran;
    this.uputstvo=uputstvo;
    this.nesaobraznostZamenom=nesaobraznostZamenom;
    this.rokOdPrelaskaRizikaNaKupca=rokOdPrelaskaRizikaNaKupca;
    this.rokOdustanak=rokOdustanak;
    this.deoRobe=deoRobe;
    this.rokVracanjaRobe=rokVracanjaRobe;
    this.rokVracanjaNovca=rokVracanjaNovca;
    this.izvrsiteljIsporuke=izvrsiteljIsporuke;
    this.troskoveSnosi=troskoveSnosi;
    this.troskoviOdustanak=troskoviOdustanak;
    this.brojPrimeraka=brojPrimeraka;
    this.brojPrimeraKupac=brojPrimeraKupac;
    this.vlasnik=vlasnik;
    this.slika=slika;
    this.robaIsporucena= robaIsporucena;
    this.robaIsporucenaVracena= robaIsporucenaVracena;
    this.novacIsporucen= novacIsporucen;
    this.novacIsporucenVracen= novacIsporucenVracen;
    this.pravoSaobraznost= pravoSaobraznost;
  }
}
