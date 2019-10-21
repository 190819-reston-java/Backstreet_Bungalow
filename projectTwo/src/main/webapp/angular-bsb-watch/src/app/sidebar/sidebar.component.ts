import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { CurrentUserService } from '../current-user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {

  
  constructor(
    private http: HttpClient,
    private currentUser: CurrentUserService,
    private router: Router) { }

  news: any;

  ngOnInit() {
    let observable = this.http.get('https://newsapi.org/v2/everything?q=backstreetboys&apiKey=ace99d954335424582d108ce0a1872e4')
    observable.subscribe((result => {
      this.news = result;
    }))
  }

  clickLogout() {
    this.currentUser.user = undefined;
    this.router.navigate(['login']);
  }

  loggedIn=true;

}
