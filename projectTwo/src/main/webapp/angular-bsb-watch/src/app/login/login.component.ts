import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { SidebarComponent } from '../sidebar/sidebar.component';
import { CurrentUserService } from '../current-user.service';
import { User } from '../user';




@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  ngOnInit(): void {
    
  }

<<<<<<< HEAD
  private loginURL = '/login';

  onSubmit() {
    console.log("this works");
  } 

  loginImage:any = "assets\\images\\bb4.jpg";
  title = 'app';


  constructor(private http: HttpClient) { }

  sidebar;
=======
  private loginURL = 'localhost:8080/login';
  private user: User;
>>>>>>> b2ae4300029e7383df74339c241c538913b81666

  constructor(private http: HttpClient, private currentUser: CurrentUserService) { }

  onSubmit(user: User)  {
    let observable = this.http.post(this.loginURL, JSON.stringify(user.username))
    observable.subscribe((result: any) => {this.currentUser.user = result;
    })
  }

}
