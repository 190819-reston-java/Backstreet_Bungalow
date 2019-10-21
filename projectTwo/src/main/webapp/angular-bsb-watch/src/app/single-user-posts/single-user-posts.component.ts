import { Component, OnInit } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { HttpClient } from '@angular/common/http';
import { CurrentUserService } from '../current-user.service';
import { BlogPost } from '../post';
import { User } from '../user';

@Component({
  selector: 'app-single-user-posts',
  templateUrl: './single-user-posts.component.html',
  styleUrls: ['./single-user-posts.component.css']
})
export class SingleUserPostsComponent implements OnInit {

  constructor(private http: HttpClient, private currentUser: CurrentUserService) { }

  getPostsUrl = "";

  post = new BlogPost;

  selectedUser = new User;

  getCurrentUserPost() {
    let observable = this.http.post(this.getPostsUrl, this.currentUser.user.username)
      observable.subscribe((result: any) => {this.post = result})
  }

  getSelectedUserPost(user: User) {
    let observable = this.http.post(this.getPostsUrl, user.username)
      observable.subscribe((result: any) => {this.post = result})
  }

  ngOnInit() {
    if(this.selectedUser === null) {
      this.getCurrentUserPost();
    } else if(this.selectedUser !== null){
      this.getSelectedUserPost(this.selectedUser);
    }
  }

  
}
