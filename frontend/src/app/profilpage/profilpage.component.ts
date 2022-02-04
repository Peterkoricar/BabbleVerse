import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { AppService } from '../app.service';



@Component({
  selector: 'app-profilpage',
  templateUrl: './profilpage.component.html',
  styleUrls: ['./profilpage.component.css']
})
export class ProfilpageComponent implements OnInit {

  constructor(public appService: AppService) { }

  users!: User[];
  name!: User[];
  password!: User[];

  ngOnInit(): void {
    this.getUsers();
  }

    getUsers(): void {
      this.appService.getUsers()
          .subscribe(users => this.users = users);
    }

}
