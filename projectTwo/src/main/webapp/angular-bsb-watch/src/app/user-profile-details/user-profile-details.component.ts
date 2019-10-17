import { Component, OnInit, Input } from '@angular/core';
import { User } from '../user';
import { USER } from '../mock-user';
import { UserService } from '../user.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';


@Component({
  selector: 'app-user-profile-details',
  templateUrl: './user-profile-details.component.html',
  styleUrls: ['./user-profile-details.component.css']
})
export class UserProfileDetailsComponent implements OnInit {

  user= USER;

  constructor(private http: HttpClient) { }

  save(user: User): void {
    console.log(user.first_name);
    console.log(user.last_name);
    console.log(user.username);
    console.log(user.email);
  }

  
  result: any;
  UrlEndpoint: string = "localhost:4200/register/new";

  submit(u: User) {
    this.http.post(this.UrlEndpoint, JSON.stringify(u)).subscribe(
      res => this.result = res)    
  }


  ngOnInit() {
  }

}
