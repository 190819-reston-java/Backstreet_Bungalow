import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http'

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {

  
  constructor(private http: HttpClient) { }

  news: any;

  ngOnInit() {
    let observable = this.http.get('https://newsapi.org/v2/everything?q=backstreetboys&apiKey=ace99d954335424582d108ce0a1872e4')
    observable.subscribe((result => {
      this.news = result;
    }))
  }

  loggedIn=true;

}
