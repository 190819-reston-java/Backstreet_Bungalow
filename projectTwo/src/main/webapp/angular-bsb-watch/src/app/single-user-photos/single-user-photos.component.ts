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

  constructor(private http: HttpClient, private currentUser: CurrentUserService) { }

  photo = new Photo;
  
  getPhotosUrl = "";

  selectedUser = new User;




  getCurrentUserPost() {
    let observable = this.http.post(this.getPhotosUrl, this.currentUser.user.username)
      observable.subscribe((result: any) => {this.photo = result})
  }

  getSelectedUserPost(user: User) {
    let observable = this.http.post(this.getPhotosUrl, user.username)
      observable.subscribe((result: any) => {this.photo = result})
  }

  ngOnInit() {
    if(this.selectedUser === null) {
      this.getCurrentUserPost();
    } else if(this.selectedUser !== null){
      this.getSelectedUserPost(this.selectedUser);
    }
  }

  

}
