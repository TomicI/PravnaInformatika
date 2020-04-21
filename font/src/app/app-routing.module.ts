import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignupFormComponent } from "./signup-form/signup-form.component";
import { LoginComponent } from "./login/login.component";
import { RobaFormComponent } from "./roba-form/roba-form.component";
import { ProfilComponent } from "./profil/profil.component";
import { HomeComponent } from "./home/home.component";
import { DetailsRobaComponent } from "./details-roba/details-roba.component";
import { KupovinaComponent } from "./kupovina/kupovina.component";


const routes: Routes = [
  {path: '', redirectTo: '/app', pathMatch: 'full'},
  { path: 'app',
    children: [
      { path: '', component: HomeComponent },
      { path: 'signup', component: SignupFormComponent },
      { path: 'login', component: LoginComponent },
      { path: 'addRoba', component: RobaFormComponent },
      { path: 'profile', component: ProfilComponent },
      { path: 'details/:id', component: DetailsRobaComponent },
      { path: 'kupovina/:id', component: KupovinaComponent }] },
  { path: 'login', component: LoginComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
