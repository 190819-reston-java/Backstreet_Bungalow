import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CurrentUserService } from './current-user.service';
import { User } from './user';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(
    private router: Router,
    private currentUser: CurrentUserService
  ) {
    if (typeof this.currentUser.getUser() !== undefined) {
      console.log(this.currentUser.getUser());

      this.router.navigate(['login']);
    }
  }



  title = 'angular-bsb-watch';
  lat = 38.953546;
  lng = -77.350469;
}
