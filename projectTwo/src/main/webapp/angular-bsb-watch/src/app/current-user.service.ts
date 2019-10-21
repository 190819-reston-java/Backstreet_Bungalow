import { Injectable } from '@angular/core';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class CurrentUserService {
  
  
  constructor() { }

  public user: User;
  public selectedUser: User = new User();
  public validSelectedUser: boolean = false;

  getUser()  {
    return this.user;
  }

  getSelectedUser() {
    return this.selectedUser;
  }
}
