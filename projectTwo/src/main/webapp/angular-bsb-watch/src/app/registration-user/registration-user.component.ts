import { Component, OnInit } from '@angular/core';
import { User } from "../user";
import { HttpClient } from '@angular/common/http';
import { CurrentUserService } from '../current-user.service';
import { Router } from '@angular/router';




@Component({
  selector: 'app-registration-user',
  templateUrl: './registration-user.component.html',
  styleUrls: ['./registration-user.component.css']
})
export class RegistrationUserComponent implements OnInit {

  constructor(
    private http: HttpClient, 
    private currentUser: CurrentUserService,
    private router: Router) {
  }

  ngOnInit() {

  }

  favoriteBoy: any;

  user: User = new User();

  registerUrl: string = "http://localhost:8080/Project2/addNewUser";


  onSubmit() {
    console.log(this.user);

    let observable = this.http.post(this.registerUrl, JSON.stringify(this.user));

    observable.subscribe(
      (result: any) => {
        this.currentUser.user = result;
        if (this.currentUser.user) {
          alert("Successfully registered!");
          this.router.navigate(['profile']);
        }
      },
      (err) => { alert("Information already recognized in database, please try again or login"); }
    )
  }
}
