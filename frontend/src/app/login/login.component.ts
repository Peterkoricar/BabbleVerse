import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AppService } from '../app.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  hide = true;
  loginGroup = new FormGroup({
    name: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required)
  });


  constructor(
    private readonly appService: AppService,
    private readonly router: Router) { }

    name!: string; // vymazat po teste
    password!: string; //

  ngOnInit() {
  }

  login(): void {
    if (this.loginGroup.valid) {
      const name = this.loginGroup.value.name;
      const password = this.loginGroup.value.password;
      this.appService.login(name, password)
        .subscribe(() => this.router.navigateByUrl('/homepage'));
    }
    else {
      alert("Name or password are invalid");
    }
    /*login() : void {
      if(this.username == 'admin' && this.password == 'admin'){
       this.router.navigate(["homepage"]);}
      else if (this.username == 'user' && this.password == 'user'){
      this.router.navigate(["homepage"]);}
      else {
        alert("Username or password are invalid");
      }*/
  }

}
