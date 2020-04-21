import {Component, Input, OnInit} from '@angular/core';
import { TokenService } from "../services/token.service";
import { Router } from "@angular/router";
import { UserService } from "../services/user.service";
import { RobaService } from "../services/roba.service";
import { Roba, User } from "../model";


@Component({
  selector: 'app-profil',
  templateUrl: './profil.component.html',
  styleUrls: ['./profil.component.css'],
  providers: [ TokenService, UserService, RobaService ]
})
export class ProfilComponent implements OnInit {
  @Input() id: number;

  user: User;
  roba: Roba[];
  robaKupljena: Roba[];
  robaProdata: Roba[];
  prikaziRobu: boolean;
  prikaziKupljenu: boolean;
  prikaziProdatu: boolean;
  umanjiCenu: number;

  constructor(private tokenService: TokenService, private router: Router,
              private userService: UserService, private robaService: RobaService) { }

  ngOnInit() {
    this.prikaziRobu=true;
    this.prikaziKupljenu=false;
    this.prikaziProdatu=false;
    this.umanjiCenu=0;
    console.log("token");
    console.log(this.tokenService.getToken());
    if(!this.tokenService.getToken()){
      console.log("ovde");
      this.router.navigateByUrl('/login');
    }else{
      console.log("ovdeeeee");
      this.userService.getUser().subscribe(data=>{
        this.user=data;
      });

      this.robaService.getRoba().then(data=>{
        this.roba=data;
      })
    }


  }

  prikazi(pom: number){
    if(pom==1){
      this.prikaziRobu=true;
    } else if(pom==2){
      if(this.robaKupljena==undefined){
        console.log("ovde kup");
        this.robaService.getRobaKupljena().then(data=>{
          console.log(data);
          this.robaKupljena=data;


        })
      }
      this.prikaziKupljenu=true;
    } else if(pom==3){
      if(this.robaProdata==undefined){
        console.log("ovde pr");
        this.robaService.getRobaProdata().then(data=>{
          console.log(data);
          this.robaProdata=data;

        })
      }
      this.prikaziProdatu=true;
    }

  }

  skloni(pom: number){
    if(pom==1){
      this.prikaziRobu=false;
    } else if(pom==2){
      this.prikaziKupljenu=false;
    } else if(pom==3){
      this.prikaziProdatu=false;
    }
  }


  ukloni(id: number){
    this.robaService.ukloni(id).then(data=>{
      console.log("ukloni");
      console.log(data);
    })
    window.location.reload();
  }

  robaPrimljena(id: number){
    this.robaService.robaIsporucena(id).then(data=>{
      console.log("roba primljena");
      console.log(data);
    })
    window.location.reload();
  }

  odustani(id: number){
    this.robaService.kupacOdustanak(id).then(data=>{
      console.log("roba odustanak");
      console.log(data);
    })
    window.location.reload();
  }

  nesaobraznost(id: number, pom: number){
      if(pom==1){
        this.robaService.saobraznost(id, true, false, 0).then(data=>{
          console.log("roba s zamena");
          console.log(data);
        })
      } else if(pom==2){
        this.robaService.saobraznost(id, false, true, 0).then(data=>{
          console.log("roba s odustanak");
          console.log(data);
        })
      } else if(pom==3){
        console.log("umanjenje");
        console.log(this.umanjiCenu);
        this.robaService.saobraznost(id, false, false, this.umanjiCenu).then(data=>{
          console.log("roba s umanjenje");
          console.log(data);
        })
      }
    //window.location.reload();
  }

  novacIsporucen(id: number){
    this.robaService.novacIsporucen(id).then(data=>{
      console.log("novac isporucen");
      console.log(data);
    })
    window.location.reload();
  }

  kupacNijePreuzeo(id: number){
    this.robaService.kupacNijePreuzeo(id).then(data=>{
      console.log("kupac nije preuzeo");
      console.log(data);
    })
    window.location.reload();
  }

  vracenaRobaIsporucena(id: number){
    this.robaService.robaIsporucenaVracena(id).then(data=>{
      console.log("vracena roba isporucena");
      console.log(data);
    })
    window.location.reload();
  }

  novacVracen(id: number){
    this.robaService.novacIsporucenVracen(id).then(data=>{
      console.log("novac vracen");
      console.log(data);
    })
    window.location.reload();
  }
}
