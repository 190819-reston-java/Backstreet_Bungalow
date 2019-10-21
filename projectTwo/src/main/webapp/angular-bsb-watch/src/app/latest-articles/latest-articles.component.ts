import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-latest-articles',
  templateUrl: './latest-articles.component.html',
  styleUrls: ['./latest-articles.component.css']
})
export class LatestArticlesComponent implements OnInit {

  constructor(private http: HttpClient) { }

  news: any;
    

  ngOnInit() {
    let observable = this.http.get('https://newsapi.org/v2/everything?qInTitle=backstreet&language=en&apiKey=ace99d954335424582d108ce0a1872e4')
    observable.subscribe(result => {
      this.news = result;
    })
  } 

}
