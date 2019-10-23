import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserService } from '../user.service';
import { User } from '../user';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-latest-photos',
  templateUrl: './latest-photos.component.html',
  styleUrls: ['./latest-photos.component.css']
})
export class LatestPhotosComponent implements OnInit {

  constructor(
    private http: HttpClient,
    private domSanitizer: DomSanitizer) { }

  photos: any;
  latestPhotosUrl: string = "http://localhost:8080/Project2/getRecentPhotos"

  ngOnInit() {
    this.getPhotos();
  }

  getPhotos() {
    console.log("bike");
    let observable = this.http.get(this.latestPhotosUrl);
    observable.subscribe(
      (result: any) => {
      this.photos = result;
      console.log("foo");},
      (err) => { console.log("invalid"); }
    )
  }


}
