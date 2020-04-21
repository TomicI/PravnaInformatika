import {Component, Input, OnInit} from '@angular/core';
import { TokenService } from "../services/token.service";
import {ActivatedRoute, Router} from "@angular/router";
import { UserService } from "../services/user.service";
import { Roba, User } from "../model";
import { RobaService } from "../services/roba.service";

@Component({
  selector: 'app-kupovina',
  templateUrl: './kupovina.component.html',
  styleUrls: ['./kupovina.component.css'],
  providers: [ TokenService, UserService, RobaService ]
})
export class KupovinaComponent implements OnInit {
  @Input() id: number;

  user: User;
  roba: Roba;

  constructor(private tokenService: TokenService, private router: Router,
              private route: ActivatedRoute, private userService: UserService,
              private robaService: RobaService) { }

  ngOnInit() {
    if(!this.tokenService.getToken()){
      console.log("ovde");
      alert("Morate biti ulogovani da bi nastavili kupovinu!");
      this.router.navigateByUrl('/login');
    }else {
      console.log("ovdeeeee");
      this.userService.getUser().subscribe(data=>{
        console.log("data");
        console.log(data);
        this.user=data;
        console.log("user");
        console.log(this.user);
      })

      this.route.params.subscribe
      ( params => {
        const id = params['id'];
        if (id) {
          console.log("id " + id);
          this.robaService.getRobaById(id).then(data=>{
              console.log("roba");
              this.roba=data;
              console.log(this.roba);

            }
          )
        }
      });
    }
  }

  odustani(){
      alert("Bicete preusmereni na pocetnu stranu!")
      this.router.navigateByUrl('/app');
  }

  kupi(){
    this.robaService.kupvina(this.roba.id).then(data=>{
      console.log("odgovor");
      console.log(data);
      alert("Kupovina je uspešno obavljena!");
      this.router.navigateByUrl('/profile');
    })
  }

}
