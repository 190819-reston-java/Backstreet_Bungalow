import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-latest-photos',
  templateUrl: './latest-photos.component.html',
  styleUrls: ['./latest-photos.component.css']
})
export class LatestPhotosComponent implements OnInit {

  constructor(private http: HttpClient) { }

  photos: any;

  ngOnInit() {
    let observable = this.http.get('https://newsapi.org/v2/everything?q=backstreetboys&apiKey=ace99d954335424582d108ce0a1872e4')
    observable.subscribe((result => {
      this.photos = result;
    }))
  }

}
