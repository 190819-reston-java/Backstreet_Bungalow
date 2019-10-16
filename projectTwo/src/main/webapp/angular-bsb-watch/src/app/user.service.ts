import { Injectable } from '@angular/core';
import { User } from './user';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';





@Injectable({
  providedIn: 'root'
})
export class UserService {

  url = "user/update"
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) { }
  
  public getUser(user: User){
    return this.http.get('/user/info')
  }

  updateUser (user: User): Observable<any> {
    return this.http.put(this.url, user, this.httpOptions)
  }

  createUser(user: User) {

  }

}
