import { Component, OnInit } from '@angular/core';
import {TokenService} from "../services/token.service";
import {User} from "../model";
import {UserService} from "../services/user.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [ TokenService, UserService]
})
export class LoginComponent implements OnInit {

  buttonName = 'Log in';
  form: any = {};
  loginDiv = true;
  signupDiv = false;
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  user: User;
  userR: User;

  name = 'Log in';


  constructor(private tokenStorage: TokenService, private userService: UserService, private router: Router) { }

  ngOnInit() {
    this.user=null;
    this.userR=null;
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
    }
  }

  onSubmit() {
    console.log(this.form);

    this.user = new User(null, null, this.form.username, null, this.form.password, null, "error" );

    this.userService.loginCheck(this.user).then( data=>{
        console.log("rezultat");
        console.log(data);
        this.tokenStorage.saveToken(data.city);
        this.tokenStorage.saveUsername(data.username);

        console.log("token");
        console.log(this.tokenStorage.getToken());

        console.log("username");
        console.log(this.tokenStorage.getUsername());

        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.router.navigateByUrl('/app/profile');
      },
      error => {
        console.log(error);
//      this.errorMessage = error.error.message;
        this.isLoginFailed = true;
        alert("Pogrešan username ili password!");
        this.name = 'Log out';
      }
    );

  }

  reloadPage() {
    window.location.reload();
  }
}
