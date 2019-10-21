import { Component, OnInit, Input } from '@angular/core';
import { User } from '../user';
import { USER } from '../mock-user';
import { UserService } from '../user.service';
import { CurrentUserService } from '../current-user.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  private searchUrl: string = "http://localhost:8080/Project2/getOneUser"
  selectedUser: User = new User();


  constructor(
    private currentUser: CurrentUserService,
    private http: HttpClient
  ) { }
  
  ngOnInit() {
  }

  onSearch(selectedUser: User) {
    console.log(this.currentUser.validSelectedUser);
    let observable = this.http.post(this.searchUrl, JSON.stringify(selectedUser))

    observable.subscribe(
      (result: any) => {
        this.selectedUser = result;
        this.selectedUser.password = "";
        this.currentUser.validSelectedUser = true;
        this.currentUser.selectedUser = result;
      },
      (err) => { alert("User does not exist"); }
    )
  }

}
