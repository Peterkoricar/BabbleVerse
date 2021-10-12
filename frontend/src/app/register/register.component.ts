import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import { AppService } from '../app.service';
import { Router } from '@angular/router';

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
      this.appService.register(name, password)
        .subscribe(() => {
          this.appService.login(name, password)
            .subscribe(() => this.router.navigateByUrl('/login'));
        });
    }
  }
}