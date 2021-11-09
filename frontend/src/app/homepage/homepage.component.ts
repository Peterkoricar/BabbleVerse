import { Component, OnInit } from '@angular/core';
import { MessageService } from '../message.service';
import { User } from '../user';
import { AppService } from '../app.service';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {

  constructor(
    public appService: AppService, public messageService: MessageService) { }


  
  greeting: any;
  input!: string;
  user!: User;

  ngOnInit() {
   
  }

  
  sendMessage() {
    if (this.input) {
      this.input = this.appService.username + ':' + this.input;
      this.messageService.sendMessage(this.input);
      this.input = '';
    }

}
}
