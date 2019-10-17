import { Component, OnInit } from '@angular/core';
import { User } from "../user";
import { HttpClient } from '@angular/common/http';
import { CurrentUserService } from '../current-user.service';
 



@Component({
  selector: 'app-registration-user',
  templateUrl: './registration-user.component.html',
  styleUrls: ['./registration-user.component.css']
})
export class RegistrationUserComponent implements OnInit {

  constructor(private http: HttpClient, private currentUser: CurrentUserService) { }

  ngOnInit() {
  }
   
  registerUrl: string = "localhost:4200/register/new";

  onSubmit(user: User)  {
    let observable = this.http.post(this.registerUrl, JSON.stringify(user))
    observable.subscribe((result: any) => {this.currentUser.user = result;
    })
  }
}
