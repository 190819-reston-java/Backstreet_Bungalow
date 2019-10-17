import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CommonModule } from '@angular/common';

import { UserProfileComponent } from './user-profile/user-profile.component';
import { LatestArticlesComponent } from './latest-articles/latest-articles.component';
import { MemberSectionComponent } from './member-section/member-section.component';
import { UserProfileDetailsComponent } from './user-profile-details/user-profile-details.component';
import { MusicInfoComponent } from './music-info/music-info.component';
import { LatestPhotosComponent } from './latest-photos/latest-photos.component';
import { LatestBlogPostsComponent } from './latest-blog-posts/latest-blog-posts.component';
import { PopularSectionComponent } from './popular-section/popular-section.component';
import { LocationComponent } from './location/location.component';
import { LoginComponent } from './login/login.component';
import { RegistrationUserComponent } from './registration-user/registration-user.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { AppComponent } from './app.component';

const routes: Routes = [
  { path: 'profile', component: UserProfileComponent },
  { path: 'latest-articles', component: LatestArticlesComponent },
  { path: 'members', component: MemberSectionComponent },
  { path: 'music', component: MusicInfoComponent },
  { path: 'photos', component: LatestPhotosComponent },
  { path: 'blog-posts', component: LatestBlogPostsComponent },
  { path: 'popular', component: PopularSectionComponent },
  { path: 'location', component: LocationComponent },
  // { path: '', redirectTo: '/profile', pathMatch: 'full' },
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'main', component: AppComponent },
  { path: 'profile/:id', component: UserProfileDetailsComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegistrationUserComponent}
]


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes, {
      scrollPositionRestoration: 'enabled',
      anchorScrolling: 'enabled',
      scrollOffset: [0,64],
    }),
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
