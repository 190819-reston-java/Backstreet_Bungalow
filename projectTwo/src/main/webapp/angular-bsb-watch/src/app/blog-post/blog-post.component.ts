import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CurrentUserService } from '../current-user.service';
import { BlogPost } from '../post';
import { Router } from '@angular/router';

@Component({
  selector: 'app-blog-post',
  templateUrl: './blog-post.component.html',
  styleUrls: ['./blog-post.component.css']
})
export class BlogPostComponent implements OnInit {

  constructor(
    private http: HttpClient, 
    private currentUser: CurrentUserService,
    private router: Router) { }

  ngOnInit() {
  }

  post: BlogPost = new BlogPost();
  resultPost: any;

  newBlogUrl: string = "http://localhost:8080/Project2/newPost"

  onSubmit() {
    this.post.userId = this.currentUser.user.id;
    this.post.username = this.currentUser.user.username;
    console.log(JSON.stringify(this.post));
    let observable = this.http.post(this.newBlogUrl, JSON.stringify(this.post));

    observable.subscribe(
      (result: any) => {
        this.resultPost = result;
        console.log(this.resultPost);
        alert("Successfully submitted!");
        this.router.navigate(['profile']);

      },
      (err) => { alert("Invalid submission, please try again") }
    );
  }

}
