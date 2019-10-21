import { Injectable } from '@angular/core';
import { User } from './user';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';





@Injectable({
  providedIn: 'root'
})
export class UserService {

  
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  

  constructor(private http: HttpClient) { }

   
  
  public getUser(user: User, url: string){
    return this.http.post(url, user);
  }

  public updateUser (user: User, url: string): Observable<any> {
    return this.http.put(url, user, this.httpOptions)
  }

  public createUser (user: User, url: string): Observable<any> {
    return this.http.post(url, user, this.httpOptions)
  }

  

}
