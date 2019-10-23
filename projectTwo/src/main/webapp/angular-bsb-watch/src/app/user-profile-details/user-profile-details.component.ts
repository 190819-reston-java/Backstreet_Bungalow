import { Component, OnInit, Input } from '@angular/core';
import { User } from '../user';
import { USER } from '../mock-user';
import { UserService } from '../user.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CurrentUserService } from '../current-user.service';


@Component({
  selector: 'app-user-profile-details',
  templateUrl: './user-profile-details.component.html',
  styleUrls: ['./user-profile-details.component.css']
})
export class UserProfileDetailsComponent implements OnInit {

  constructor(
    private http: HttpClient,
    private currentUser: CurrentUserService) { }

  private updateUrl: string = "http://localhost:8080/Project2/updateUser";
  private searchUrl: string = "http://localhost:8080/Project2/getOneUser"

  user: User = this.currentUser.getUser();
  @Input() selectedUser: User = this.currentUser.selectedUser;
  

  onSubmit(user: User) {

    let observable = this.http.post(this.updateUrl, JSON.stringify(user))

    console.log(user);

    observable.subscribe(
      (result: any) => {
        alert("Successfully updated information!");
      },
      (err) => { alert("Email already found in system"); }
    )
  }


  ngOnInit() {

  }

}
