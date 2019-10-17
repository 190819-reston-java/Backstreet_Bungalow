import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CurrentUserService } from '../current-user.service';
import { BlogPost } from '../post';

@Component({
  selector: 'app-blog-post',
  templateUrl: './blog-post.component.html',
  styleUrls: ['./blog-post.component.css']
})
export class BlogPostComponent implements OnInit {

  constructor(private http: HttpClient, private currentUser: CurrentUserService) { }

  ngOnInit() {
  }

  post: BlogPost= new BlogPost();
  

  newBlogUrl: string = "localhost:8080/blog/create"

  onSubmit() {
    this.post.user = this.currentUser.user;
    let observable = this.http.post(this.newBlogUrl, JSON.stringify(this.post))
  }

}
