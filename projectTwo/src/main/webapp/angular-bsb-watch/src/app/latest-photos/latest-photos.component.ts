import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserService } from '../user.service';
import { User } from '../user';

@Component({
  selector: 'app-latest-photos',
  templateUrl: './latest-photos.component.html',
  styleUrls: ['./latest-photos.component.css']
})
export class LatestPhotosComponent implements OnInit {

  constructor(
    private http: HttpClient,
    private userService: UserService) { }

  photoUser: User = new User();
  photos: any;
  latestPhotosUrl: string = "http://localhost8080/Project2/getRecentPhotos"
  getUserUrl: string = "http://localhost8080/Project2/getOneUser"

  ngOnInit() {
    let observable = this.http.get(this.latestPhotosUrl);
    observable.subscribe((result => {
      this.photos = result;
    }))
  }

  getUsernameForPhoto(username: number) {

    this.photoUser.id = id;
    let observable = this.userService.getUser(this.photoUser,this.getUserUrl);
    observable.subscribe(
      (result) => {

      }
    )
  }

}
