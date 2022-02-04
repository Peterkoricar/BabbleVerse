import { Component, OnInit } from '@angular/core';

import { Observable, Subject } from 'rxjs';

import { debounceTime, distinctUntilChanged, switchMap } from 'rxjs/operators';

import { User } from '../user';
import { AppService } from '../app.service';
import {MatIconRegistry} from '@angular/material/icon';


@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: [ './search.component.css' ]
})
export class SearchComponent implements OnInit {
  users$!: Observable<User[]>;
  private searchTerms = new Subject<string>();

  constructor(private appService: AppService, iconRegistry: MatIconRegistry,) {}

  search(term: string): void {
    this.searchTerms.next(term);
  }

  ngOnInit(): void {
      this.users$ = this.searchTerms.pipe(
      debounceTime(300),
      distinctUntilChanged(),
      switchMap((term: string) => this.appService.searchUsers(term)),
    );
  }
}