package com.example.demo.model;


import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "roba")
public class Roba {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "naziv")
    private String naziv;

    @Column(name = "opis")
    private String opis;

    @Column(name = "kolicina")
    private Integer kolicina;

    @Column(name = "cena")
    private Double cena;

    @Column(name = "rokIsporuke")
    private Integer rokIsporuke;

    @Column(name = "rokIsporukeMax")
    private Integer rokIsporukeMax;

    @Column(name = "kupacOdgovoran")
    private Boolean kupacOdgovoran; //kupacOdgovoranZaStetuNepreuzimanja

    @Column(name = "uputstvo")
    private Boolean uputstvo;

    @Column(name = "nesaobraznostZamenom")
    private Boolean nesaobraznostZamenom;

    @Column(name = "rokOdPrelaskaRizikaNaKupca")
    private Integer rokOdPrelaskaRizikaNaKupca;

    @Column(name = "rokOdustanak")
    private Integer rokOdustanak;

    @Column(name = "deoRobe")
    private String deoRobe;

    @Column(name = "rokVracanjaRobe")
    private Integer rokVracanjaRobe;

    @Column(name = "rokVracanjaNovca")
    private Integer rokVracanjaNovca;

    @Column(name = "robaProdata")
    private Boolean robaProdata;

    @Column(name = "pravoSaobraznost")
    private Boolean pravoSaobraznost;

    @Column(name = "robaIsporucena")
    private Date robaIsporucena;

    @Column(name = "robaIsporucenaVracena")
    private Date robaIsporucenaVracena;

    @Column(name = "novacIsporucen")
    private Date novacIsporucen;

    @Column(name = "novacIsporucenVracen")
    private Date novacIsporucenVracen;

    @Column(name = "izvrsiteljIsporuke")
    private String izvrsiteljIsporuke;

    @Column(name = "troskoveSnosi")
    private String troskoveSnosi;

    @Column(name = "troskoviOdustanak")
    private String troskoviOdustanak;

    @Column(name = "brojPrimeraka")
    private Integer brojPrimeraka;

    @Column(name = "brojPrimeraKupac")
    private Integer brojPrimeraKupac;

    @Column(name = "slika")
    private byte[] slika;

    @ManyToOne
    private User vlasnik;

    public Roba() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Integer getKolicina() {
        return kolicina;
    }

    public void setKolicina(Integer kolicina) {
        this.kolicina = kolicina;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public User getVlasnik() {
        return vlasnik;
    }

    public void setVlasnik(User vlasnik) {
        this.vlasnik = vlasnik;
    }

    public Integer getRokIsporuke() {
        return rokIsporuke;
    }

    public void setRokIsporuke(Integer rokIsporuke) {
        this.rokIsporuke = rokIsporuke;
    }

    public Integer getRokIsporukeMax() {
        return rokIsporukeMax;
    }

    public void setRokIsporukeMax(Integer rokIsporukeMax) {
        this.rokIsporukeMax = rokIsporukeMax;
    }

    public Boolean getKupacOdgovoran() {
        return kupacOdgovoran;
    }

    public void setKupacOdgovoran(Boolean kupacOdgovoran) {
        this.kupacOdgovoran = kupacOdgovoran;
    }

    public Boolean getUputstvo() {
        return uputstvo;
    }

    public void setUputstvo(Boolean uputstvo) {
        this.uputstvo = uputstvo;
    }

    public Boolean getNesaobraznostZamenom() {
        return nesaobraznostZamenom;
    }

    public void setNesaobraznostZamenom(Boolean nesaobraznostZamenom) {
        this.nesaobraznostZamenom = nesaobraznostZamenom;
    }

    public Integer getRokOdPrelaskaRizikaNaKupca() {
        return rokOdPrelaskaRizikaNaKupca;
    }

    public void setRokOdPrelaskaRizikaNaKupca(Integer rokOdPrelaskaRizikaNaKupca) {
        this.rokOdPrelaskaRizikaNaKupca = rokOdPrelaskaRizikaNaKupca;
    }

    public Integer getRokOdustanak() {
        return rokOdustanak;
    }

    public void setRokOdustanak(Integer rokOdustanak) {
        this.rokOdustanak = rokOdustanak;
    }

    public String getDeoRobe() {
        return deoRobe;
    }

    public void setDeoRobe(DeoRobe deoRobe) {
        this.deoRobe = deoRobe.name();
    }

    public Integer getRokVracanjaRobe() {
        return rokVracanjaRobe;
    }

    public void setRokVracanjaRobe(Integer rokVracanjaRobe) {
        this.rokVracanjaRobe = rokVracanjaRobe;
    }

    public Integer getRokVracanjaNovca() {
        return rokVracanjaNovca;
    }

    public void setRokVracanjaNovca(Integer rokVracanjaNovca) {
        this.rokVracanjaNovca = rokVracanjaNovca;
    }

    public Boolean getRobaProdata() { return robaProdata; }

    public void setRobaProdata(Boolean robaProdata) { this.robaProdata = robaProdata; }

    public String getIzvrsiteljIsporuke() { return izvrsiteljIsporuke; }

    public void setIzvrsiteljIsporuke(String izvrsiteljIsporuke) { this.izvrsiteljIsporuke = izvrsiteljIsporuke; }

    public String getTroskoveSnosi() { return troskoveSnosi; }

    public void setTroskoveSnosi(Strane pom) {
        this.troskoveSnosi = pom.name();
    }

    public String getTroskoviOdustanak() { return troskoviOdustanak; }

    public void setTroskoviOdustanak(Strane pom) {
        this.troskoviOdustanak = pom.name();
    }

    public void setDeoRobe(String deoRobe) {
        this.deoRobe = deoRobe;
    }

    public void setTroskoveSnosi(String troskoveSnosi) {
        this.troskoveSnosi = troskoveSnosi;
    }

    public void setTroskoviOdustanak(String troskoviOdustanak) {
        this.troskoviOdustanak = troskoviOdustanak;
    }

    public Integer getBrojPrimeraka() {
        return brojPrimeraka;
    }

    public void setBrojPrimeraka(Integer brojPrimeraka) {
        this.brojPrimeraka = brojPrimeraka;
    }

    public Integer getBrojPrimeraKupac() {
        return brojPrimeraKupac;
    }

    public void setBrojPrimeraKupac(Integer brojPrimeraKupac) {
        this.brojPrimeraKupac = brojPrimeraKupac;
    }

    public byte[] getSlika() { return slika; }

    public void setSlika(byte[] slika) { this.slika = slika; }

    public Date getRobaIsporucena() { return robaIsporucena; }

    public void setRobaIsporucena(Date robaIsporucena) { this.robaIsporucena = robaIsporucena; }

    public Date getRobaIsporucenaVracena() { return robaIsporucenaVracena; }

    public void setRobaIsporucenaVracena(Date robaIsporucenaVracena) { this.robaIsporucenaVracena = robaIsporucenaVracena; }

    public Date getNovacIsporucen() { return novacIsporucen; }

    public void setNovacIsporucen(Date novacIsporucen) { this.novacIsporucen = novacIsporucen; }

    public Date getNovacIsporucenVracen() { return novacIsporucenVracen; }

    public void setNovacIsporucenVracen(Date novacIsporucenVracen) { this.novacIsporucenVracen = novacIsporucenVracen; }

    public Boolean getPravoSaobraznost() { return pravoSaobraznost; }

    public void setPravoSaobraznost(Boolean pravoSaobraznost) { this.pravoSaobraznost = pravoSaobraznost; }
}
