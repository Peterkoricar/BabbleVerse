import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { User } from './user';
import { tap } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class AppService {

  private appUrl = 'http://localhost:8080/';
  token!: string

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

  login(user : User): Observable<any> {
    const info = btoa(`${user.name}:${user.password}`);
    const name = user.name;
    const token = `Basic ${info}`;
    const options = { 
      headers: new HttpHeaders({
        Authorization: token,
        'X-Requested-With' : 'XMLHttpRequest'
      }),
      withCredentials: true
    };
    return this.httpClient.get('http://localhost:8080/loginUser', options).pipe(
      tap(() => this.token = token)
    );
  }
  getCurrentUser(){
    return this.httpClient.get('http://localhost:8080/loginUser');
  }

  logout(): void {
    //this.token = null;
  }

  register(user : User): Observable<any> {
    return this.http.post(`${this.appUrl}postUser`, user);
  }
  

  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.appUrl);
  }
}
