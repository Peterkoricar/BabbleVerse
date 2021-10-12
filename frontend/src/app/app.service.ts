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

  login(name: string, password: string): Observable<any> {
    const info = btoa(`${name}:${password}`);
    const token = `Basic ${info}`;
    const options = {
      headers: new HttpHeaders({
        Authorization: token,
        'X-Requested-With' : 'XMLHttpRequest'
      }),
      withCredentials: true
    };
    return this.httpClient.get('http://localhost:8080/getUser', options).pipe(
      tap(() => this.token = token)
    );
  }

  logout(): void {
    //this.token = null;
  }

  register(name: string, password: string): Observable<any> {
    const user = { name, password };
    return this.http.post(`${this.appUrl}saveUser`, user);
  }

  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.appUrl);
  }
}
