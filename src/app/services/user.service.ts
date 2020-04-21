import { Injectable } from '@angular/core';
import {Roba, User} from "../model";
import { HttpClient } from '@angular/common/http';
import { Observable } from "rxjs";

@Injectable()
export class UserService {

  rez: User;
  public USER_API='//localhost:8080/api/user';
  constructor(private http: HttpClient) { }

  saveUser(user: User): Observable<User>{
    console.log(user);
    return this.http.post<User>(this.USER_API + '/save', user);
  }

  loginCheck(user: User): Promise<User>{
    console.log(user);
    return this.http.put<User>(this.USER_API + '/login', user).toPromise();
  }

  getUser(): Observable<User> {
    return this.http.get<User>(this.USER_API );
  }
}
