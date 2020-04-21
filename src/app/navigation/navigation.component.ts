import { Component, OnInit } from '@angular/core';
import {TokenService} from "../services/token.service";
import { NgbModal } from "bootstrap";

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css'],
  providers : [ TokenService ]
})
export class NavigationComponent implements OnInit {

  buttonName = 'Sign up';

  loginDiv = true;
  signupDiv = false;
  isAdmin = false;


  isLoggedIn = false;



  name = 'Log in';

  username = '';

  constructor(
              private tokenStorage: TokenService) { }
  ngOnInit() {

    if (this.tokenStorage.getToken()) {

      this.isLoggedIn = true;
      this.username = this.tokenStorage.getUsername();
    }

  }

  clickEvent() {

    this.loginDiv = !this.loginDiv;

    if (this.loginDiv) {
      this.name = 'Log in';
      this.buttonName = 'Sign up';
    } else {
      this.name = 'Sign up';
      this.buttonName = 'Login';
    }


  }

  clickEvent1() {

    this.loginDiv = !this.loginDiv;

    if (this.loginDiv) {
      this.name = 'Log in';
      this.buttonName = 'Sign up';
    } else {
      this.name = 'Sign up';
      this.buttonName = 'Login';
    }


  }

  open(content) {
    console.log(content);
    if (!this.isLoggedIn) {
      window.location.href = "app/login";
    } else {
      this.tokenStorage.signOut();
      this.reloadPage();
    }
  }

  reloadPage() {
    window.location.href = "app";
  }

}
