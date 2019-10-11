import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginImage:any = "assets\\images\\bb4.jpg";
  title = 'app';

  constructor() { }

  ngOnInit() {
  }

}
