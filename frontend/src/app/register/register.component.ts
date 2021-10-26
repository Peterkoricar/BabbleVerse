import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import { AppService } from '../app.service';
import { Router } from '@angular/router';
import { User } from '../user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  hide = true;
  /*email = new FormControl('', [Validators.required, Validators.email]);*/
  registerGroup = new FormGroup({
    name: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
  });

  /*getErrorMessage() {
    if (this.email.hasError('required')) {
      return 'You must enter a value';
    }

    return this.email.hasError('email') ? 'Not a valid email' : '';
  }*/

  constructor(
    private appService: AppService,
    private readonly router: Router
  ) { }

  ngOnInit(): void {
  }

  register(): void {
    if (this.registerGroup.valid) {
      const password = this.registerGroup.value.password;
      const name = this.registerGroup.value.name;
      var user : User = {name : name , password : password} as User;
      this.appService.register(user)
        .subscribe(() => {
          this.appService.login(user)
            .subscribe(() => this.router.navigateByUrl('/login'));
        });
    }
  }
}