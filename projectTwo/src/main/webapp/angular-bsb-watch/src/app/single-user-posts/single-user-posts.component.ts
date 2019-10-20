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

  getPostsUrl = "http://localhost:8080/Project2/postsFromOneUser";

  posts: any;

  selectedUser = new User;

  getCurrentUserPost() {
    console.log(JSON.stringify(this.currentUser.user));
    let observable = this.http.post(this.getPostsUrl, JSON.stringify(this.currentUser.user))
      observable.subscribe((result: any) => {this.posts = result})
  }

  getSelectedUserPost(user: User) {
    let observable = this.http.post(this.getPostsUrl, user.username)
      observable.subscribe((result: any) => {this.posts = result})
  }

  ngOnInit() {
    // if(this.selectedUser === null) {
    //   this.getCurrentUserPost();
    // } else if(this.selectedUser !== null){
    //   this.getSelectedUserPost(this.selectedUser);
    // }
    this.getCurrentUserPost();
  }

  
}
