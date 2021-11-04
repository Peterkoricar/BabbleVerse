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
    private readonly appService: AppService,) { }


  messageService!: MessageService;
  greeting: any;
  input!: string;
  name!: string;
  ngOnInit() {
    this.messageService = new MessageService();
    this.name = this.appService.getCurrentUser();
  }

  
  sendMessage() {
    if (this.input) {
      this.messageService.sendMessage(this.input);
      this.input = '';
    }

}
}
