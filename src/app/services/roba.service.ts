import { Injectable } from '@angular/core';
import { Roba } from "../model";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable()
export class RobaService {

  roba: Roba;
  public ROBA_API = '//localhost:8080/api/roba';
  constructor(private http: HttpClient) { }

  saveRoba (roba: Roba): Observable<Roba>{
    console.log(roba);
    return this.http.post<Roba>(this.ROBA_API + '/save', roba);
  }

  getRoba(): Promise<Roba[]> {
    return this.http.get<Roba[]>(this.ROBA_API +'/robaUser').toPromise();
  }

  getRobaKupljena(): Promise<Roba[]> {
    return this.http.get<Roba[]>(this.ROBA_API +'/robaUserKupljeno').toPromise();
  }

  getRobaProdata(): Promise<Roba[]> {
    return this.http.get<Roba[]>(this.ROBA_API +'/robaUserProdato').toPromise();
  }

  pretraga(pretraga: String): Promise<Roba[]> {
    return this.http.put<Roba[]>(this.ROBA_API +'/pretraga', pretraga).toPromise();
  }

  getRobaById(id: number): Promise<Roba> {
    return this.http.put<Roba>(this.ROBA_API +'/getById', id).toPromise();
  }

  kupvina(id: number): Promise<Roba> {
    return this.http.put<Roba>(this.ROBA_API +'/kupovina', id).toPromise();
  }

  ukloni(id: number): Promise<Roba> {
    return this.http.delete<Roba>(this.ROBA_API +'/ukloni/' + id).toPromise();
  }

  robaIsporucena(id: number): Promise<Roba> {
    return this.http.put<Roba>(this.ROBA_API +'/robaIsporucena', id).toPromise();
  }

  robaIsporucenaVracena(id: number): Promise<Roba> {
    return this.http.put<Roba>(this.ROBA_API +'/robaIsporucenaVracena', id).toPromise();
  }

  novacIsporucen(id: number): Promise<Roba> {
    return this.http.put<Roba>(this.ROBA_API +'/novacIsporucen', id).toPromise();
  }

  novacIsporucenVracen(id: number): Promise<Roba> {
    return this.http.put<Roba>(this.ROBA_API +'/novacIsporucenVracen', id).toPromise();
  }

  kupacNijePreuzeo(id: number): Promise<Roba> {
    return this.http.put<Roba>(this.ROBA_API +'/kupacNijePreuzeo', id).toPromise();
  }

  kupacOdustanak(id: number): Promise<Roba> {
    return this.http.put<Roba>(this.ROBA_API +'/kupacOdustanak', id).toPromise();
  }

  saobraznost(id: number, zamena: boolean, odustanak: boolean, umanjenje: number): Promise<Roba> {
    return this.http.put<Roba>(this.ROBA_API +'/saobraznost/' + '/' + zamena + '/' + odustanak + '/' + umanjenje, id).toPromise();
  }
}

