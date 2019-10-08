import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { LatestArticlesComponent } from './latest-articles/latest-articles.component';
import { MusicInfoComponent } from './music-info/music-info.component';
import { MemberInfoComponent } from './member-info/member-info.component';
import { LatestPhotosComponent } from './latest-photos/latest-photos.component';
import { LatestBlogPostsComponent } from './latest-blog-posts/latest-blog-posts.component';
import { UploadPostComponent } from './upload-post/upload-post.component';
import { CommentsComponent } from './comments/comments.component';
import { PopularPhotosComponent } from './popular-photos/popular-photos.component';
import { PopularBlogPostsComponent } from './popular-blog-posts/popular-blog-posts.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { SingleUserPostsComponent } from './single-user-posts/single-user-posts.component';
import { TwitterFeedComponent } from './twitter-feed/twitter-feed.component';
import { AdminPageComponent } from './admin-page/admin-page.component';
import { MessagesComponent } from './messages/messages.component';
import { LocationComponent } from './location/location.component';
import { PendingPhotosComponent } from './pending-photos/pending-photos.component';
import { PendingPostsComponent } from './pending-posts/pending-posts.component';
import { UserStatisticsComponent } from './user-statistics/user-statistics.component';
import { SingleUserPendingPostsComponent } from './single-user-pending-posts/single-user-pending-posts.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { SidebarComponent } from './sidebar/sidebar.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    LatestArticlesComponent,
    MusicInfoComponent,
    MemberInfoComponent,
    LatestPhotosComponent,
    LatestBlogPostsComponent,
    UploadPostComponent,
    CommentsComponent,
    PopularPhotosComponent,
    PopularBlogPostsComponent,
    UserProfileComponent,
    SingleUserPostsComponent,
    TwitterFeedComponent,
    AdminPageComponent,
    MessagesComponent,
    LocationComponent,
    PendingPhotosComponent,
    PendingPostsComponent,
    UserStatisticsComponent,
    SingleUserPendingPostsComponent,
    HeaderComponent,
    FooterComponent,
    SidebarComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
