import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PopularBlogPostsComponent } from './popular-blog-posts.component';

describe('PopularBlogPostsComponent', () => {
  let component: PopularBlogPostsComponent;
  let fixture: ComponentFixture<PopularBlogPostsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PopularBlogPostsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PopularBlogPostsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
