import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { SidebarComponent } from '../sidebar/sidebar.component';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private loginURL = '/login';

  onSubmit() {
    console.log("this works");
  } 

  loginImage:any = "assets\\images\\bb4.jpg";
  title = 'app';


  constructor(private http: HttpClient) { }

  sidebar;

  loggedIn() {
    this.sidebar.loggedIn = true;
  }

  ngOnInit() {
  }

}
