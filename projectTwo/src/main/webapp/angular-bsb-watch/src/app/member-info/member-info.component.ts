import { Component, OnInit } from '@angular/core';
import { BOYS }  from '../backstreet-boys-list';
import { BackstreetBoy } from '../backstreet-boy';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-member-info',
  templateUrl: './member-info.component.html',
  styleUrls: ['./member-info.component.css']
})
export class MemberInfoComponent implements OnInit {

  boys = BOYS;

  constructor(
    private route: ActivatedRoute,
  ) { }

  ngOnInit() {
  }

}
