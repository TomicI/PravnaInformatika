import { Component, OnInit } from '@angular/core';
import {FormGroup, FormBuilder, Validators, FormControl} from '@angular/forms';
import { ConfirmPasswordValidator } from './confirm-password-validator';
import {UserService} from "../services/user.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-signup-form',
  templateUrl: './signup-form.component.html',
  styleUrls: ['./signup-form.component.css'],
  providers: [UserService]
})
export class SignupFormComponent implements OnInit {

  signUpForm: FormGroup;
  isSignedUp = false;
  isSignUpFailed = false;
  errorMessage = '';

  constructor(private formBuilder: FormBuilder, private userService: UserService, private router: Router) { }

  ngOnInit() {

    this.signUpForm = this.formBuilder.group({
      firstName: new FormControl('', [Validators.minLength(3), Validators.required]),
      lastName: [''],
      city:[''],
      phone:[''],
      username: [''],
      email: [''],
      password: [''],
      passwordConfirm: ['']
    }, {
      validator: ConfirmPasswordValidator.validate.bind(this)

    });

  }

  onSubmit() {

    this.userService.saveUser(this.signUpForm.value).subscribe(
      data => {
        this.isSignedUp = true;
        this.isSignUpFailed = false
        alert('User registered!');
        this.router.navigateByUrl('/login');
      }, error => {
        this.errorMessage = error.error.message;
        this.isSignUpFailed = true;
        alert('Doslo je do greske!');
      }

    );


  }

}
