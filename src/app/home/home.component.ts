import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from "@angular/forms";
import { Roba } from "../model";
import { RobaService } from "../services/roba.service";
import { Router } from "@angular/router";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  providers: [ RobaService ]
})
export class HomeComponent implements OnInit {

  formS: FormGroup;
  pretraga: boolean;
  searchInput: string;
  rezultat: Roba[];

  constructor(private formBuilder: FormBuilder, private robaService: RobaService, private router: Router) { }

  ngOnInit() {
    this.pretraga=false;
    this.searchInput="";
    this.rezultat=[];
 /*   this.formS=this.formBuilder.group({
      searchInput:  ['']
    })*/
  }

  onSubmit() {
    this.pretraga=true;

    console.log("pretraga");
    console.log(this.searchInput);

    this.robaService.pretraga(this.searchInput).then(data=>{
      this.rezultat=data;
      console.log("rezultati no");
      console.log(this.rezultat.length);
    })
  }

  detailsRoba(id: number){
    console.log("id robe");
    console.log(id);
    this.router.navigateByUrl('/app/details/'+id);
  }

}
