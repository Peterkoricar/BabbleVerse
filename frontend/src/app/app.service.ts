import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { User } from './user';
import { tap } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class AppService {

  private appUrl = 'http://localhost:8080/api/goals';
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

  login(username: string, password: string): Observable<any> {
    const info = btoa(`${username}:${password}`);
    const token = `Basic ${info}`;
    const options = {
      headers: new HttpHeaders({
        Authorization: token,
        'X-Requested-With' : 'XMLHttpRequest'
      }),
      withCredentials: true
    };
    return this.httpClient.get('http://localhost:8080/user', options).pipe(
      tap(() => this.token = token)
    );
  }

  logout(): void {
    //this.token = null;
  }

  register(username: string, password: string, name: string, surname: string): Observable<any> {
    const user = { username, password, name, surname };
    return this.http.post(`${this.appUrl}/registration`, user);
  }

  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.appUrl);
  }
}
