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

  private loginURL = 'http://localhost:8080/Project2/login';

  constructor(private http: HttpClient, private currentUser: CurrentUserService) { }
  user: User = new User();
  onSubmit() {
    console.log(this.user);
    let observable = this.http.post(this.loginURL, JSON.stringify(this.user))
    observable.subscribe((result: any) => {
      this.currentUser.user = result;
    })
  }

}
