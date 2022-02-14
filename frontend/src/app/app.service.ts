import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { User } from './user';
import { tap } from 'rxjs/operators';
import { UserRequest } from './requests/request';
import { UserRequestType } from './requests/requestType';

@Injectable({
  providedIn: 'root'
})
export class AppService {
  [x: string]: any;

  private appUrl = 'http://localhost:8080/';
  token!: string
  username!: string;

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(
    private http: HttpClient,
    private readonly httpClient: HttpClient) { }

  getToken(): string {
    return this.token;
  }

  isLoggedIn(): boolean {
    return !!this.token;
  }

  login(user : User): Observable<User> {
    const info = btoa(`${user.name}:${user.password}`);
    const token = `Basic ${info}`;
    const options = {
      headers: new HttpHeaders({
        Authorization: token,
        'X-Requested-With' : 'XMLHttpRequest'
      }),
      withCredentials: true
    };
    return this.httpClient.get<User>('http://localhost:8080/loginUser', options).pipe(
      tap(user => {
        this.username = user.name;
        this.token = token
      })
    );
  }

  getCurrentUser(){
    return this.httpClient.get<User>('http://localhost:8080/loginUser');
  }

  logout(): void {
    this.token = null;
  }

  register(user : User): Observable<any> {
    return this.http.post(`${this.appUrl}postUser`, user);
  }


  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.appUrl);
  }

  searchUsers(term: string): Observable<User[]> {
    if (!term.trim()) {
      return of([]);
    }
    return this.http.get<User[]>(`${this.appUrl}search?name=${term}`)
  }  
  //testing
    createRequest( reciever : User){
      this.getCurrentUser().subscribe(sender=> {
        var request : UserRequest = { sender : sender, reciever : reciever, requestType : UserRequestType.friendRequest }
        this.http.post<Request>(`${this.appUrl}newRequest`, request)
      })
    }

    getUser(id: number): Observable<User> {
      const url = `${this.appUrl}/${id}`;
      return this.http.get<User>(url);
    }
}
