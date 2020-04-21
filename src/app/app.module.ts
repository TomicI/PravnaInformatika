import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


import { AppComponent } from './app.component';
import { AppRoutingModule } from './/app-routing.module';
import { SignupFormComponent } from './signup-form/signup-form.component';
import { LoginComponent } from './login/login.component';
import { NavigationComponent } from './navigation/navigation.component';
import { RobaFormComponent } from './roba-form/roba-form.component';

import { httpInterceptorProviders } from './interceptor';
import {TokenService} from "./services/token.service";
import {UserService} from "./services/user.service";
import { ProfilComponent } from './profil/profil.component';
import { HomeComponent } from './home/home.component';
import { DetailsRobaComponent } from './details-roba/details-roba.component';
import { KupovinaComponent } from './kupovina/kupovina.component';


@NgModule({
  declarations: [
    AppComponent,
    SignupFormComponent,
    LoginComponent,
    NavigationComponent,
    RobaFormComponent,
    ProfilComponent,
    HomeComponent,
    DetailsRobaComponent,
    KupovinaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [httpInterceptorProviders, TokenService, UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
