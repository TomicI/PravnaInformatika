pragma solidity ^0.4.25;

contract ugovorKupoprodaja{
    address prodavac;
    address kupac;
    bool public prodavacSaglasan=false;
    bool public kupacSaglasan=false;
    string public roba;
    string public opisRobe;
    string public podaciKupac;
    string public podaciProdavac;
    string public adresaKupac;
    string public adresaProdavac;
    uint public zakljucenDana;
    uint public robaVracenaDana; //dan kada je poslata roba nazad
    uint public kolicinaRobe;
    uint public cena;
    uint public rokIsporuke;
    uint public rokIsporukeMax;
    uint public rokVracanjaNovca;
    uint public rokVracanjaRobe;
    enum Strane{PRODAVAC, KUPAC}
    Strane troskovi=Strane.KUPAC;
    string public izvrsiteljIsporuke;
    bool public uputstvo=false;
    bool public pravoSaobraznost=false; // da li je korisceno
    uint public rokSaobraznost;
    uint public rokOdustanak;
    uint public rokOdPrelaskaRizikaNaKupca;
    enum DeoRobe{PRVI, POSLEDNJI}
    DeoRobe deoRobe=DeoRobe.PRVI;
    Strane troskoviOdustanak=Strane.KUPAC;
    uint public brojPrimeraka;
    uint public brojPrimerakaKupac;
    string public zakljucenU;
    bool public kupacOdgovoranZaStetuNepreuzimanja;
    bool public nesaobraznostZamenom; //true ima pravo, false nema
    uint public robaPrimljenaVracena=0; //u slucaju vracanja kupac->prodavac
    uint public novacVracen=0; //u slucaju vracanja prodavac->kupac
    uint public novacUplacen=0; //kada je dostavljna kupac->prodavac
    uint public robaIsporucena=0; //kada je dostavljna prodavac->kupac

    constructor () public {
        prodavac=msg.sender;
    }

    function setKupac(address _kupac, string  _podaciKupac, string  _adresaKupac) public {
        kupac=_kupac;
        podaciKupac=_podaciKupac;
        adresaKupac=_adresaKupac;
    }

    function setProdavac( string  _podaciProdavac, string  _adresaProdavac) public {
        podaciProdavac=_podaciProdavac;
        adresaProdavac=_adresaProdavac;

    }

    function setRoba(string  _opisRobe, uint _kolicinaRobe, uint _cena, uint _rokIsporuke, uint _rokIsporukeMax, bool _kupacOdg, bool _uputstvo, bool _nesaobraznostZamenom, uint _rokOdPrelaskaRizikaNaKupca, uint _rokOdustanak, uint _deoRobe, uint _rokVracanjaRobe, uint _rokVracanjaNovca, uint _brojPrimeraka, uint _brojPrimerakaKupac ) public {
        require(uint(DeoRobe.POSLEDNJI) >= _deoRobe);
        opisRobe=_opisRobe;
        kolicinaRobe=_kolicinaRobe;
        cena=_cena;
        rokIsporuke=_rokIsporuke;
        rokIsporukeMax=_rokIsporukeMax;
        kupacOdgovoranZaStetuNepreuzimanja=_kupacOdg;
        uputstvo=_uputstvo;
        nesaobraznostZamenom=_nesaobraznostZamenom;
        rokOdPrelaskaRizikaNaKupca=_rokOdPrelaskaRizikaNaKupca;
        rokOdustanak=_rokOdustanak;
        deoRobe=DeoRobe(_deoRobe);
        rokVracanjaRobe=_rokVracanjaRobe;
        rokVracanjaNovca=_rokVracanjaNovca;
        brojPrimeraka=_brojPrimeraka;
        brojPrimerakaKupac=_brojPrimerakaKupac;
        prodavacSaglasan=true;
    }

    function setIsporuka(string _izvrsiteljIsporuke, uint strana, uint _troskoviOdustanak) public {
        require(uint(Strane.KUPAC) >= strana && uint(Strane.KUPAC) >= _troskoviOdustanak);
        troskovi=Strane(strana);
        troskoviOdustanak=Strane(_troskoviOdustanak);
        izvrsiteljIsporuke=_izvrsiteljIsporuke;
    }

    function saglasnostKupca() public kupacOnly{
        kupacSaglasan=true;
        zakljucenDana=now;
    }

    function saglasnostProdavca() public prodavacOnly{
        prodavacSaglasan=true;
    }

    function getSnosiTroskove() public view returns(Strane){
        return troskovi;
    }

    function vracanjeRobe() public kupacOnly saglasnostVolja {
        if(now <= zakljucenDana+rokVracanjaRobe){
            robaVracenaDana=now;
        }
    }

    function uplataProdavcaPovracaj() public prodavacOnly saglasnostVolja {
        if(robaVracenaDana>0){
            prodavac.transfer(address(this).balance);
        }
    }

    function odustanakKupac() public kupacOnly saglasnostVolja{
        if(now <= zakljucenDana+rokOdustanak){
            robaVracenaDana=now;
            robaIsporucena=0;
            pravoSaobraznost=true;
        }
    }

    function saobraznostKupac(bool _raskiniUgovor, bool _zamena, uint umanjenjaCena) public kupacOnly saglasnostVolja{
        if(now <= zakljucenDana+rokOdPrelaskaRizikaNaKupca+rokSaobraznost && pravoSaobraznost==false){
            robaVracenaDana=now;
            if(_zamena==true && nesaobraznostZamenom==true){
                robaIsporucena=0;
                robaVracenaDana=now;
                pravoSaobraznost=true;
            } else if(_raskiniUgovor==true){
                robaVracenaDana=now;
                kupacSaglasan=false;
                pravoSaobraznost=true;
            } else if (umanjenjaCena>0){
                cena=cena-umanjenjaCena;
                pravoSaobraznost=true;
            }
        }

    }

    function setRobaIsporucena()  public kupacOnly {
        robaIsporucena=now;
    }

    function setUplaceno()  public prodavacOnly {
         novacUplacen=now;
    }

    function setRobaVracena()  public prodavacOnly {
        robaPrimljenaVracena=now;
    }

    function setUplacenoVraceno()  public kupacOnly {
        novacVracen=now;
        pravoSaobraznost=false;
        robaIsporucena=0;
        kupac=0;
        kupacSaglasan=false;
        adresaKupac="";
        podaciKupac="";
    }

    function setKupacNijePreuzeo()  public prodavacOnly {
        robaIsporucena=0;
        kupac=0;
        kupacSaglasan=false;
        adresaKupac="";
        podaciKupac="";
    }

    modifier prodavacOnly() {
        require(msg.sender == prodavac, "omogućeno jedino prodavcu");
        _;
    }

    modifier kupacOnly() {
        require(msg.sender == kupac, "omogućeno jedino kupcu");
        _;
    }

    modifier saglasnostVolja() {
        require(prodavacSaglasan && kupacSaglasan);
        _;
    }



}