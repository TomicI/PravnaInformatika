import { Component, Input, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {RobaService} from "../services/roba.service";
import {Roba, User} from "../model";
import {UserService} from "../services/user.service";

@Component({
  selector: 'app-details-roba',
  templateUrl: './details-roba.component.html',
  styleUrls: ['./details-roba.component.css'],
  providers: [ RobaService, UserService ]
})
export class DetailsRobaComponent implements OnInit {
  @Input() id: number;

  roba: Roba;
  user: User;

  constructor(private route: ActivatedRoute, private robaService: RobaService, private router: Router, private userService: UserService) { }

  ngOnInit() {
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

        this.userService.getUser().subscribe(data=>{
          this.user=data;
        });
      }
    });
  }

  kupi(id: any){
    console.log("kupi " + id);
    this.router.navigateByUrl('/app/kupovina/'+id);
  }

  ukloni(id: number){
    this.robaService.ukloni(id).then(data=>{
      console.log("ukloni");
      console.log(data);
    })
  }
}
