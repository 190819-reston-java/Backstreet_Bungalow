import { Component, OnInit, Input } from '@angular/core';
import { User } from '../user';
import { USER } from '../mock-user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  constructor() { }
  
  ngOnInit() {
  }

}
