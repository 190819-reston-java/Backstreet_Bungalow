import { Injectable } from '@angular/core';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class CurrentUserService {
  
  
  constructor() { }

  public user: User

  getUser()  {
    return this.user;
  }
}
