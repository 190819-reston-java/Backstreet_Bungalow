import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-latest-blog-posts',
  templateUrl: './latest-blog-posts.component.html',
  styleUrls: ['./latest-blog-posts.component.css']
})
export class LatestBlogPostsComponent implements OnInit {

  constructor(
    private http: HttpClient

  ) { }

    posts: any;
    getLatestPostsUrl = "http://localhost:8080/Project2/getRecentPosts";



  ngOnInit() {
    
  }

  
  getPosts() {
    let observable = this.http.get(this.getLatestPostsUrl);
    // observable.subscribe(
    //   (result: any));

  }


}
