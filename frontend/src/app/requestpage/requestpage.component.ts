import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { AppService } from '../app.service';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-requestpage',
  templateUrl: './requestpage.component.html',
  styleUrls: ['./requestpage.component.css']
})
export class RequestpageComponent implements OnInit {

  constructor(
    public appService: AppService,
    private route: ActivatedRoute,) { }

  
  users!: User[];
  user!: User;
  name!: User[];
  password!: User[];

  ngOnInit(): void {
    this.getUser();
  }

  getUser(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.appService.getUser(id)
      .subscribe(user => this.user = user);
  }
}
