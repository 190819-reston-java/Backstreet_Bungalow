import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SingleUserPendingPostsComponent } from './single-user-pending-posts.component';

describe('SingleUserPendingPostsComponent', () => {
  let component: SingleUserPendingPostsComponent;
  let fixture: ComponentFixture<SingleUserPendingPostsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SingleUserPendingPostsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SingleUserPendingPostsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
