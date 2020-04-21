import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {Router} from "@angular/router";
import {RobaService} from "../services/roba.service";

@Component({
  selector: 'app-roba-form',
  templateUrl: './roba-form.component.html',
  styleUrls: ['./roba-form.component.css'],
  providers: [ RobaService ]
})
export class RobaFormComponent implements OnInit {

  robaForm: FormGroup;
  errorMessage = '';
  pom : boolean;
  pom1: boolean;
  pom2: boolean;
  pom3: boolean;
  pom4: boolean;
  pom5: boolean;
  file: Blob=null;
  formData: FormData = new FormData();


  constructor(private router: Router,
              private formBuilder: FormBuilder,
              private robaService: RobaService) { }

  ngOnInit() {
    this.pom =false;
    this.pom1=false;
    this.pom2=false;
    this.pom3=false;
    this.pom4=false;
    this.pom5=false;
    this.robaForm=this.formBuilder.group({
      naziv:  [''],
      opis:  [''],
      kolicina:  [''],
      cena:  [''],
      rokIsporuke: [''],
      rokIsporukeMax:  [''],
      kupacOdgovoran:  [''],
      uputstvo:  [''],
      nesaobraznostZamenom:  [''],
      rokOdPrelaskaRizikaNaKupca:  [''],
      rokOdustanak:  [''],
      deoRobe: [''],
      rokVracanjaRobe:  [''],
      rokVracanjaNovca:  [''],
      izvrsiteljIsporuke:  [''],
      troskoveSnosi:  [''],
      troskoviOdustanak:  [''],
      brojPrimeraka:  [''],
      brojPrimeraKupac:  [''],
      slika:['']
    })
  }


  onSubmit() {
    if (this.pom==false){
      this.robaForm.controls['deoRobe'].setValue("PRVI");
    }
    if (this.pom1==false){
      this.robaForm.controls['kupacOdgovoran'].setValue(true);
    }
    if (this.pom2==false){
      this.robaForm.controls['uputstvo'].setValue(true);
    }
    if (this.pom3==false){
      this.robaForm.controls['nesaobraznostZamenom'].setValue(true);
    }
    if (this.pom4==false){
      this.robaForm.controls['troskoveSnosi'].setValue("KUPAC");
    }
    if (this.pom5==false){
      this.robaForm.controls['troskoviOdustanak'].setValue("KUPAC");
    }
    this.robaService.saveRoba(this.robaForm.value).subscribe(
      data => {
        console.log("roba Save" );
        console.log(data);
        this.router.navigateByUrl('/profile');
      }, error => {
        this.errorMessage = error.error.message;
        console.log("roba Save error " );
        console.log(this.errorMessage);
        alert("Došlo je do greške!");
      }

    );

  }

  onChangeKupacOdgovoran(value: any){
      this.pom1=true;

      console.log(value);
      if(value==0)
        this.robaForm.controls['kupacOdgovoran'].setValue(true);

      if(value==1)
        this.robaForm.controls['kupacOdgovoran'].setValue(false);

  }

  onChangeUputstvo(value: any){
    this.pom2=true;
    console.log(value);
    if(value==0)
      this.robaForm.controls['uputstvo'].setValue(true);
    if(value==1)
      this.robaForm.controls['uputstvo'].setValue(false);
  }

  onChangeNesaobraznostZamenom(value: any){
    this.pom3=true;
    console.log(value);
    if(value==0)
      this.robaForm.controls['nesaobraznostZamenom'].setValue(true);
    if(value==1)
      this.robaForm.controls['nesaobraznostZamenom'].setValue(false);
  }

  onChangeDeoRobe(value: any){
    this.pom=true;
    console.log(value);
    if(value==0)
      this.robaForm.controls['deoRobe'].setValue("PRVI");
    if(value==1)
      this.robaForm.controls['deoRobe'].setValue("POSLEDNJI");
  }

  onChangeTroskoveSnosi(value: any){
    this.pom4=true;
    console.log(value);
    if(value==0)
      this.robaForm.controls['troskoveSnosi'].setValue("KUPAC");
    if(value==1)
      this.robaForm.controls['troskoveSnosi'].setValue("PRODAVAC");
  }

  onChangeTroskoveSnosiOdustanak(value: any){
    this.pom5=true;
    console.log(value);
    if(value==0)
      this.robaForm.controls['troskoviOdustanak'].setValue("KUPAC");
    if(value==1)
      this.robaForm.controls['troskoviOdustanak'].setValue("PRODAVAC");
  }

  onSelectedImage(event) {
    console.log("event ");
    console.log(event);
    var reader = new FileReader();
    this.file = event.target.files;
    reader.readAsDataURL(event.target.files[0]);

    reader.onload = (event) => {
      this.file = reader.result;
      this.robaForm.controls['slika'].setValue(reader.result.toLocaleString().split(",")[1]);
    }

    if(event!=null)
      this.robaForm.controls['slika'].markAsTouched();
  }
}
