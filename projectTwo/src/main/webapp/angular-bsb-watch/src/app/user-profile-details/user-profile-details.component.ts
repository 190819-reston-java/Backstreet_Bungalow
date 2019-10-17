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

<<<<<<< HEAD
  
  constructor(private http: HttpClient, private currentUser: CurrentUserService) { }
=======
  user= USER;

  constructor(private http: HttpClient) { }
>>>>>>> f922c39d506bfac5233bcc02ce3fc2fa71fcb01c

  private updateUrl: string = "localhost:8080/user/update";

  @Input() user: User = this.currentUser.user;
  
  onSubmit(user: User)  {
    let observable = this.http.put(this.updateUrl, JSON.stringify(user))
    observable.subscribe((result: any) => {this.currentUser.user = result
    })
  }

  ngOnInit() {
  }

}
