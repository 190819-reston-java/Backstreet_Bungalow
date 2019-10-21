import { Component, OnInit } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { HttpClient } from '@angular/common/http';
import { CurrentUserService } from '../current-user.service';
import { Photo } from '../photo';
import { User } from '../user';


@Component({
  selector: 'app-single-user-photos',
  templateUrl: './single-user-photos.component.html',
  styleUrls: ['./single-user-photos.component.css']
})
export class SingleUserPhotosComponent implements OnInit {

  constructor(
    private http: HttpClient,
    private currentUser: CurrentUserService) { }

  getPhotosUrl = "http://localhost:8080/Project2/picturesFromOneUser";
  photos: any;
  selectedUser: User = new User();




  getCurrentUserPhotos() {
    let observable = this.http.post(this.getPhotosUrl, this.currentUser.user.username)
    observable.subscribe((result: any) => { this.photos = result })
  }

  getSelectedUserPhotos(user: User) {
    let observable = this.http.post(this.getPhotosUrl, user.username)
    observable.subscribe((result: any) => { this.photos = result })
  }

  ngOnInit() {
      this.getCurrentUserPhotos();
   
  }



}
